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

			//입력 받은값 mdto에 저장
			MemberDto mdto = new MemberDto();
			mdto.setM_name(req.getParameter("m_name"));
			mdto.setM_phone(req.getParameter("m_phone"));
			mdto.setM_birth(req.getParameter("m_birth"));

			//find_id로 아이디 검색
			MemberDao mdao = new MemberDao();
			mdao.find_id(mdto);
			
			//검색 값 m_id에 저장
			String m_id = mdao.find_id(mdto);
			
			//m_id가 비거있지 않으면 아이디 검색 결과창으로 이동
			if(m_id != null) {
				req.setAttribute("m_id", m_id);
				
				RequestDispatcher dispatcher = req.getRequestDispatcher("find_id_result.jsp");
				dispatcher.forward(req, resp);				
			}
			//m_id가 비어있으면 아이디 검색 에러창으로 이동
			else {
				RequestDispatcher dispatcher = req.getRequestDispatcher("find_id.jsp?error");
				dispatcher.forward(req, resp);
			}
		}
		catch (Exception e) {
			resp.sendError(500);
			e.printStackTrace();
		}
	}
}
