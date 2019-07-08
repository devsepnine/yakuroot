package f_board.beans;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns="/board/f_edit.do")
public class f_board_edit extends HttpServlet{
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	try {
		f_boardDao bdao = new f_boardDao();
		f_boardDto bdto = new f_boardDto();
		String head = req.getParameter("f_head");
		String title = req.getParameter("f_title");
		String content = req.getParameter("f_content");		
		int no  = Integer.parseInt(req.getParameter("f_no"));
		bdto.setF_head(head);
		bdto.setF_title(title);
		bdto.setF_content(content);
		bdto.setF_no(no);
		
		f_boardDto bdto1 = bdao.get(no);		

		req.setAttribute("bdto", bdto1);	
		bdao.edit(bdto);	
		RequestDispatcher dispatcher = req.getRequestDispatcher("f_content.do?no="+bdto.getF_no());
		dispatcher.forward(req, resp);
		
		
		
		
		
	}catch (Exception e) {
		e.printStackTrace();
		resp.sendError(500);
	}
}
}
