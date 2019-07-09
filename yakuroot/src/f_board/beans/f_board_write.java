package f_board.beans;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import f_board.beans.f_boardDao;
import f_board.beans.f_boardDto;
@WebServlet(urlPatterns="/board/f_write.do")
public class f_board_write extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/board/f_write.jsp");
		dispatcher.forward(req, resp);

	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setCharacterEncoding("utf-8");
			//select board_seq.nextval from dual;
			f_boardDao bdao = new f_boardDao();
			String f_head = req.getParameter("f_head");
			String f_title = req.getParameter("f_title");
			String f_writer = req.getParameter("f_writer");
			String f_content = req.getParameter("f_content");
			
			f_boardDto bdto = new f_boardDto();
			if(req.getParameterMap().containsKey("f_parent")) {
				bdto.setF_parent(Integer.parseInt(req.getParameter("f_parent")));
			}
			
			bdto.setF_head(f_head);
			bdto.setF_title(f_title);
			bdto.setF_writer(f_writer);
			bdto.setF_content(f_content);
			bdao.write(bdto);
			
			resp.sendRedirect(req.getContextPath()+"/board/f_list.do");
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}

}
