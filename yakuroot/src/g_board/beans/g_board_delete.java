package g_board.beans;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns="/board/g_delete.do")
public class g_board_delete extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
		g_boardDao gdao = new g_boardDao();
		g_boardDto gdto = new g_boardDto();
		gdto.setG_no(Integer.parseInt(req.getParameter("no")));
		gdao.delete(gdto.getG_no());
		RequestDispatcher dispatcher = req.getRequestDispatcher("/board/g_list.do");
		dispatcher.forward(req, resp);
		
		}catch (Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}

}
