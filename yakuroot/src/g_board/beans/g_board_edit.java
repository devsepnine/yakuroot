package g_board.beans;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
@WebServlet(urlPatterns="/board/g_edit.do")
public class g_board_edit extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setCharacterEncoding("utf-8");
			int no = Integer.parseInt(req.getParameter("g_no"));
			g_boardDao gdao = new g_boardDao();
			g_boardDto gdto = gdao.get(no);
			
			req.setAttribute("gdto", gdto);
			
		}catch (Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
		RequestDispatcher dispatcher = req.getRequestDispatcher("/board/g_edit.jsp");
		dispatcher.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	try {
		req.setCharacterEncoding("utf-8");
		g_boardDao gdao = new g_boardDao();
		g_boardDto gdto = new g_boardDto();
		
		String path2 = "D:\\g_upload";
		int max = 10*1024*1024;
		String enc = "UTF-8";
		
		DefaultFileRenamePolicy policy = new DefaultFileRenamePolicy();
		MultipartRequest mRequset = new MultipartRequest(req,path2,max,enc,policy);
		
		String head = mRequset.getParameter("g_head");
		String title = mRequset.getParameter("g_title");
		String content = mRequset.getParameter("g_content");
		int no = Integer.parseInt(mRequset.getParameter("g_no"));
		long len = Long.parseLong(mRequset.getParameter("g_len"));
		gdto.setG_head(head);
		gdto.setG_title(title);
		gdto.setG_content(content);
		gdto.setG_no(no);
		gdto.setG_savename(mRequset.getParameter("g_savename"));
		gdto.setG_uploadname(mRequset.getParameter("g_uploadname"));
		gdto.setG_len(len);
		gdto.setG_type(mRequset.getParameter("g_type"));
		
		gdao.edit(gdto);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/board/g_content.do?no="+no);
		dispatcher.forward(req, resp);
		
	}catch (Exception e) {
		e.printStackTrace();
		resp.sendError(500);
	}
	}

}
