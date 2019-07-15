package player.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import player.beans.PlayerDao;
import player.beans.PlayerDto;

@WebServlet(urlPatterns="/palyer/player_position_pitcher.do")
public class Player_position_pitcherServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int p_no = Integer.parseInt(req.getParameter("p_no"));
			
			PlayerDao pdao = new PlayerDao();
			PlayerDto pdto = pdao.get(p_no);
			
			req.setAttribute("pdto", pdto);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("player_position_pitcher.jsp");
			dispatcher.forward(req, resp);
		}
		catch(Exception e) {
			resp.sendError(500);
			e.printStackTrace();
		}
	}
}
