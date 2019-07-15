package match;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import club.beans.ClubDao;
import club.beans.ClubDto;
import match.beans.MatchDao;
import match.beans.MatchDto;
import stadium.beans.StadiumDao;
import stadium.beans.StadiumDto;

@WebServlet(urlPatterns="/match/match_fix")
public class Match_fix extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			ClubDao cdao = new ClubDao();
			List<ClubDto> cdtolist;
			cdtolist = cdao.getClub();
			
			int match_no = Integer.parseInt(req.getParameter("match_no"));
			MatchDao matdao = new MatchDao();
			MatchDto matdto = matdao.getMatch_one(match_no);
			StadiumDao sdao = new StadiumDao();
			List<StadiumDto> sdtolist = sdao.getStadium();
			
			req.setAttribute("sdtolist", sdtolist);
			req.setAttribute("matdto", matdto);
			req.setAttribute("cdtolist", cdtolist);
			req.setAttribute("match_no", match_no);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("match_fix.jsp");
			dispatcher.forward(req, resp);
			
		}catch (Exception e) {
			resp.sendError(500);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			MatchDao matdao = new MatchDao();
			MatchDto matdto = new MatchDto();
			
			String date = req.getParameter("date");
			int match_no = Integer.parseInt(req.getParameter("match_no"));
			int hour = Integer.parseInt(req.getParameter("hour"));
			int min = Integer.parseInt(req.getParameter("min"));
			int team1 = Integer.parseInt(req.getParameter("team1"));
			int team2 = Integer.parseInt(req.getParameter("team2"));
			int team1point = Integer.parseInt(req.getParameter("team1point"));
			int team2point = Integer.parseInt(req.getParameter("team2point"));
			String stadium = req.getParameter("stadium");
			date = date+" "+hour+":"+min;
			
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd h:m");
			Date d = sf.parse(date);
			SimpleDateFormat sf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			System.out.println(sf2.format(d));
			matdto.setM_date(sf2.format(d));
			matdto.setM_point1(team1point);
			matdto.setM_point2(team2point);
			matdto.setM_stadium(stadium);
			matdto.setM_team1(team1);
			matdto.setM_team2(team2);
			matdto.setMatch_no(match_no);
			
			matdao.fixmatch(matdto);
			
			resp.sendRedirect(req.getContextPath()+"/match/matchup");
		}catch (Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}
