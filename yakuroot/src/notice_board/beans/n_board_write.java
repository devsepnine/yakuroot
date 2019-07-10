package notice_board.beans;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import f_board.beans.f_boardDao;
import f_board.beans.f_boardDto;
@WebServlet(urlPatterns="/notice_write.do")
public class n_board_write extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/board/notice_write.jsp");
		dispatcher.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setCharacterEncoding("utf-8");
			n_boardDao ndao = new n_boardDao();
			String n_head = req.getParameter("n_head");
			String n_title = req.getParameter("n_title");
			String n_writer = req.getParameter("n_writer");
			String n_content = req.getParameter("n_content");
			
			n_boardDto ndto = new n_boardDto();
			ndto.setN_head(n_head);
			ndto.setN_title(n_title);
			ndto.setN_writer(n_writer);
			ndto.setN_content(n_content);
			ndao.write(ndto);
			
			resp.sendRedirect(req.getContextPath()+"/board/n_list.do");
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}

}
