package notice_comment.beans;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns="/board/nc_delete.do")
public class c_comment_delete extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int no = Integer.parseInt(req.getParameter("no"));
			CommentDao cdao = new CommentDao();
			int origin = cdao.delete(no);
			resp.sendRedirect(req.getContextPath()+"/board/notice_content.do?no="+origin);
			
		}catch (Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
	}

