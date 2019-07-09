package comment.beans;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns="/board/f_comments.do")
public class f_comment_write extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setCharacterEncoding("UTF-8");
			CommentDto cdto = new CommentDto();
			String content = req.getParameter("content");
			int origin = Integer.parseInt(req.getParameter("origin"));
			String writer = req.getParameter("writer");
			cdto.setWriter(writer);
			cdto.setContent(content);
			cdto.setOrigin(origin);
			
			CommentDao cdao = new CommentDao();
			
			cdao.write(cdto);
			//���
			resp.sendRedirect(req.getContextPath()+"/board/f_content.do?no="+cdto.getOrigin());
				
		}catch (Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}
