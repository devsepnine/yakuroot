package f_board.beans;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comment.beans.CommentDao;
import comment.beans.CommentDto;
import member.beans.MemberDao;
import member.beans.MemberDto;
@WebServlet(urlPatterns="/board/f_content.do")
public class f_board_content extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int no = Integer.parseInt(req.getParameter("no"));
			f_boardDao bdao = new f_boardDao();
		
			bdao.readone(no);//조회수 증가용
					
			
			f_boardDto bdto = bdao.get(no);
			//글 쓴사람과 내가 동일한가를 묻는 코드
			boolean my = bdto.getF_writer().equals(req.getSession().getAttribute("login"));
			
			CommentDao cdao = new CommentDao();
			List<CommentDto> list = cdao.get(no);
			paging p = new paging(req);
			p.calculate();
			
			req.setAttribute("list2", list);
			req.setAttribute("my", my);
			req.setAttribute("bdto", bdto);
			req.setAttribute("p", p);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("/board/f_content.jsp");
			dispatcher.forward(req, resp);	
		}catch (Exception e) {
			e.printStackTrace();
			resp.sendError(500);
			// TODO: handle exception
		}
	}

}
