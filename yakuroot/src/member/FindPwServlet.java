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



@WebServlet(urlPatterns = "/member/find_pw.do")
public class FindPwServlet extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("find_pw.jsp");
		
		dispatcher.forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setCharacterEncoding("UTF-8");
			
			//입력 받은값 mdto에 저장
			MemberDto mdto = new MemberDto();
			mdto.setM_id(req.getParameter("m_id"));
			mdto.setM_name(req.getParameter("m_name"));
			mdto.setM_phone(req.getParameter("m_phone"));
			
			//find_pw로 비밀번호 검색해서 결과 exist에 저장
			MemberDao mdao = new MemberDao();
			boolean exist = mdao.find_pw(mdto);
			
			//정보가 일치하면 비밃번호 변경창으로 이동
			if(exist) {
				resp.sendRedirect("change_pw.do?m_id=" + mdto.getM_id());
			}
			//정보가 일치하지 않으면 비밀번호 검색 에러창으료 이동
			else {
				resp.sendRedirect("find_pw.do?error");
			}
		}
		catch(Exception e) {
			resp.sendError(500);
			e.printStackTrace();
		}
	}
}
