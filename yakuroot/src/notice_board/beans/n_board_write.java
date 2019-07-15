package notice_board.beans;

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

import notice_board.beans.n_boardDao;
import notice_board.beans.n_boardDto;
@WebServlet(urlPatterns="/board/notice_write.do")
public class n_board_write extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/board/notice_write.jsp");
		dispatcher.forward(req, resp); 
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setCharacterEncoding("utf-8");
			n_boardDao ndao = new n_boardDao();
			
			String path2 = "D:\\n_upload"; //폴더 경로
			File Folder2 = new File(path2);

			// 해당 디렉토리가 없을경우 디렉토리를 생성합니다.
			if (!Folder2.exists()) {
				try{
				    Folder2.mkdir(); //폴더 생성합니다.
			        } 
			        catch(Exception e){
				    e.getStackTrace();
				}        
		         }else {
			}
			String path = "D:\\n_upload";
			int max = 10*1024*1024;
			String enc = "UTF-8";
			DefaultFileRenamePolicy policy = new DefaultFileRenamePolicy();
			MultipartRequest mRequset = new MultipartRequest(req,path,max,enc,policy);
			File file = mRequset.getFile("nf");//파일에 정보를 입력
			
			String n_head = mRequset.getParameter("n_head");
			String n_title = mRequset.getParameter("n_title");
			String n_writer = mRequset.getParameter("n_writer");
			String n_content = mRequset.getParameter("n_content");
			
			n_boardDto ndto = new n_boardDto();
			ndto.setN_head(n_head);
			ndto.setN_title(n_title);
			ndto.setN_writer(n_writer);
			ndto.setN_content(n_content);
			
			if(file!=null) {//파일이 null이 아닐 경우		
				ndto.setN_savename(mRequset.getFilesystemName("nf"));
				ndto.setN_uploadname(mRequset.getOriginalFileName("nf"));
				ndto.setN_len(file.length());
				ndto.setN_type(mRequset.getContentType("nf"));	
				}
				ndao.write(ndto);
				
				req.setAttribute("ndto", ndto);
			
			resp.sendRedirect(req.getContextPath()+"/board/notice_list.do");
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}

}
