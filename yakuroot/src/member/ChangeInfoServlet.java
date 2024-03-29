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

@WebServlet(urlPatterns = "/member/change_info.do") 
public class ChangeInfoServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			//세션에서 본인 아이디 가져오기
			String m_id = (String) req.getSession().getAttribute("login");
			
			MemberDao mdao = new MemberDao();
			
			MemberDto mdto = mdao.get(m_id);
			
			req.setAttribute("mdto", mdto);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("change_info.jsp");
			
			dispatcher.forward(req, resp);			
		}
		catch(Exception e) {
			resp.sendError(500);
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//세션에서 본인 아이디 가져오기
			String m_id = (String) req.getSession().getAttribute("login");
			
			//입력 받은값 mdto에 저장
			MemberDto mdto = new MemberDto();
			mdto.setM_id(m_id);
			mdto.setM_phone(req.getParameter("m_phone"));
			mdto.setM_email(req.getParameter("m_email") + "@" + req.getParameter("m_email_address"));
			mdto.setM_postcode(req.getParameter("m_postcode"));
			mdto.setM_addr1(req.getParameter("m_addr1"));
			mdto.setM_addr2(req.getParameter("m_addr2"));
			mdto.setM_fav(req.getParameter("m_fav"));
			
			System.out.println(mdto);
			
			//change_info로 회원정보 수정
			MemberDao mdao = new MemberDao();
			mdao.change_info(mdto);
			
			//수정후에 정보 변경 결과 페이지로 이동
			RequestDispatcher dispatcher = req.getRequestDispatcher("change_info_result.jsp");
			
			dispatcher.forward(req, resp);
		}
		catch(Exception e) {
			resp.sendError(500);
			e.printStackTrace();
		}
	}
}
