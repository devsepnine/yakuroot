package g_board.beans;

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


@WebServlet(urlPatterns="/board/g_write.do")
public class g_board_write extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/board/g_write.jsp");
		dispatcher.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
		//글을 읽어서 찍어주는 메소드
		g_boardDao gdao = new g_boardDao();
		
		
		String path2 = "D:\\g_upload"; //폴더 경로
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
	    
		
		//아래 3개는 파일의 저장 형식
		String path = "D:\\g_upload";
		int max = 10*1024*1024;
		String enc = "UTF-8";
		
		DefaultFileRenamePolicy policy = new DefaultFileRenamePolicy();
		MultipartRequest mRequset = new MultipartRequest(req,path,max,enc,policy);
		File file = mRequset.getFile("gf");//파일에 정보를 입력
		String g_head = mRequset.getParameter("g_head");
		String g_title = mRequset.getParameter("g_title");
		String g_writer = mRequset.getParameter("g_writer");
		String g_content = mRequset.getParameter("g_content");
		
		g_boardDto gdto = new g_boardDto();
		if(req.getParameterMap().containsKey("g_parent")) {
			gdto.setG_parent(Integer.parseInt(mRequset.getParameter("g_parent")));
		}		
		gdto.setG_head(g_head);
		gdto.setG_title(g_title);
		gdto.setG_writer(g_writer);
		gdto.setG_content(g_content);
		
		//파일이 전송된걸 확인하는 메소드	
		if(file!=null) {//파일이 null이 아닐 경우		
		gdto.setG_savename(mRequset.getFilesystemName("gf"));
		gdto.setG_uploadname(mRequset.getOriginalFileName("gf"));
		gdto.setG_len(file.length());
		gdto.setG_type(mRequset.getContentType("gf"));	
		}
		gdao.write(gdto);

		req.setAttribute("gdto", gdto);
		//완료 후 리스트로 돌려보냄
		resp.sendRedirect(req.getContextPath()+"/board/g_list.do");
		
		}catch (Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}

}
