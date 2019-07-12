package q_board.beans;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import q_board.beans.paging;
import q_comment.beans.CommentDao;
import q_comment.beans.CommentDto;
@WebServlet(urlPatterns="/board/q_content.do")
public class q_board_content extends HttpServlet{
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	try {
		req.setCharacterEncoding("UTF-8");
		int no = Integer.parseInt(req.getParameter("no"));
		q_boardDao qdao = new q_boardDao();
		qdao.readone(no);
		q_boardDto qdto = qdao.get(no);
//		boolean my = qdto.getQ_writer().equals(req.getParameter("login"));
		
		CommentDao cdao = new CommentDao();
		List<CommentDto> list = cdao.get(no);
		paging p = new paging(req);
		p.calculate();
		
		req.setAttribute("list2", list);
//		req.setAttribute("my", my);
		req.setAttribute("qdto", qdto);
		req.setAttribute("p", p);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/board/q_content.jsp");
		dispatcher.forward(req, resp);
		
	}catch (Exception e) {
		e.printStackTrace();
		resp.sendError(500);
	}
}
}
