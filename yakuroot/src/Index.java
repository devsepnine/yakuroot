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

@WebServlet(urlPatterns="/index.do")
public class Index extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
		String intro = req.getParameter("home");
		
			MatchupDao matdao = new MatchupDao();
			List<MatchupDto> matlist = matdao.get4Matchup();
			req.setAttribute("matlist", matlist);
			RequestDispatcher dispatcher = req.getRequestDispatcher("home.jsp");
			dispatcher.forward(req, resp);
		
		
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}
