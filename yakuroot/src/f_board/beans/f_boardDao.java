package f_board.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import f_board.beans.f_boardDto;

public class f_boardDao {
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

	public Connection getConnection() throws Exception {
		return src.getConnection();
	}

	public int write(f_boardDto bdto) throws Exception {

		Connection con = this.getConnection();
		String sql = "select f_board_seq.nextval from dual";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		rs.next();
		int no = rs.getInt(1);
		ps.close();

		int f_team;
		if (bdto.getF_parent() > 0) {
			sql = "select f_team from f_board where f_no = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, bdto.getF_parent());
			rs = ps.executeQuery();
			rs.next();
			f_team = rs.getInt("f_team");
			ps.close();
		} else {
			f_team = no;
		}

		sql = "insert into f_board values(?,?,?,?,?,0,sysdate,?,(select nvl(f_depth,0)+1 from f_board where f_no=?),?,?,?,?,?)";

		ps = con.prepareStatement(sql);
		ps.setInt(1, no);
		ps.setString(2, bdto.getF_head());
		ps.setString(3, bdto.getF_title());
		ps.setString(4, bdto.getF_writer());
		ps.setString(5, bdto.getF_content());
		if (bdto.getF_parent() == 0) {
			ps.setNull(6, Types.INTEGER);
		} else {
			ps.setInt(6, bdto.getF_parent());
		}
		ps.setInt(7, bdto.getF_parent());
		ps.setInt(8, f_team);
		ps.setString(9, bdto.getF_savename());
		ps.setString(10, bdto.getF_uploadname());
		ps.setLong(11, bdto.getF_len());
		ps.setString(12, bdto.getF_type());

		System.out.println(bdto);
		ps.execute();
		con.close();
		return no;
	}

	public int getCount(String type, String keyword) throws Exception {
		Connection con = getConnection();
		boolean search = type != null && keyword != null;

		String sql = "select count(*) from f_board";
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

	public List<f_boardDto> search(String type, String keyword, int start, int end) throws Exception {
		type = type.replace("+", "||");
		Connection con = getConnection();

		String sql = "select * from (" + "select rownum rn, A.* from (" + "select * from f_board where " + type
				+ " like '%'||?||'%' " + "order by f_when desc" + ") A" + ") where rn between ? and ?";

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, keyword);
		ps.setInt(2, start);
		ps.setInt(3, end);
		ResultSet rs = ps.executeQuery();

		List<f_boardDto> list = new ArrayList<>();

		while (rs.next()) {
			f_boardDto bdto = new f_boardDto();
			bdto.setDate(rs);
			list.add(bdto);
		}

		con.close();
		return list;
	}

	public List<f_boardDto> list(int start, int end) throws Exception {
		Connection con = this.getConnection();
		String sql = "select f_no,f_head,f_title,f_writer,f_content,f_read,f_when,f_parent,f_depth,f_team,f_savename,f_uploadname,f_len,f_type,"
				+ "(select count(*) from f_comments where origin = f_no) as f_count "
				+ "from (select a.*, rownum as rnum from (select * from f_board "
				+ "connect by prior f_no = f_parent start with f_parent is null "
				+ "order siblings by f_team desc, f_no asc)a) where rnum between ? and ? ";

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, start);
		ps.setInt(2, end);
		ResultSet rs = ps.executeQuery();

		List<f_boardDto> list = new ArrayList<f_boardDto>(); 
		while (rs.next()) {
			// rs->PersonDto->list
			f_boardDto bdto1 = new f_boardDto();
			bdto1.setDateA(rs);
			list.add(bdto1);
		}
		con.close();
		return list;

	}

	public f_boardDto get(int bdto) throws Exception {
		Connection con = this.getConnection();
		String sql = "select * from f_board where f_no= ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, bdto);
		ResultSet rs = ps.executeQuery();

		f_boardDto bdto1 = new f_boardDto();

		if (rs.next()) {
			bdto1.setDate(rs);
		} else {
			bdto1 = null;
		}
		con.close();
		return bdto1;
	}

	public void readone(int no) throws Exception {
		Connection con = this.getConnection();
		String sql = "update f_board set " + "f_read = f_read + 1 where f_no = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, no);
		ps.execute();
		con.close();
	}

	public void delete(int no) throws Exception {
		Connection con = this.getConnection();
		String sql = "delete f_board where f_no = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, no);
		ps.execute();

		con.close();
	}

	public f_boardDto edit(f_boardDto bdto) throws Exception {
		Connection con = this.getConnection();
		String sql = "update f_board set f_head = ?, f_title = ?, f_content = ? where f_no = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, bdto.getF_head());
		ps.setString(2, bdto.getF_title());
		ps.setString(3, bdto.getF_content());
		ps.setInt(4, bdto.getF_no());
		ps.execute();
		con.close();
		return bdto;
	}
	
	//자유게시판 게시글 수
		public int f_board() throws Exception {
			Connection con = this.getConnection();
			
			String sql = "select count(*) c from f_board WHERE f_when BETWEEN (SYSDATE-7) AND SYSDATE+1";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			rs.next();
			
			int f_board = rs.getInt("c");
		         
		    con.close();
		        
		    return f_board;
		}
	
	// 최근 7일 자유게시판 댓글 수
	 	public int f_comment() throws Exception {
			Connection con = this.getConnection();
			
			String sql = "select count(*) c from f_comments WHERE when BETWEEN (SYSDATE-7) AND SYSDATE+1";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			rs.next();
			
			int f_comment = rs.getInt("c");
		         
		    con.close();
		        
		    return f_comment;
		}
		
	
		
	}

