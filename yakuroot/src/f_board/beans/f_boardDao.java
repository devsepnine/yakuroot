package f_board.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import f_board.beans.f_boardDto;

public class f_boardDao {
	public Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "baseball", "baseball");
		return con;
	}

	public int write(f_boardDto bdto) throws Exception {

		Connection con = this.getConnection();
		String sql = "select f_board_seq.nextval from dual";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		rs.next();
		int no = rs.getInt(1);
		ps.close();

		// 2 답글일 경우 소속글의 team 번호를 미리 구함
		int f_team;
		if (bdto.getF_parent() > 0) {// 답글
			sql = "select f_team from f_board where f_no = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, bdto.getF_parent());
			rs = ps.executeQuery();
			rs.next();
			f_team = rs.getInt("f_team");
			ps.close();
		} else {// 새글
			f_team = no;
		}

		// 현재 들어갈 게시글의 번호
		// 1번에서 구한 번호를 대응하여 게시글 추가
		sql = "insert into f_board values(" + "?,?,?,?,?,0,sysdate,?,"
				+ "(select nvl(f_depth,0)+1 from f_board where f_no=?),?)";
		// nvl(항목,값):항목이null일때 값으로 치환
		// nvl(depth+1,0):depth+1이 null이면 0으로 바꿈
		// --no를 상위개념 , parent를 하위개념으로 연결
		// connect by prior no = parent
		// --parent가 null인 항목부터 진행
		// start with parent is null
		// --정렬순서는 no 역순으로 진행
		// order siblings by no desc;
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
		ps.setInt(8, f_team);// 2번에서 계산한 team값

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
				+ " like '%'||?||'%' " + "order by when desc" + ") A" + ") where rn between ? and ?";

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
		String sql = "select * from (select a.*, rownum as rnum from (select * from f_board "
				+ "connect by prior f_no = f_parent start with f_parent is null "
				+ "order siblings by f_team desc, f_no asc)a) where rnum between ? and ? ";

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, start);
		ps.setInt(2, end);
		ResultSet rs = ps.executeQuery();

		List<f_boardDto> list = new ArrayList<f_boardDto>(); // 비어있는 리스트 준비
		while (rs.next()) {
			// rs->PersonDto->list
			f_boardDto bdto1 = new f_boardDto();
			bdto1.setDate(rs);
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
	public void readone(int no) throws Exception{
		Connection con = this.getConnection();		
		String sql="update f_board set "
				+ "f_read = f_read + 1 where f_no = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, no);
		ps.execute();
		con.close();
}
	public void delete(int no) throws Exception{
		Connection con = this.getConnection();
		String sql = "delete f_board where f_no = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, no);
		ps.execute();
		
		con.close();
	}
	public f_boardDto edit(f_boardDto bdto) throws Exception{//회원정보 검색 메소드
		Connection con = this.getConnection();		
		String sql="update f_board set f_head = ?, f_title = ?, f_content = ? where f_no = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, bdto.getF_head());
		ps.setString(2, bdto.getF_title());
		ps.setString(3, bdto.getF_content());
		ps.setInt(4, bdto.getF_no());
		ps.execute();	
		
		con.close();
		return bdto;
		}
}