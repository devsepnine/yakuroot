package player.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import player.beans.PlayerDao;
import player.beans.PlayerDto;

@WebServlet(urlPatterns="/player/player_position_in")
public class Player_position_inServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int c_no = Integer.parseInt(req.getParameter("c_no"));
			PlayerDao pdao = new PlayerDao();
			List<PlayerDto> pdtolist = pdao.getPostion(c_no, "내야수");
			req.setAttribute("c_no", c_no);
			req.setAttribute("pdtolist", pdtolist);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("player_position.jsp");
			dispatcher.forward(req, resp);
		}
		catch(Exception e) {
			resp.sendError(500);
			e.printStackTrace();
		}
	}
}
