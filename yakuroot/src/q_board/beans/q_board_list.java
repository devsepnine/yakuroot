package q_board.beans;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns="/board/q_list.do")
public class q_board_list extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setCharacterEncoding("UTF-8");
			paging p = new paging(req);
			p.calculate();
			req.setAttribute("p", p);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/board/q_list.jsp");
			dispatcher.forward(req, resp);

			
		}catch (Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}

}
