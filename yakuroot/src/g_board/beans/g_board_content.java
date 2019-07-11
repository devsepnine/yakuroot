package g_board.beans;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import g_comment.beans.CommentDao;
import g_comment.beans.CommentDto;


@WebServlet(urlPatterns="/board/g_content.do")
public class g_board_content extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setCharacterEncoding("utf-8");
			int no = Integer.parseInt(req.getParameter("no"));
			g_boardDao gdao = new g_boardDao();
			
			gdao.readone(no);
			
			g_boardDto gdto = gdao.get(no);
			
			boolean my = gdto.getG_writer().equals(req.getSession().getAttribute("login"));
			
			CommentDao cdao = new CommentDao();
			List<CommentDto> list = cdao.get(no);
			paging p = new paging(req);
			p.calculate();
			
			req.setAttribute("list2", list);
			req.setAttribute("my", my);
			req.setAttribute("gdto", gdto);
			req.setAttribute("p", p);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("/board/g_content.jsp");
			dispatcher.forward(req, resp);
		}catch (Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}

}
