package match;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import match.beans.MatchupDao;
import match.beans.MatchupDto;

@WebServlet(urlPatterns="/match/matchup")
public class Match_up extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MatchupDao updao = new MatchupDao();
		try {
			List<MatchupDto> matlist = updao.getMatchup();
			

			req.setAttribute("matlist", matlist);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/match/match_up.jsp");
			
			dispatcher.forward(req, resp);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
