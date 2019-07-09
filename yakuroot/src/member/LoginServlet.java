package member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import m_beans.MemberDao;
import m_beans.MemberDto;


@WebServlet(urlPatterns = "/member/login.do")
public class LoginServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");//사용자화면에 찍히는것만 /home으로 시작
		
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			req.setCharacterEncoding("UTF-8");

			String m_id = req.getParameter("m_id");
			String m_pw = req.getParameter("m_pw");
			String rememberId = req.getParameter("saveID");
			
			
			
			MemberDto mdto = new MemberDto();
			mdto.setM_id(m_id);
			mdto.setM_pw(m_pw);


			MemberDao mdao = new MemberDao();
			boolean login = mdao.login(mdto);
			
			if(login) {
				
				mdto = mdao.get(m_id);
				
				req.getSession().setAttribute("login", mdto.getM_id());
				
				
				mdao.lasttime(mdto.getM_id());
				
			
				Cookie saveID = new Cookie("saveID", m_id);
				if(rememberId != null) {
					saveID.setMaxAge(7 * 24 * 60); 
				}
				else {
					saveID.setMaxAge(0);
				}
				
				resp.addCookie(saveID);
				
				resp.sendRedirect("../");
			}

			else {
				
				RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp?error");
				
				dispatcher.forward(req, resp);
			}
				

		} catch (Exception e) {
			resp.sendError(500);
			e.printStackTrace();
		}
	}
}
