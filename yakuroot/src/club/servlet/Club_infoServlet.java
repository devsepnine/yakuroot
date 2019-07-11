package club.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.net.httpserver.HttpServer;

import club.beans.ClubDao;
import club.beans.ClubDto;

@WebServlet(urlPatterns="/club/club_info.do")
public class Club_infoServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {			
			//parameter에 있는 c_no를 받아와서 c_no의 구단정보를 cdto에 넣는다
			int c_no = Integer.parseInt(req.getParameter("c_no"));
			ClubDao cdao = new ClubDao();
			ClubDto cdto = cdao.get(c_no);
			
			//cdto를 parameter에 추가해서 club_info로 넘겨준다
			req.setAttribute("cdto", cdto);
			
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("club_info.jsp");
			dispatcher.forward(req, resp);
		}
		catch (Exception e){
			resp.sendError(500);
			e.printStackTrace();
		}
	}

}
