package f_board.beans;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/board/f_edit.do")
public class f_board_edit extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		try {
			f_boardDao bdao = new f_boardDao();
			int no = Integer.parseInt(req.getParameter("f_no"));
			f_boardDto bdto = bdao.get(no);
			System.out.println(bdto);
			req.setAttribute("bdto", bdto);
		} catch (Exception e) {
			e.printStackTrace();

		}
		RequestDispatcher dispatcher = req.getRequestDispatcher("/board/f_edit.jsp");

		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setCharacterEncoding("UTF-8");
			f_boardDao bdao = new f_boardDao();
			f_boardDto bdto = new f_boardDto();
			String head = req.getParameter("f_head");
			String title = req.getParameter("f_title");
			String content = req.getParameter("f_content");
			int no = Integer.parseInt(req.getParameter("f_no"));
			bdto.setF_head(head);
			bdto.setF_title(title);
			bdto.setF_content(content);
			bdto.setF_no(no);

			bdao.edit(bdto);
			RequestDispatcher dispatcher = req.getRequestDispatcher("f_content.do?no=" + bdto.getF_no());
			dispatcher.forward(req, resp);

		} catch (Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}
