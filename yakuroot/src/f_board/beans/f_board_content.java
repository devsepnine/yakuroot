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
import f_board.beans.f_boardDao;
import f_board.beans.f_boardDto;
//import comment.beans.CommentDao;
//import comment.beans.CommentDto;
@WebServlet(urlPatterns="/board/f_content.do")
public class f_board_content extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int f_no = Integer.parseInt(req.getParameter("no"));
			f_boardDao bdao = new f_boardDao();
			//if(���� �� ���� �ƴϸ鼭 ó�� ���� ��){
				
			bdao.readone(f_no);
			//}
			f_boardDto bdto = bdao.get(f_no);
			//�ڵ� �߰�:���� ���� �ۼ��ڰ� �������� Ȯ���ϴ� �ڵ�
//			boolean my = bdto.getWriter().equals(req.getSession().getAttribute("ok"));
			//�� ���� ��� ����� �ҷ����� �ڵ�
			CommentDao cdao = new CommentDao();
			List<CommentDto> list = cdao.get(f_no);
			paging p = new paging(req);
			p.calculate();

			req.setAttribute("list2", list);
//			req.setAttribute("my", my);
			req.setAttribute("p", p);
			req.setAttribute("bdto", bdto);	
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("/board/f_content.jsp");
			dispatcher.forward(req, resp);
			
			} catch (Exception e) {
				resp.sendError(500);
				e.printStackTrace();
			}
	}

}
