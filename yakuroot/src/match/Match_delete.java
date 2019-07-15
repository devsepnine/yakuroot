package match;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import match.beans.MatchDao;
import match.beans.MatchDto;

@WebServlet(urlPatterns="/match/match_delete")
public class Match_delete extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int match_no = Integer.parseInt(req.getParameter("match_no"));
			System.out.println(match_no);
			MatchDao matdao = new MatchDao();
			matdao.delMatch(match_no);
			
			resp.sendRedirect("matchup");
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}
