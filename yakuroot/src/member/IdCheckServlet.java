package member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.MemberDao;
import beans.MemberDto;

//클라이언트의 아이디 중복확인 비동기 요청을 처리하는 서블릿
// - 들어오는 데이터 : 사용자의 이메일(email)
// - 내보낼 데이터 : 사용가능(Y), 사용중(N)
@WebServlet(urlPatterns="/member/id_check.do") //서블릿 주소는 /로 시작해야됨
public class IdCheckServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
//			입력
			//내정보에서 get메소드로 아이디 넣으면 정보가져오는거 있는데
			//거기서 get했을때 정보있으면 사용하고있는 아이디이고 정보 없으면 사용가능한 아이디 이렇게 판단
			
			String m_id = req.getParameter("m_id");
			
//			처리
			MemberDao mdao = new MemberDao();
			MemberDto mdto = mdao.get(m_id);
			//null 일때 Y 를 내보내야함  Y 가 사용가능한거니까
			
//			출력
			resp.setContentType("text/plain");
			if(mdto == null) {
				resp.getWriter().print("Y");				
			}
			else {
				resp.getWriter().print("N");				
			}
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
	
	

}
