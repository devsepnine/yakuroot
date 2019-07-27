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
import seat.beans.ResSeat;
import seat.beans.SeatDao;
import seat.beans.SeatDto;

@WebServlet(urlPatterns="/reserve/select_seat")
public class Select_seat extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int match_no = Integer.parseInt(req.getParameter("match_no"));
			int area_no = Integer.parseInt(req.getParameter("area_no"));
			req.setAttribute("match_no", match_no);
			req.setAttribute("area_no", area_no);
			SeatDao sdao = new SeatDao();
			List<ResSeat> rlist = sdao.getResSeat(area_no, match_no);
			req.setAttribute("rlist", rlist);
			AreaDao adao = new AreaDao();
			AreaDto adto = adao.getArea_n(area_no);
			req.setAttribute("adto", adto);
			int stadium_no = Integer.parseInt(req.getParameter("s_no"));
			req.setAttribute("s_no", stadium_no);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("select_seat.jsp");
			dispatcher.forward(req, resp);
			
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}
