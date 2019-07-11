package g_board.beans;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns="/board/g_write.do")
public class g_board_write extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/board/g_write.jsp");
		dispatcher.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setCharacterEncoding("utf-8");
		g_boardDao gdao = new g_boardDao();
		String g_head = req.getParameter("g_head");
		String g_title = req.getParameter("g_title");
		String g_writer = req.getParameter("g_writer");
		String g_content = req.getParameter("g_content");
		
		g_boardDto gdto = new g_boardDto();
		if(req.getParameterMap().containsKey("g_parent")) {
			gdto.setG_parent(Integer.parseInt(req.getParameter("g_parent")));
		}
		
		gdto.setG_head(g_head);
		gdto.setG_title(g_title);
		gdto.setG_writer(g_writer);
		gdto.setG_content(g_content);
		gdao.write(gdto);
		
		resp.sendRedirect(req.getContextPath()+"/board/g_list.do");
		
		}catch (Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}

}
