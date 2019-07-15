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

@WebServlet(urlPatterns = "/player/player_list_edit.do")
public class Player_list_editServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int p_no = Integer.parseInt(req.getParameter("p_no"));
			
			PlayerDao pdao = new PlayerDao();
			PlayerDto pdto = pdao.get(p_no);
			
			req.setAttribute("pdto", pdto);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("player_list_edit.jsp");
			dispatcher.forward(req, resp);
		} 
		catch (Exception e) {
			resp.sendError(500);
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			PlayerDto pdto = new PlayerDto();
			pdto.setP_no(Integer.parseInt(req.getParameter("p_no")));
			pdto.setP_photo(req.getParameter("p_photo"));
			pdto.setP_name(req.getParameter("p_name"));
			pdto.setP_bnum(Integer.parseInt(req.getParameter("p_bnum")));
			pdto.setP_club(req.getParameter("p_birth"));
			pdto.setP_position(req.getParameter("p_position"));
			pdto.setP_height(Integer.parseInt(req.getParameter("p_height")));
			pdto.setP_weight(Integer.parseInt(req.getParameter("p_height")));
			
			PlayerDao pdao = new PlayerDao();
			pdao.edit(pdto);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("player_list.do");
			dispatcher.forward(req, resp);
		}
		catch (Exception e) {
			resp.sendError(500);
			e.printStackTrace();
		}
	}
}
