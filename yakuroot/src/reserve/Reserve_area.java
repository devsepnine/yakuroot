package reserve;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import area.beans.AreaDao;
import area.beans.AreaDto;

@WebServlet(urlPatterns="/reserve/reserve_area")
public class Reserve_area extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int match_no = Integer.parseInt(req.getParameter("match_no"));
			int stadium_no = Integer.parseInt(req.getParameter("s_no"));
			AreaDao adao = new AreaDao();
			List<AreaDto> arealist = adao.getArea(stadium_no);
			
			req.setAttribute("arealist", arealist);
			req.setAttribute("match_no", match_no);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("select_area.jsp");
			dispatcher.forward(req, resp);
			
		}catch (Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}	
	}
}
