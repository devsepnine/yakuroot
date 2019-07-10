package notice_board.beans;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice_comment.beans.CommentDao;
import notice_comment.beans.CommentDto;
import notice_board.beans.paging;

@WebServlet(urlPatterns = "/board/notice_content.do")
public class n_board_content extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//글 번호를 조회하여 내용을 저장
			int no = Integer.parseInt(req.getParameter("no"));
			n_boardDao ndao = new n_boardDao();
			ndao.readone(no);
			n_boardDto ndto = ndao.get(no);
			
			boolean my = ndto.getN_writer().equals(req.getSession().getAttribute("login"));

			CommentDao cdao = new CommentDao();
			List<CommentDto> list = cdao.get(no);
			paging p = new paging(req);
			p.calculate();

			req.setAttribute("list2", list);
			req.setAttribute("my", my);
			req.setAttribute("ndto", ndto);
			req.setAttribute("p", p);

			RequestDispatcher dispatcher = req.getRequestDispatcher("/board/notice_content.jsp");
			dispatcher.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			resp.sendError(500);

		}
	}
}
