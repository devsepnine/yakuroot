package q_board.beans;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
@WebServlet(urlPatterns="/board/q_write.do")
public class q_board_write extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/board/q_write.jsp");
		dispatcher.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			q_boardDao qdao = new q_boardDao();
			
			String path = "D:\\q_upload";
			File Folder = new File(path);
			if(!Folder.exists()) {
				try {
					Folder.mkdir();
				}
				catch (Exception e) {
					e.printStackTrace();
					e.getStackTrace();
				}
			}else {			
			}
			
			String path2 = "D:\\q_upload";
			int max = 10*1024*1024;
			String enc = "UTF-8";
			
			DefaultFileRenamePolicy policy = new DefaultFileRenamePolicy();
			MultipartRequest mRequset = new MultipartRequest(req,path2,max,enc,policy);
			File file = mRequset.getFile("qf");
			String q_head = mRequset.getParameter("q_head");
			String q_title = mRequset.getParameter("q_title");
			String q_writer = mRequset.getParameter("q_writer");
			String q_content = mRequset.getParameter("q_content");
			
			q_boardDto qdto = new q_boardDto();
			if(req.getParameterMap().containsKey("q_parent")) {
				qdto.setQ_parent(Integer.parseInt(mRequset.getParameter("q_parent")));
			}
			qdto.setQ_head(q_head);
			qdto.setQ_title(q_title);
			qdto.setQ_writer(q_writer);
			qdto.setQ_content(q_content);
			if(file!=null) {
				qdto.setQ_savename(mRequset.getFilesystemName("qf"));
				qdto.setQ_uploadname(mRequset.getOriginalFileName("qf"));
				qdto.setQ_len(file.length());
				qdto.setQ_type(mRequset.getContentType("qf"));
			}
			qdao.write(qdto);
			
			req.setAttribute("qdto", qdto);
			resp.sendRedirect(req.getContextPath()+"/board/q_list.do");
			
		}catch (Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}

}
