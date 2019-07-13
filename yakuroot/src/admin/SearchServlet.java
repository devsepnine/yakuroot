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
			//파라미터로 검색 타입과, 검색 키워드 가져오기
			String type = req.getParameter("type");
			String keyword = req.getParameter("keyword");
			
			MemberDao mdao = new MemberDao();
			
			//비어있는 리스트 만들기
			List<MemberDto> list;
			
			//검색 타입이 비어있으면 리스트 비어있는 상태로 찍기
			if(type == null){
				list = null;
			}
			//검색타입 값이 있으면 search로 타입,키워드 이용해서 리스트 찍기
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
