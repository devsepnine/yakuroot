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

@WebServlet(urlPatterns = "/member/regist.do")
public class RegistServlet extends HttpServlet {

	// GET 방식 -> 가입페이지로 연결
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("regist.jsp");

		dispatcher.forward(req, resp);
	}

	// POST 방식 -> 등록 처리 후 결과 페이지로 이동
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			//이메일은  @기준 앞뒤로 따로 받고 합쳐서 m_email에 저장
			String m_email = req.getParameter("m_email") +"@" + req.getParameter("m_email_address").toLowerCase();
			
			//입력받은 값을 mdto에 저장
			MemberDto mdto = new MemberDto();
			mdto.setM_id(req.getParameter("m_id"));
			mdto.setM_pw(req.getParameter("m_pw"));
			mdto.setM_name(req.getParameter("m_name"));
			mdto.setM_birth(req.getParameter("m_birth"));
			mdto.setM_phone(req.getParameter("m_phone"));
			mdto.setM_email(m_email);
			mdto.setM_postcode(req.getParameter("m_postcode"));
			mdto.setM_addr1(req.getParameter("m_addr1"));
			mdto.setM_addr2(req.getParameter("m_addr2"));
			mdto.setM_fav(req.getParameter("m_fav"));

			//regist로 회원가입
			MemberDao mdao = new MemberDao();
			mdao.regist(mdto);
			
			//회원가입 후 회원가입 결과 페이지로 이동
			RequestDispatcher dispatcher = req.getRequestDispatcher("regist_result.jsp");
			
			dispatcher.forward(req, resp);
		}
		catch (Exception e) {
			resp.sendError(500);
			e.printStackTrace();
		}
	}
}
