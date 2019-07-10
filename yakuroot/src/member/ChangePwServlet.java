package member;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import m_beans.MemberDao;
import m_beans.MemberDto;



@WebServlet(urlPatterns = "/member/change_pw.do")
public class ChangePwServlet  extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("change_pw.jsp");
		
		dispatcher.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		try {

			req.setCharacterEncoding("UTF-8");
			MemberDto mdto = new MemberDto();
			mdto.setM_id(req.getParameter("m_id"));
			mdto.setM_pw(req.getParameter("m_pw"));
			 

			MemberDao mdao = new MemberDao();
			mdao.change_pw(mdto);
			
			

			RequestDispatcher dispatcher = req.getRequestDispatcher("change_pw_result.jsp");
			
			dispatcher.forward(req, resp);
		
		}
		catch(Exception e) {
			resp.sendError(500);
			e.printStackTrace();
		
		}
	}

}