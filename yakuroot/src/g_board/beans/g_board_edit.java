package g_board.beans;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns="/board/g_edit.do")
public class g_board_edit extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setCharacterEncoding("utf-8");
			g_boardDao gdao = new g_boardDao();
			int no = Integer.parseInt(req.getParameter("g_no"));
			g_boardDto gdto = gdao.get(no);
			
			req.setAttribute("gdto", gdto);
			
		}catch (Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	try {
		req.setCharacterEncoding("utf-8");
		g_boardDao gdao = new g_boardDao();
		g_boardDto gdto = new g_boardDto();
		String head = req.getParameter("g_head");
		String title = req.getParameter("g_title");
		String content = req.getParameter("g_content");
		int no = Integer.parseInt(req.getParameter("g_no"));
		gdto.setG_head(head);
		gdto.setG_title(title);
		gdto.setG_content(content);
		gdto.setG_no(no);
		
		gdao.edit(gdto);
		resp.sendRedirect("g_content.do?no="+gdto.getG_no());
		
		
		
		
		
		
	}catch (Exception e) {
		e.printStackTrace();
		resp.sendError(500);
	}
	}

}
