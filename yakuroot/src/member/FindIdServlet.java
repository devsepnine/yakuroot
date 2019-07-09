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


@WebServlet(urlPatterns = "/member/find_id.do")
public class FindIdServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("find_id.jsp");
		
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		try {
			req.setCharacterEncoding("UTF-8");
			
			String m_name = req.getParameter("m_name");
			String m_phone = req.getParameter("m_phone");
			String m_birth = req.getParameter("m_birth");

			MemberDto mdto = new MemberDto();
			
			mdto.setM_name(m_name);
			mdto.setM_phone(m_phone);
			mdto.setM_birth(m_birth);
		
//			System.out.println(mdto);
			
			MemberDao mdao = new MemberDao();
			mdao.find_id(mdto);
			
			String m_id = mdao.find_id(mdto);
			
			if(m_id != null) {
				req.setAttribute("m_id", m_id);
				
				RequestDispatcher dispatcher = req.getRequestDispatcher("find_id_result.jsp");
				dispatcher.forward(req, resp);				
			}
			else {

				
				RequestDispatcher dispatcher = req.getRequestDispatcher("find_id.jsp?error");
				dispatcher.forward(req, resp);
				
			}
		
		} catch (Exception e) {
			resp.sendError(500);
			e.printStackTrace();
		}
	}

}
