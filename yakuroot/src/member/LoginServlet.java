package member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.beans.MemberDao;
import member.beans.MemberDto;

@WebServlet(urlPatterns = "/member/login.do")
public class LoginServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");//사용자화면에 찍히는것만 /home으로 시작
		
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setCharacterEncoding("UTF-8");
			
			//파라미터에서 m_id,saveID값  저장
			String m_id = req.getParameter("m_id");
			String rememberId = req.getParameter("saveID");
			
			//입력 받은 값 mdto에 저장
			MemberDto mdto = new MemberDto();
			mdto.setM_id(m_id);
			mdto.setM_pw(req.getParameter("m_pw"));

			//login메소드로 결과값 login에 저장
			MemberDao mdao = new MemberDao();
			boolean login = mdao.login(mdto);
			
			//로그인 됬으면
			if(login) {
				//get으로 정보 가져오기
				mdto = mdao.get(m_id);
				
				//세션에서 로그인된 상태, 권한 가져오기
				req.getSession().setAttribute("login", mdto.getM_id());
				//아이디로 권한 얻어서 세션에 추가
				MemberDto find = mdao.get(mdto.getM_id());
				req.getSession().setAttribute("auth", find.getM_auth());
				
				//로그인 됬으면 최종 접속시간 갱신
				mdao.lasttime(mdto.getM_id());

				//쿠키 생성
				Cookie saveID = new Cookie("saveID", m_id);
				
				//아이디 저장에 체크 되어있으면 1주일
				if(rememberId != null) {
					saveID.setMaxAge(7 * 24 * 60); 
				}
				//아이디 저장에 체크 안되어있으면 쿠키 삭제
				else {
					saveID.setMaxAge(0);
				}
				
				resp.addCookie(saveID);
				
				//로그인 후 메인화면으로 이동
				resp.sendRedirect("../");
			}
			
			//로그인 실패시 로그인 에러창 출력
			else {
				RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp?error");
				
				dispatcher.forward(req, resp);
			}
				
		}
		catch (Exception e) {
			resp.sendError(500);
			e.printStackTrace();
		}
	}
}
