package notice_board.beans;

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
import g_board.beans.g_boardDto;
import notice_board.beans.n_boardDto;

public class n_boardDao {
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

	public int write(n_boardDto ndto) throws Exception {// 공지사항 입력 메소드

		Connection con = this.getConnection();
		String sql = "select n_board_seq.nextval from dual";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		rs.next();
		int no = rs.getInt(1);
		ps.close();
		
		int n_team;
		if (ndto.getF_parent() > 0) {
			sql = "select n_team from notice_board where n_no = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, ndto.getF_parent());
			rs = ps.executeQuery();
			rs.next();
			n_team = rs.getInt("n_team");
			ps.close();
		} else {
			n_team = no;
		}

		sql = "insert into notice_board values(?,?,?,?,?,0,sysdate,?,(select nvl(f_depth,0)+1 from notice_board where n_no=?),?,?,?,?,?)";

		ps = con.prepareStatement(sql);
		ps.setInt(1, no);
		ps.setString(2, ndto.getN_head());
		ps.setString(3, ndto.getN_title());
		ps.setString(4, ndto.getN_writer());
		ps.setString(5, ndto.getN_content());
		if (ndto.getF_parent() == 0) {
			ps.setNull(6, Types.INTEGER);
		} else {
			ps.setInt(6, ndto.getF_parent());
		}
		ps.setInt(7, ndto.getF_parent());
		ps.setInt(8, n_team);
		ps.setString(9, ndto.getN_savename());
		ps.setString(10, ndto.getN_uploadname());
		ps.setLong(11, ndto.getN_len());
		ps.setString(12, ndto.getN_type());

		System.out.println(ndto);
		ps.execute();
		con.close();
		return no;
	}

	public n_boardDto get(int ndto) throws Exception {// 공지사항 정보 출력 메소드
		Connection con = this.getConnection();
		String sql = "select * from notice_board where n_no= ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, ndto);
		ResultSet rs = ps.executeQuery();

		n_boardDto ndto1 = new n_boardDto();

		if (rs.next()) {
			ndto1.setDate(rs);
		} else {
			ndto1 = null;
		}
		con.close();
		return ndto1;
	}

	public void readone(int no) throws Exception {// 조회수 추가 메소드
		Connection con = this.getConnection();
		String sql = "update notice_board set " + "n_read = n_read + 1 where n_no = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, no);
		ps.execute();
		con.close();
	}

	public n_boardDto edit(n_boardDto ndto) throws Exception {// 공지사항 글 수정 메소드
		Connection con = this.getConnection();
		String sql = "update notice_board set n_head = ?, n_title = ?, n_content = ?,"
				+ "n_savename=?,n_uploadname=?,n_len=?,n_type=? where n_no = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, ndto.getN_head());
		ps.setString(2, ndto.getN_title());
		ps.setString(3, ndto.getN_content());
		ps.setString(4, ndto.getN_savename());
		ps.setString(5, ndto.getN_uploadname());
		ps.setLong(6, ndto.getN_len());
		ps.setString(7, ndto.getN_type());
		ps.setInt(8, ndto.getN_no());
		ps.execute();
		con.close();
		return ndto;
	}

	public void delete(int no) throws Exception {// 공지사항 글 삭제 메소드
		Connection con = this.getConnection();
		String sql = "delete notice_board where n_no = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, no);
		ps.execute();

		con.close();
	}
	public List<n_boardDto> list(int start, int end) throws Exception {//공지사항 리스트 출력 메소드
		Connection con = this.getConnection();
		String sql = "select n_no,n_head,n_title,n_writer,n_content,n_read,n_when,f_parent,f_depth,f_team,n_savename,n_uploadname,n_len,n_type,"
				+ "(select count(*) from n_comments where origin = n_no) as n_count "
				+ "from (select a.*, rownum as rnum from (select * from notice_board "
				+ "connect by prior n_no = f_parent start with f_parent is null "
				+ "order siblings by f_team desc, n_no asc)a) where rnum between ? and ? ";

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, start);
		ps.setInt(2, end);
		ResultSet rs = ps.executeQuery();

		List<n_boardDto> list = new ArrayList<n_boardDto>();
		while (rs.next()) {
			// rs->PersonDto->list
			n_boardDto ndto1 = new n_boardDto();
			ndto1.setDateA(rs);
			list.add(ndto1);
		}
		con.close();
		return list;

	}
	//공지사항 검색 메소드
	public List<n_boardDto> search(String type, String keyword, int start, int end) throws Exception {
		type = type.replace("+", "||");
		Connection con = getConnection();

		String sql = "select * from (" + "select rownum rn, A.* from (" + "select * from notice_board where " + type
				+ " like '%'||?||'%' " + "order by n_when desc" + ") A" + ") where rn between ? and ?";

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, keyword);
		ps.setInt(2, start);
		ps.setInt(3, end);
		ResultSet rs = ps.executeQuery();

		List<n_boardDto> list = new ArrayList<>();

		while (rs.next()) {
			n_boardDto ndto = new n_boardDto();
			ndto.setDate(rs);
			list.add(ndto);
		}

		con.close();
		return list;
	}
	public int getCount(String type, String keyword) throws Exception {
		Connection con = getConnection();
		boolean search = type != null && keyword != null;

		String sql = "select count(*) from notice_board";
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
	public n_boardDto getdown(String ndto) throws Exception {
		Connection con = this.getConnection();
		String sql = "select * from notice_board where n_savename= ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, ndto);
		ResultSet rs = ps.executeQuery();

		n_boardDto ndto1 = new n_boardDto();

		if (rs.next()) {
			ndto1.setDate(rs);
		} else {
			ndto1 = null;
		}
		con.close();
		return ndto1;
	}
	
}
