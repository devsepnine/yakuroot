package member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.beans.MemberDao;

@WebServlet(urlPatterns = "/member/delete.do")
public class DeleteServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//세션에서 본인 아이디 가져오기
			String m_id = (String) req.getSession().getAttribute("login");

			//exit로 회원 탈퇴
			MemberDao mdao = new MemberDao();
			mdao.exit(m_id);

			//탈퇴 처리 후  세션 지우기
			req.getSession().removeAttribute("login");
			
			//로그아웃 된 상태로 결과 페이지로 이동
			resp.sendRedirect("delete.jsp");
			
		}
		catch (Exception e) {
			resp.sendError(500);
			e.printStackTrace();
		}
	}
}
