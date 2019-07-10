package match;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import match.beans.MatchDao;
import match.beans.MatchDto;

@WebServlet(urlPatterns="/match/match.do")
public class matchs extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MatchDao matdao = new MatchDao();
		try {
			List<MatchDto> matlist = matdao.getMatch();
			

			req.setAttribute("matlist", matlist);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/match/match.jsp");
			
			dispatcher.forward(req, resp);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
