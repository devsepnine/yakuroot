package match;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import club.beans.ClubDao;
import club.beans.ClubDto;

@WebServlet(urlPatterns="/match/match_insert")
public class Match_insert extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ClubDao cdao = new ClubDao();
		List<ClubDto> cdtolist;
		try {
			cdtolist = cdao.getClub();
		
		req.setAttribute("cdtolist", cdtolist);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/match/match_insert.jsp");
		dispatcher.forward(req, resp);
		
		} catch (Exception e) {
			resp.sendError(500);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
