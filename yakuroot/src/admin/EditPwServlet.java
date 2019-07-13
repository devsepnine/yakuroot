package admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.beans.MemberDao;
import member.beans.MemberDto;
import member.util.SamplePw;

@WebServlet(urlPatterns = "/admin/edit_pw.do")
public class EditPwServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			//파라미터로 회원 아이디 가져와서  회원 정보 수정
			String m_id = (String)req.getParameter("m_id");
			
			MemberDto mdto = new MemberDto();
			mdto.setM_id(m_id);
			
			//SamplePw로 10자리 임시비밀번호 발급
			String npw = SamplePw.random(10);
			mdto.setM_pw(npw);
			
			//임시 비밀번호로 회원 비밀번호 변경
			MemberDao mdao = new MemberDao();
			mdao.change_pw(mdto);
			
			req.setAttribute("sample_pw", npw );
			RequestDispatcher dispatcher = req.getRequestDispatcher("edit_pw.jsp");
			
			dispatcher.forward(req, resp);
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}
