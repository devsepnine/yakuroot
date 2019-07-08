package member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.MemberDao;
import beans.MemberDto;

//Ŭ���̾�Ʈ�� ���̵� �ߺ�Ȯ�� �񵿱� ��û�� ó���ϴ� ����
// - ������ ������ : ������� �̸���(email)
// - ������ ������ : ��밡��(Y), �����(N)
@WebServlet(urlPatterns="/member/id_check.do") //���� �ּҴ� /�� �����ؾߵ�
public class IdCheckServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
//			�Է�
			//���������� get�޼ҵ�� ���̵� ������ �����������°� �ִµ�
			//�ű⼭ get������ ���������� ����ϰ��ִ� ���̵��̰� ���� ������ ��밡���� ���̵� �̷��� �Ǵ�
			
			String m_id = req.getParameter("m_id");
			
//			ó��
			MemberDao mdao = new MemberDao();
			MemberDto mdto = mdao.get(m_id);
			//null �϶� Y �� ����������  Y �� ��밡���ѰŴϱ�
			
//			���
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
