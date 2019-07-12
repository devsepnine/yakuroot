package member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.beans.MemberDao;
import member.beans.MemberDto;



@WebServlet(urlPatterns="/member/info.do")
public class InfoServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
		String m_id = (String)req.getSession().getAttribute("login");
	 	MemberDao mdao = new MemberDao();
	 	MemberDto mdto = mdao.get(m_id);
			
		
		req.setAttribute("mdto", mdto);
			
		RequestDispatcher dispatcher = req.getRequestDispatcher("info.jsp");
			
		dispatcher.forward(req, resp);
		
		
		}
		catch (Exception e) {
			resp.sendError(500);
			e.printStackTrace();
		} 
		
	}
}
