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

@WebServlet(urlPatterns = "/player/player_list.do")
public class Player_listServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			PlayerDao pdao = new PlayerDao();
			List<PlayerDto> pdto = pdao.getPlayer();
			
			req.setAttribute("pdtolist", pdto);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("player_list.jsp");
			dispatcher.forward(req, resp);
		}
		catch (Exception e){
			resp.sendError(500);
			e.printStackTrace();
		}
	}
}
