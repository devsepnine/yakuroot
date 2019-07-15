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



@WebServlet(urlPatterns = "/admin/edit_info.do")
public class EditInfoServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//파라미터로 회원 아이디 가져와서  회원 정보 수정
			String m_id = (String)req.getParameter("m_id");
			
			MemberDao mdao = new MemberDao();

			MemberDto mdto = mdao.get(m_id);
			
			req.setAttribute("mdto", mdto);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("edit_info.jsp");
			
			dispatcher.forward(req, resp);
		}
		catch (Exception e) {
			resp.sendError(500);
			e.printStackTrace();
		} 
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			//입력 받은값 mdto에 저장
			MemberDto mdto = new MemberDto();
			mdto.setM_id(req.getParameter("m_id"));
			mdto.setM_name(req.getParameter("m_name"));
			mdto.setM_birth(req.getParameter("m_birth"));
			mdto.setM_phone(req.getParameter("m_phone"));
			mdto.setM_email(req.getParameter("m_email") + "@" + req.getParameter("m_email_address"));
			mdto.setM_postcode(req.getParameter("m_postcode"));
			mdto.setM_addr1(req.getParameter("m_addr1"));
			mdto.setM_addr2(req.getParameter("m_addr2"));
			mdto.setM_fav(req.getParameter("m_fav"));
			mdto.setM_auth(req.getParameter("m_auth"));
			
			//edit_info로 관리자가 회원정보 수정
			MemberDao mdao = new MemberDao();
			mdao.edit_info(mdto);
			
			//수정 후에 회원 정보 페이지로 이동
			resp.sendRedirect("info.do?m_id="+mdto.getM_id());
			
		} catch (Exception e) {
			resp.sendError(500);
			e.printStackTrace();
		}
	}
}
