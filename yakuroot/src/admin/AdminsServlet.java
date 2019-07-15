package admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import f_board.beans.f_boardDao;
import g_board.beans.g_boardDao;
import member.beans.MemberDao;

@WebServlet(urlPatterns="/admin/admins.do")
public class AdminsServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			MemberDao mdao = new MemberDao();
			f_boardDao fdao = new f_boardDao();
			g_boardDao gdao = new g_boardDao();
			
			int memberCount = mdao.member_count();
			int member = mdao.member();
			int f_board = fdao.f_board();
			int f_comment = fdao.f_comment();
			int g_board = gdao.g_board();
			int g_comment = gdao.g_comment();
			
			req.setAttribute("memberCount", memberCount);
			req.setAttribute("member", member);
			req.setAttribute("f_board", f_board);
			req.setAttribute("f_comment", f_comment);
			req.setAttribute("g_board", g_board);
			req.setAttribute("g_comment", g_comment);
			
	 		RequestDispatcher dispatcher = req.getRequestDispatcher("admins.jsp");
			
	 		dispatcher.forward(req, resp);
		
		}
		catch (Exception e) {
			resp.sendError(500);
			e.printStackTrace();
		} 
	}
}