package reserve;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import resdata.beans.resdataDao;
import resdata.beans.resdataDto;

@WebServlet(urlPatterns="/reserve/result")
public class Result extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String id = (String) req.getSession().getAttribute("login");
			int match_no = Integer.parseInt(req.getParameter("match_no"));
			int stadium_no = Integer.parseInt(req.getParameter("s_no"));
			int area_no = Integer.parseInt(req.getParameter("area_no"));
			int seat_no = Integer.parseInt(req.getParameter("seat_no"));
			resdataDao rdao = new resdataDao();
			resdataDto rdto = new resdataDto();
			rdto.setMember_id(id);
			rdto.setMatch_no(match_no);
			rdto.setStadium_no(stadium_no);
			rdto.setArea_no(area_no);;
			rdto.setSeat_no(seat_no);
			boolean result = rdao.setResdata(rdto);
			
			req.setAttribute("result", result);
			RequestDispatcher dispatcher = req.getRequestDispatcher("payment.jsp");
			dispatcher.forward(req, resp);
			
		}catch (Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
			
			
	}
}
