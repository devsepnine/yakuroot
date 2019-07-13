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
			String m_id = (String) req.getSession().getAttribute("login");

			MemberDao mdao = new MemberDao();
			mdao.exit(m_id);

			resp.sendRedirect("delete.jsp");
			
		} catch (Exception e) {
			resp.sendError(500);
			e.printStackTrace();
		}
	}
}
