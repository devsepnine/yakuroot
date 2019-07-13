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
			//세션에서 본인 아이디 가져오기
			String m_id = (String) req.getSession().getAttribute("login");
			
			req.setCharacterEncoding("UTF-8");
			
			//입력한 비밀번호 mdto에 저장
			MemberDto mdto = new MemberDto();
			mdto.setM_id(m_id);
			mdto.setM_pw(req.getParameter("m_pw"));

			//change_pw로 비밀번호 변경
			MemberDao mdao = new MemberDao();
			mdao.change_pw(mdto);
			
			//비밀번호 변경 후 결과 페이지로 이동
			RequestDispatcher dispatcher = req.getRequestDispatcher("change_pw_result.jsp");
			
			dispatcher.forward(req, resp);
		
		}
		catch(Exception e) {
			resp.sendError(500);
			e.printStackTrace();
		}
	}
}
