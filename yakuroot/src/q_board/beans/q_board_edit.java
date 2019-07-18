package q_board.beans;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
@WebServlet(urlPatterns="/board/q_edit.do")
public class q_board_edit extends HttpServlet{
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
		int no = Integer.parseInt(req.getParameter("q_no"));
		q_boardDao qdao = new q_boardDao();
		q_boardDto qdto = qdao.get(no);
		req.setAttribute("qdto", qdto);
		}
		catch (Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
		RequestDispatcher dispatcher = req.getRequestDispatcher("/board/q_edit.jsp");
		dispatcher.forward(req, resp);
	}
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	try {
		req.setCharacterEncoding("UTF-8");
		q_boardDao qdao = new q_boardDao();
		q_boardDto qdto = new q_boardDto();
		
		String path2 = "D:\\upload";
		int max = 10*1024*1024;
		String enc = "UTF-8";
		
		DefaultFileRenamePolicy policy = new DefaultFileRenamePolicy();
		MultipartRequest mRequset = new MultipartRequest(req,path2,max,enc,policy);
		
		int no = Integer.parseInt(mRequset.getParameter("q_no"));
		String head = mRequset.getParameter("q_head");
		String title = mRequset.getParameter("q_title");
		String content = mRequset.getParameter("q_content");
		long len = Long.parseLong(mRequset.getParameter("q_len"));
		qdto.setQ_no(no);
		qdto.setQ_head(head);
		qdto.setQ_title(title);
		qdto.setQ_content(content);
		qdto.setQ_savename(mRequset.getParameter("q_savename"));
		qdto.setQ_uploadname(mRequset.getParameter("q_uploadname"));
		qdto.setQ_len(len);
		qdto.setQ_type(mRequset.getParameter("q_type"));
		System.out.println(qdto);
		
		qdao.edit(qdto);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/board/q_content.do?no="+no);
		dispatcher.forward(req, resp);
		
	}catch (Exception e) {
		e.printStackTrace();
		resp.sendError(500);
	}
}
}
