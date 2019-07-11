package g_board.beans;

import java.io.File;
import java.io.IOException;
import java.util.List;

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
		req.setCharacterEncoding("utf-8");
		g_boardDao gdao = new g_boardDao();
		String g_head = req.getParameter("g_head");
		String g_title = req.getParameter("g_title");
		String g_writer = req.getParameter("g_writer");
		String g_content = req.getParameter("g_content");	
		//아래 3개는 파일의 저장 형식
		String path = "D:\\g_upload";
		int max = 10*1024*1024;
		String enc = "UTF-8";
		
		DefaultFileRenamePolicy policy = new DefaultFileRenamePolicy();
		MultipartRequest mRequset = new MultipartRequest(req,path,max,enc,policy);
		File file = mRequset.getFile("gf");//파일에 정보를 입력
		
		g_boardDto gdto = new g_boardDto();
		if(req.getParameterMap().containsKey("g_parent")) {
			gdto.setG_parent(Integer.parseInt(req.getParameter("g_parent")));
		}		
		gdto.setG_head(g_head);
		gdto.setG_title(g_title);
		gdto.setG_writer(g_writer);
		gdto.setG_content(g_content);
		
		//파일이 전송된걸 확인하는 메소드	
	
		gdto.setG_savename(mRequset.getFilesystemName("gf"));
		gdto.setG_uploadname(mRequset.getOriginalFileName("gf"));
		gdto.setG_len(file.length());
		gdto.setG_type(mRequset.getContentType("gf"));
			
			gdao.write(gdto);
		
		//완료 후 리스트로 돌려보냄
		resp.sendRedirect(req.getContextPath()+"/board/g_list.do");
		
		}catch (Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}

}
