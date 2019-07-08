package beans;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class MemberDao {
	
//	���Ḹ ó���ؼ� ��ȯ�ϴ� �޼ҵ�
	public Connection getConnection() throws Exception{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe", "yakuroot", "baseball");
		return con;
	}

	
	
	//ȸ������
	public void regist(MemberDto mdto) throws Exception {
		Connection con = this.getConnection();
		
		String sql = "insert into memeber values (member_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, '�Ϲ�', sysdate, sysdate)";
				PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, mdto.getM_id());
		ps.setString(2, mdto.getM_pw());
		ps.setString(3, mdto.getM_name());
		ps.setString(4, mdto.getM_birth());
		ps.setString(5, mdto.getM_phone());
		ps.setString(6, mdto.getM_email());
		ps.setString(7, mdto.getM_postcode());
		ps.setString(8, mdto.getM_addr1());
		ps.setString(9, mdto.getM_addr2());
		ps.setString(10, mdto.getM_fav());
	
		ps.execute();

		con.close();

	}
	
	
	
	//�α���
	public boolean login(MemberDto mdto) throws Exception {
		Connection con = this.getConnection();

		String sql = "select * from member where m_id = ? and m_pw = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, mdto.getM_id());
		ps.setString(2, mdto.getM_pw());
		ResultSet rs = ps.executeQuery();

		boolean result = rs.next();

		con.close();
		
		return result;
	
	}
	
	
	
	
	//���̵� ã��
	public String find_id(MemberDto mdto) throws Exception {
        Connection con = this.getConnection();
        
        String sql = "select * from member where m_name = ? and m_phone = ? and m_birth = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, mdto.getM_name());
        ps.setString(2, mdto.getM_phone());
        ps.setString(3, mdto.getM_birth());
        ResultSet rs = ps.executeQuery();
        
        String id;
        if(rs.next()) {
            id = rs.getString("m_id");
        }
        else {
        	id = null;
        }
         
        con.close();
        
        return id;
    }
	
	
	
	//��й�ȣ ã��
	public boolean find_pw(MemberDto mdto) throws Exception {
		Connection con = this.getConnection();
		
		String sql = "select * from member where m_id = ? and  m_name = ? and m_phone= ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, mdto.getM_id());
		ps.setString(2, mdto.getM_name());
		ps.setString(3, mdto.getM_phone());
		ResultSet rs = ps.executeQuery();
		
		boolean result = rs.next();

		con.close();
		
		return result;
	}
	
	
	
	//��й�ȣ ����
	public void change_pw(MemberDto mdto) throws Exception {
		Connection con = this.getConnection();
		
		String sql = "update member set m_pw = ? where m_id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, mdto.getM_pw());
		ps.setString(2, mdto.getM_id());
		ps.execute();
		
		con.close();
		
	}
	
	
	
	//���� ����
	public void change_info(MemberDto mdto) throws Exception {
		Connection con = this.getConnection();

		String sql = "update member set m_phone = ? , m_email = ? , m_postcode = ? , m_addr1 = ? , m_addr2 = ? , m_fav = ? WHERE m_id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, mdto.getM_phone());
		ps.setString(2, mdto.getM_email());
		ps.setString(3, mdto.getM_postcode());
		ps.setString(4, mdto.getM_addr1());
		ps.setString(5, mdto.getM_addr2());
		ps.setString(6, mdto.getM_fav());
		ps.setString(7, mdto.getM_id());

		ps.execute();

		con.close();
		
	}
	
	
	
	//������ ���� ����
	public void edit_info(MemberDto mdto) throws Exception {
		
		Connection con = this.getConnection();

		String sql = "update member set m_name = ?, m_birth = ?, m_phone = ? , m_email = ?, m_postcode = ?, m_add1 = ? , m_addr2 = ?, m_fav = ? WHERE m_id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, mdto.getM_name());
		ps.setString(2, mdto.getM_birth());
		ps.setString(3, mdto.getM_phone());
		ps.setString(4, mdto.getM_email());
		ps.setString(5, mdto.getM_postcode());
		ps.setString(6, mdto.getM_addr1());
		ps.setString(7, mdto.getM_addr2());
		ps.setString(8, mdto.getM_fav());
		ps.setString(9, mdto.getM_id());

		ps.execute();

		con.close();
		
	}
	//�� ���� Ȯ��
	public MemberDto get(String m_id) throws Exception{
		Connection con = getConnection();
		
		String sql = "select * from member where m_id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, m_id);
		ResultSet rs = ps.executeQuery();
		
		MemberDto mdto;
		if(rs.next()) {
			mdto = new MemberDto(rs);
		}
		else {
			mdto = null;
		}
		
		con.close();
		
		return mdto;
	}
	
	
	//ȸ�� Ż��
	public void exit(String m_id) throws Exception {
		Connection con = this.getConnection();
		
		String sql = "delete member WHERE m_id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, m_id);
		
		ps.execute();
		
		con.close();
	}
	
	
	
	//���� ������ ����
	public void lasttime(String m_id) throws Exception {
		Connection con = this.getConnection();
		
		String sql = "update member set m_lasttime = sysdate where m_id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, m_id);
		
		
		ps.execute();
		
		con.close();
		
	}
	
	
	
	//������ ȸ�� �˻�
	public List<MemberDto> search(String type, String keyword) throws Exception {
		Connection con = this.getConnection();
		
		String sql = "select * from member where "+type+" like '%' || ? || '%' order by no ";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, keyword);
		
		ResultSet rs = ps.executeQuery();
		
		
		List<MemberDto> list = new ArrayList<MemberDto>();
		
		while(rs.next()) {
			MemberDto mdto = new MemberDto(rs);
			
			list.add(mdto);
		}
		
		con.close();
		return list;
		
	}
	
	
}
