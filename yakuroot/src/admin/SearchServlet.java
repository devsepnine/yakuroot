package admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.beans.MemberDao;
import member.beans.MemberDto;


@WebServlet(urlPatterns = "/admin/search.do")
public class SearchServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			String type = req.getParameter("type");
			String keyword = req.getParameter("keyword");
			
			MemberDao mdao = new MemberDao();
			
			
			List<MemberDto> list;
			if(type == null){
				list = null;
			}
			else{
				list = mdao.search(type, keyword); 
			}
			
			
			req.setAttribute("list", list);
			req.setAttribute("type", type);
			req.setAttribute("keyword", keyword);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("search.jsp");
			
			dispatcher.forward(req, resp);
			
			
		}
		catch (Exception e) {
			resp.sendError(500);
			e.printStackTrace();
		}
	}

}
