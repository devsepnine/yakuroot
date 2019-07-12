package q_board.beans;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns="/board/q_delete.do")
public class q_board_delete extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			q_boardDao qdao = new q_boardDao();
			q_boardDto qdto = new q_boardDto();
			qdto.setQ_no(Integer.parseInt(req.getParameter("no")));
			qdao.delete(qdto.getQ_no());
			RequestDispatcher dispatcher = req.getRequestDispatcher("/board/q_list.do");
			dispatcher.forward(req, resp);
			
			
		}catch (Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}

}
