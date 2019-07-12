package admin;

import java.io.IOException;

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
			
		
			String m_id = req.getParameter("m_id");
			
			MemberDto mdto = new MemberDto();
			mdto.setM_id(m_id);
			mdto.setM_pw(SamplePw.random(10));
			
			MemberDao mdao = new MemberDao();
			mdao.change_pw(mdto);
			

			resp.sendRedirect("eidt_pw.do?m_pw="+mdto.getM_pw());
			
		}
		
		catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
		
		
		
	}

}
