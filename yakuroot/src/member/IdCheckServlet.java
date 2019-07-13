package member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.beans.MemberDao;
import member.beans.MemberDto;

//클라이언트의 아이디 중복확인 비동기 요청을 처리하는 서블릿
// - 들어오는 데이터 : 사용자가 사용하려는 아이디(m_id)
// - 내보낼 데이터 : 사용가능(Y), 사용중(N)
@WebServlet(urlPatterns="/member/id_check.do") //서블릿 주소는 /로 시작해야됨
public class IdCheckServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			//get했을때 정보있으면 사용하고있는 아이디이고 정보 없으면 사용가능한 아이디 이렇게 판단
			
			//파라미터에서 아이디 받아오기
			String m_id = req.getParameter("m_id");
			
			//get으로 id 정보 확인
			MemberDao mdao = new MemberDao();
			MemberDto mdto = mdao.get(m_id);
			
			resp.setContentType("text/plain");
			
			//mdto가 비어있으면 사용 가능하므로 Y 출력
			if(mdto == null) {
				resp.getWriter().print("Y");				
			}
			//mdto가 비어있지않으면 사용 중인거니까 N 출력
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
