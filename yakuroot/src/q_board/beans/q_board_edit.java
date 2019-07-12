package q_board.beans;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns="/board/q_edit.do")
public class q_board_edit extends HttpServlet{
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setCharacterEncoding("UTF-8");
			q_boardDao qdao = new q_boardDao();
			int no = Integer.parseInt(req.getParameter("q_no"));
			q_boardDto qdto = qdao.get(no);
			req.setAttribute("qdto", qdto);
			
		}catch (Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	try {
		req.setCharacterEncoding("UTF-8");
		q_boardDao qdao = new q_boardDao();
		q_boardDto qdto = new q_boardDto();
		String head = req.getParameter("q_head");
		String title = req.getParameter("q_title");
		String content = req.getParameter("q_content");
		int no = Integer.parseInt(req.getParameter("q_no"));
		qdto.setQ_head(head);
		qdto.setQ_title(title);
		qdto.setQ_content(content);
		qdto.setQ_no(no);
		
		qdao.edit(qdto);
		RequestDispatcher dispatcher = req.getRequestDispatcher("q_content.do?no="+qdto.getQ_no());
		dispatcher.forward(req, resp);
		
	}catch (Exception e) {
		e.printStackTrace();
		resp.sendError(500);
	}
}
}
