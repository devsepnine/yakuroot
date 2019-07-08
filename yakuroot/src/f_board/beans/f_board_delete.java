package f_board.beans;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns="/board/f_delete.do")
public class f_board_delete extends HttpServlet{
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	try {
		f_boardDao bdao = new f_boardDao();
		f_boardDto bdto = new f_boardDto();
		bdto.setF_no(Integer.parseInt(req.getParameter("no")));
		bdao.delete(bdto.getF_no());
		RequestDispatcher dispatcher = req.getRequestDispatcher("/board/f_list.do");
		dispatcher.forward(req, resp);
		
		
	}catch (Exception e) {
		e.printStackTrace();
		resp.sendError(500);
	}
}
}
