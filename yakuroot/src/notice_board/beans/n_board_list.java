package notice_board.beans;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice_board.beans.paging;
@WebServlet(urlPatterns="/board/notice_list.do")
public class n_board_list extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			paging p = new paging(req);
			p.calculate();
			req.setAttribute("p", p);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/board/notice_list.jsp");
			dispatcher.forward(req, resp);

		} catch (Exception e) {
			resp.sendError(500);
			e.printStackTrace();
		}
	}
	}


