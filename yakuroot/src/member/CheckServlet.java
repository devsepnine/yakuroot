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



@WebServlet(urlPatterns="/member/check.do")
public class CheckServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("check.jsp");
		
		dispatcher.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			//인증을 위한 정보를 받는다
			String m_id = (String) req.getSession().getAttribute("login");
			String m_pw = req.getParameter("m_pw");
			
			//인증에 성공하면 보내야할 목적지를 받는다
			String go = req.getParameter("go");
			
			
			MemberDto mdto = new MemberDto();
			mdto.setM_id(m_id);
			mdto.setM_pw(m_pw);
			
			//login으로 로그인 결과값을 받는다
			MemberDao mdao = new MemberDao();
			boolean result = mdao.login(mdto);

			//인증에 성공하면 목적지로 보낸다
			if(result) {
				resp.sendRedirect(go);
			}
			//인증에 실패하면 에러 메세지 출력
			else {
				resp.sendRedirect("check.do?error&go="+go);
			}	
		}
		catch(Exception e) {
			resp.sendError(500);
			e.printStackTrace();
		}
	}
}
