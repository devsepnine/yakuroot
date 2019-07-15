package admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.beans.MemberDao;

@WebServlet(urlPatterns="/admin/admins.do")
public class AdminsServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			MemberDao mdao = new MemberDao();
			
			int memberCount = mdao.member_count();
			
			req.setAttribute("memberCount", memberCount);
			
	 		RequestDispatcher dispatcher = req.getRequestDispatcher("admins.jsp");
			
	 		dispatcher.forward(req, resp);
		
		}
		catch (Exception e) {
			resp.sendError(500);
			e.printStackTrace();
		} 
	}
}