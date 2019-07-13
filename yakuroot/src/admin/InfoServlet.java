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

@WebServlet(urlPatterns="/admin/info.do")
public class InfoServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			//파라미터로 회원 아이디 가져와서  회원 정보 보기
			String m_id = (String)req.getParameter("m_id");
			
			MemberDao mdao = new MemberDao();
			
			//get으로 회원정보 불러와서 내용 출력
	 		MemberDto mdto = mdao.get(m_id);
		
	 		req.setAttribute("mdto", mdto);
			
	 		RequestDispatcher dispatcher = req.getRequestDispatcher("info.jsp");
			
	 		dispatcher.forward(req, resp);
		
		}
		catch (Exception e) {
			resp.sendError(500);
			e.printStackTrace();
		} 
	}
}