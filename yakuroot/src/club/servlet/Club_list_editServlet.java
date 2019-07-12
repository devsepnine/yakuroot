package club.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import club.beans.ClubDao;
import club.beans.ClubDto;

@WebServlet(urlPatterns="/club/club_list_edit.do")
public class Club_list_editServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int c_no = Integer.parseInt(req.getParameter("c_no"));
			ClubDao cdao = new ClubDao();
			ClubDto cdto = cdao.get(c_no);
			req.setAttribute("cdto", cdto);
			
			//포워딩
			RequestDispatcher dispatcher = req.getRequestDispatcher("club_list_edit.jsp");
			dispatcher.forward(req, resp);
		}
		catch (Exception e){
			resp.sendError(500);
			e.printStackTrace();
		}
		
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//입력 : c_no, c_photo, c_name, c_year, c_born, c_club 
			ClubDto cdto = new ClubDto();
			cdto.setC_no(Integer.parseInt(req.getParameter("c_no")));
			cdto.setC_photo(req.getParameter("c_photo"));
			cdto.setC_name(req.getParameter("c_name"));
			cdto.setC_year(req.getParameter("c_year"));
			cdto.setC_born(req.getParameter("c_born"));
			cdto.setC_club(req.getParameter("c_club"));
			
			//처리 : 수정(edit)Dao 받아오기
			ClubDao cdao = new ClubDao();
			cdao.edit(cdto);
						
			//출력 : 
			RequestDispatcher dispatcher = req.getRequestDispatcher("club_list_edit.jsp");
			dispatcher.forward(req, resp);
		}
		catch (Exception e) {
			resp.sendError(500);
			e.printStackTrace();
		}
	}
}
