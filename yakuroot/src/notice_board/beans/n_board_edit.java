package notice_board.beans;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import notice_board.beans.n_boardDao;
import notice_board.beans.n_boardDto;

@WebServlet(urlPatterns = "/board/notice_edit.do")
public class n_board_edit extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		try {
			n_boardDao ndao = new n_boardDao();
			int no = Integer.parseInt(req.getParameter("n_no"));
			n_boardDto ndto = ndao.get(no);
			req.setAttribute("ndto", ndto);
		} catch (Exception e) {
			e.printStackTrace();

		}
		RequestDispatcher dispatcher = req.getRequestDispatcher("/board/notice_edit.jsp");

		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setCharacterEncoding("UTF-8");
			n_boardDao ndao = new n_boardDao();
			n_boardDto ndto = new n_boardDto();
			
			String path2 = "D:\\n_upload";
			int max = 10*1024*1024;
			String enc = "UTF-8";
			
			DefaultFileRenamePolicy policy = new DefaultFileRenamePolicy();
			MultipartRequest mRequset = new MultipartRequest(req,path2,max,enc,policy);
			
			String head = mRequset.getParameter("n_head");
			String title = mRequset.getParameter("n_title");
			String content = mRequset.getParameter("n_content");
			int no = Integer.parseInt(mRequset.getParameter("n_no"));
			long len = Long.parseLong(mRequset.getParameter("n_len"));
			ndto.setN_head(head);
			ndto.setN_title(title);
			ndto.setN_content(content);
			ndto.setN_no(no);
			ndto.setN_savename(mRequset.getParameter("n_savename"));
			ndto.setN_uploadname(mRequset.getParameter("n_uploadname"));
			ndto.setN_len(len);
			ndto.setN_type(mRequset.getParameter("n_type"));

			ndao.edit(ndto);
			RequestDispatcher dispatcher = req.getRequestDispatcher("notice_content.do?no="+no);
			dispatcher.forward(req, resp);

		} catch (Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}
