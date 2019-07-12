package q_board.beans;

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
@WebServlet(urlPatterns="/board/q_download.do")
public class q_board_download extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String q_savename = req.getParameter("q_savename");
			q_boardDao qdao = new q_boardDao();
			q_boardDto qdto = qdao.getdown(q_savename);
			
			resp.reset();
			
//			resp.setHeader("Content-Type", "application/octet-stream; charset=UTF-8");
		 	resp.setHeader("Content-Type", "image/jpg; charset=UTF-8");
			resp.setHeader("Content-Disposition", "attachment; filename="+qdto.getSendname());
			resp.setHeader("Content-Length", String.valueOf(qdto.getQ_len()));
			resp.setHeader("COntent-Description", "부연설명");
			
			File target = new File("D:/q_upload/"+qdto.getQ_savename());
		
			InputStream in = new FileInputStream(target);
			OutputStream send = resp.getOutputStream();
			
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
