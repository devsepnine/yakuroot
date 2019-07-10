package notice_board.beans;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice_board.beans.n_boardDao;
import notice_board.beans.n_boardDto;
@WebServlet(urlPatterns="/board/n_delete.do")
public class n_board_delete extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			n_boardDao ndao = new n_boardDao();
			n_boardDto ndto = new n_boardDto();
			ndto.setN_no(Integer.parseInt(req.getParameter("n_no")));
			ndao.delete(ndto.getN_no());
			RequestDispatcher dispatcher = req.getRequestDispatcher("/board/notice_list.do");
			dispatcher.forward(req, resp);
			
			
		}catch (Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}
