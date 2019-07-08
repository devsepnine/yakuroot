package member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.MemberDao;
import beans.MemberDto;

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
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/plain");

		try {
			req.setCharacterEncoding("UTF-8");

			
			String m_id = req.getParameter("m_id");
			String m_pw = req.getParameter("m_pw");
			String m_name = req.getParameter("m_name");
			String m_birth = req.getParameter("m_birth");
			String m_phone = req.getParameter("m_phone");
			String m_email = req.getParameter("m_email");
			String m_postcode = req.getParameter("m_postcode");
			String m_addr1 = req.getParameter("m_addr1");
			String m_addr2 = req.getParameter("m_addr2");
			String m_fav = req.getParameter("m_fav");

			
			MemberDto mdto = new MemberDto();
			mdto.setM_id(m_id);
			mdto.setM_pw(m_pw);
			mdto.setM_name(m_name);
			mdto.setM_birth(m_birth);
			mdto.setM_phone(m_phone);
			mdto.setM_email(m_email);
			mdto.setM_postcode(m_postcode);
			mdto.setM_addr1(m_addr1);
			mdto.setM_addr2(m_addr2);
			mdto.setM_fav(m_fav);

			
			MemberDao mdao = new MemberDao();
			mdao.regist(mdto);

			
			RequestDispatcher dispatcher = req.getRequestDispatcher("regist_result.jsp");

			
			dispatcher.forward(req, resp);

			
		} catch (Exception e) {
			resp.sendError(500);
			e.printStackTrace();
		}
	}
}
