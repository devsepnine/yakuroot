package g_board.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class g_boardDao {
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

	public int write(g_boardDto gdto) throws Exception {

		Connection con = this.getConnection();
		String sql = "select g_board_seq.nextval from dual";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		rs.next();
		int no = rs.getInt(1);
		ps.close();

		int g_team;
		if (gdto.getG_parent() > 0) {
			sql = "select g_team from g_board where g_no = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, gdto.getG_parent());
			rs = ps.executeQuery();
			rs.next();
			g_team = rs.getInt("g_team");
			ps.close();
		} else {
			g_team = no;
		}

		sql = "insert into g_board values(?,?,?,?,?,0,sysdate,?,"
				+ "(select nvl(g_depth,0)+1 from g_board where g_no=?),?,?,?,?,?)";

		ps = con.prepareStatement(sql);
		ps.setInt(1, no);
		ps.setString(2, gdto.getG_head());
		ps.setString(3, gdto.getG_title());
		ps.setString(4, gdto.getG_writer());
		ps.setString(5, gdto.getG_content());
		if (gdto.getG_parent() == 0) {
			ps.setNull(6, Types.INTEGER);
		} else {
			ps.setInt(6, gdto.getG_parent());
		}
		ps.setInt(7, gdto.getG_parent());
		ps.setInt(8, g_team);
		ps.setString(9, gdto.getG_savename());
		ps.setString(10, gdto.getG_uploadname());
		ps.setLong(11, gdto.getG_len());
		ps.setString(12, gdto.getG_type());

		

		System.out.println(gdto);
		ps.execute();
		con.close();
		return no;
	}

	public int getCount(String type, String keyword) throws Exception {
		Connection con = getConnection();
		boolean search = type != null && keyword != null;

		String sql = "select count(*) from g_board";
		if (search) {
			sql += " where " + type + " like '%'||?||'%'";
		}
		PreparedStatement ps = con.prepareStatement(sql);
		if (search) {
			ps.setString(1, keyword);
		}
		ResultSet rs = ps.executeQuery();
		rs.next();
		int count = rs.getInt(1);
		con.close();
		return count;

	}

	public List<g_boardDto> search(String type, String keyword, int start, int end) throws Exception {
		type = type.replace("+", "||");
		Connection con = getConnection();

		String sql = "select * from (" + "select rownum rn, A.* from (" + "select * from g_board where " + type
				+ " like '%'||?||'%' " + "order by g_when desc" + ") A" + ") where rn between ? and ?";

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, keyword);
		ps.setInt(2, start);
		ps.setInt(3, end);
		ResultSet rs = ps.executeQuery();

		List<g_boardDto> list = new ArrayList<>();

		while (rs.next()) {
			g_boardDto gdto = new g_boardDto();
			gdto.setDate(rs);
			list.add(gdto);
		}

		con.close();
		return list;
	}

	public List<g_boardDto> list(int start, int end) throws Exception {
		Connection con = this.getConnection();
		String sql = "select g_no,g_head,g_title,g_writer,g_content,g_read,g_when,g_parent,g_depth,g_team,g_savename,g_uploadname,g_len,g_type,"
				+ "(select count(*) from g_comments where origin = g_no) as g_count "
				+ "from (select a.*, rownum as rnum from (select * from g_board "
				+ "connect by prior g_no = g_parent start with g_parent is null "
				+ "order siblings by g_team desc, g_no asc)a) where rnum between ? and ? ";

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, start);
		ps.setInt(2, end);
		ResultSet rs = ps.executeQuery();

		List<g_boardDto> list = new ArrayList<g_boardDto>(); // ����ִ� ����Ʈ �غ�
		while (rs.next()) {
			// rs->PersonDto->list
			g_boardDto gdto1 = new g_boardDto();
			gdto1.setDateA(rs);
			list.add(gdto1);
		}
		con.close();
		return list;

	}

	public g_boardDto get(int gdto) throws Exception {
		Connection con = this.getConnection();
		String sql = "select * from g_board where g_no= ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, gdto);
		ResultSet rs = ps.executeQuery();

		g_boardDto gdto1 = new g_boardDto();

		if (rs.next()) {
			gdto1.setDate(rs);
		} else {
			gdto1 = null;
		}
		con.close();
		return gdto1;
	}

	public void readone(int no) throws Exception {
		Connection con = this.getConnection();
		String sql = "update g_board set " + "g_read = g_read + 1 where g_no = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, no);
		ps.execute();
		con.close();
	}
	public void delete(int no) throws Exception{
		Connection con = this.getConnection();
		String sql = "delete g_board where g_no = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, no);
		ps.execute();
		
		con.close();
	}
	public g_boardDto edit(g_boardDto gdto) throws Exception{
		Connection con = this.getConnection();		
		String sql="update g_board set g_head = ?, g_title = ?, g_content = ?, "
				+ "g_savename=?,g_uploadname=?,g_len=?,g_type=? where g_no = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, gdto.getG_head());
		ps.setString(2, gdto.getG_title());
		ps.setString(3, gdto.getG_content());
		ps.setString(4, gdto.getG_savename());
		ps.setString(5, gdto.getG_uploadname());
		ps.setLong(6, gdto.getG_len());
		ps.setString(7, gdto.getG_type());
		ps.setInt(8, gdto.getG_no());
		ps.execute();	
		con.close();
		return gdto;
		}
	public g_boardDto getdown(String gdto) throws Exception {
		Connection con = this.getConnection();
		String sql = "select * from g_board where g_savename= ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, gdto);
		ResultSet rs = ps.executeQuery();

		g_boardDto gdto1 = new g_boardDto();

		if (rs.next()) {
			gdto1.setDate(rs);
		} else {
			gdto1 = null;
		}
		con.close();
		return gdto1;
	}
	
	// 최근 7일 갤러리 게시글 수
			public int g_board() throws Exception {
				Connection con = this.getConnection();
				
				String sql = "select count(*) c from g_board WHERE g_when BETWEEN (SYSDATE-7) AND SYSDATE+1";
				PreparedStatement ps = con.prepareStatement(sql);
				
				ResultSet rs = ps.executeQuery();
				
				rs.next();
				
				int g_board = rs.getInt("c");
			         
			    con.close();
			        
			    return g_board;
			}
			
		// 최근 7일 갤러리 댓글 수
			public int g_comment() throws Exception {
				Connection con = this.getConnection();
				
				String sql = "select count(*) c from g_comments WHERE when BETWEEN (SYSDATE-7) AND SYSDATE+1";
				PreparedStatement ps = con.prepareStatement(sql);
				
				ResultSet rs = ps.executeQuery();
				
				rs.next();
				
				int g_comment = rs.getInt("c");
			         
			    con.close();
			        
			    return g_comment;
			}

}
