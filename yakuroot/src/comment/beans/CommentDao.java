package comment.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.sql.DataSource;

public class CommentDao {
	
	static DataSource src;
	static {
		try {
			Context ctx = new InitialContext();
			src = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle");
		} catch (Exception e) {
			System.err.println("dbcp err");
			e.printStackTrace();
		}
	}
	public Connection getConnection() throws Exception{
		return src.getConnection();
	}

	
	public int write(CommentDto cdto)throws Exception {//��� ��� �޼ҵ�
		Connection con = this.getConnection();
		String sql = "select f_com_seq.nextval from dual";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		rs.next();
		int no = rs.getInt(1);
		ps.close();
		sql = "insert into f_comments values(?,?,?,sysdate,?)";
		ps = con.prepareStatement(sql);
		ps.setInt(1, no);
		ps.setString(2, cdto.getWriter());
		ps.setString(3, cdto.getContent());
		ps.setInt(4, cdto.getOrigin());
		ps.execute();
		
		con.close();

		return no;
	}
	public List<CommentDto> get(int origin) throws Exception {
		Connection con = this.getConnection();
		String sql = "select * from f_comments where origin = ? order by when asc";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, origin);
		ResultSet rs = ps.executeQuery();
		List<CommentDto> list = new ArrayList<CommentDto>();
			while(rs.next()) {
				CommentDto cdto1 = new CommentDto();
				cdto1.setData(rs);
				list.add(cdto1);		
			}
		con.close();

		return list;

	}
	public List<CommentDto> list(int start,int end) throws Exception {//����Ʈ ��� �޼ҵ�
		Connection con = this.getConnection();
		String sql = "select * from (select a.*, rownum as rnum from (select * from f_comments order by no desc)a) where rnum between ? and ? ";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, start);
		ps.setInt(2, end);
		ResultSet rs = ps.executeQuery();

		List<CommentDto> list = new ArrayList<CommentDto>(); // ����ִ� ����Ʈ �غ�
		while (rs.next()) {
			// rs->PersonDto->list
			CommentDto cdto = new CommentDto();
			cdto.setData(rs);
			list.add(cdto);
		}
		con.close();
		return list;
	}
	public int delete(int no) throws Exception{
		Connection con = this.getConnection();
		String sql = "select origin from f_comments where no = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, no);
		ResultSet rs = ps.executeQuery();
		rs.next();
		int origin = rs.getInt("origin");
		ps.close(); 
		sql = "delete f_comments where no = ?";
		ps = con.prepareStatement(sql);
		ps.setInt(1, no);
		ps.execute();	
		con.close();
		
		return origin;
	}
	public CommentDto edit(CommentDto cdto) throws Exception{//ȸ������ �˻� �޼ҵ�
		Connection con = this.getConnection();		
		String sql="update f_comments set "
				+ "content = ? where no = ? ";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, cdto.getContent());
		ps.setInt(2, cdto.getNo());
		ps.execute();	
		
		con.close();
		return cdto;
		}


	
}
