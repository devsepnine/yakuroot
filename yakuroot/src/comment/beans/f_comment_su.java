package comment.beans;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns="/board/comment_su.do")
public class f_comment_su extends HttpServlet{
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	try {
	CommentDao cdao = new CommentDao();
	CommentDto cdto = new CommentDto();

	String content = req.getParameter("content");
	int no  = Integer.parseInt(req.getParameter("no"));
	int origin = Integer.parseInt(req.getParameter("origin"));	
	cdto.setContent(content);
	cdto.setNo(no);
	cdto.setOrigin(origin);
	
	cdao.edit(cdto);
	RequestDispatcher dispatcher = req.getRequestDispatcher("f_content.do?no="+cdto.getOrigin());
	dispatcher.forward(req, resp);
	}catch (Exception e) {
		e.printStackTrace();
		resp.sendError(500);
	}
}
}
