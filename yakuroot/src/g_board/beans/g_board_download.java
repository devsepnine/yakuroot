package g_board.beans;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns="/board/g_download.do")
public class g_board_download extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
		//g_savename에 따른 다운로드 처리를 구현[서블릿도 코드 동일]
		//파라미터를 받음[g_savename]
		//g_savename을 이용하여 파일정보를 불러온다
		//불러온 파일을 실제로 읽는다
		//읽어온 파일을 response를 이용하여 사용자에게 전송	
		//-전송형태:application/octet-stream
		
		//response 초기화
		
		String g_savename = req.getParameter("g_savename");
		
		g_boardDao gdao = new g_boardDao();
		g_boardDto gdto = gdao.getdown(g_savename);
		
		resp.reset();
		
		//헤더 설정
//	 	resp.setHeader("항목", "값");
//		resp.setHeader("Content-Type", "application/octet-stream; charset=UTF-8");
	 	resp.setHeader("Content-Type", "image/jpg; charset=UTF-8");
		resp.setHeader("Content-Disposition", "attachment; filename="+gdto.getSendname());
		resp.setHeader("Content-Length", String.valueOf(gdto.getG_len()));
		resp.setHeader("COntent-Description", "부연설명");
		
			File target = new File("D:/g_upload/"+gdto.getG_savename());
		
		InputStream in = new FileInputStream(target);
		OutputStream send = resp.getOutputStream();
		
		//in에서 읽은것을 send로 전송
		byte[] buffer = new byte[1024];
		
		while(true){
		int size = in.read(buffer);//buffer를 읽고 실제 개수를 size에 저장
		if(size==-1) break;
		send.write(buffer,0,size);//buffer의 내용을 맨 앞에서부터 size개 출력
		}
		in.close();
	}catch (Exception e) {
		e.printStackTrace();
		resp.sendError(500);
	}
}

}