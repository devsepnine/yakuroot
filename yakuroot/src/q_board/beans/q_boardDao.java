package q_board.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class q_boardDao {
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
		public int write(q_boardDto qdto) throws Exception {

			Connection con = this.getConnection();
			String sql = "select q_board_seq.nextval from dual";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.next();
			int no = rs.getInt(1);
			ps.close();

			int q_team;
			if (qdto.getQ_parent() > 0) {
				sql = "select q_team from q_board where q_no = ?";
				ps = con.prepareStatement(sql);
				ps.setInt(1, qdto.getQ_parent());
				rs = ps.executeQuery();
				rs.next();
				q_team = rs.getInt("q_team");
				ps.close();
			} else {
				q_team = no;
			}

			sql = "insert into q_board values(?,?,?,?,?,0,sysdate,?,"
					+ "(select nvl(q_depth,0)+1 from q_board where q_no=?),?,?,?,?,?)";

			ps = con.prepareStatement(sql);
			ps.setInt(1, no);
			ps.setString(2, qdto.getQ_head());
			ps.setString(3, qdto.getQ_title());
			ps.setString(4, qdto.getQ_writer());
			ps.setString(5, qdto.getQ_content());
			if (qdto.getQ_parent() == 0) {
				ps.setNull(6, Types.INTEGER);
			} else {
				ps.setInt(6, qdto.getQ_parent());
			}
			ps.setInt(7, qdto.getQ_parent());
			ps.setInt(8, q_team);
			ps.setString(9, qdto.getQ_savename());
			ps.setString(10, qdto.getQ_uploadname());
			ps.setLong(11, qdto.getQ_len());
			ps.setString(12, qdto.getQ_type());

			System.out.println(qdto);			
			ps.execute();
			con.close();
			return no;
		}
		
		public int getCount(String type, String keyword) throws Exception {
			Connection con = getConnection();
			boolean search = type != null && keyword != null;

			String sql = "select count(*) from q_board";
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
		public List<q_boardDto> search(String type, String keyword, int start, int end) throws Exception {
			type = type.replace("+", "||");
			Connection con = getConnection();

			String sql = "select * from (" + "select rownum rn, A.* from (" + "select * from q_board where " + type
					+ " like '%'||?||'%' " + "order by q_when desc" + ") A" + ") where rn between ? and ?";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, keyword);
			ps.setInt(2, start);
			ps.setInt(3, end);
			ResultSet rs = ps.executeQuery();

			List<q_boardDto> list = new ArrayList<>();

			while (rs.next()) {
				q_boardDto qdto = new q_boardDto();
				qdto.setDate(rs);
				list.add(qdto);
			}

			con.close();
			return list;
		}
		public List<q_boardDto> list(int start, int end) throws Exception {
			Connection con = this.getConnection();
			String sql = "select * from (select a.*, rownum as rnum from (select * from q_board "
					+ "connect by prior q_no = q_parent start with q_parent is null "
					+ "order siblings by q_team desc, q_no asc)a) where rnum between ? and ? ";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, end);
			ResultSet rs = ps.executeQuery();

			List<q_boardDto> list = new ArrayList<q_boardDto>(); // ����ִ� ����Ʈ �غ�
			while (rs.next()) {
				// rs->PersonDto->list
				q_boardDto qdto1 = new q_boardDto();
				qdto1.setDate(rs);
				list.add(qdto1);
			}
			con.close();
			return list;
		}
		public q_boardDto get(int qdto) throws Exception {
			Connection con = this.getConnection();
			String sql = "select * from q_board where q_no= ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, qdto);
			ResultSet rs = ps.executeQuery();

			q_boardDto qdto1 = new q_boardDto();

			if (rs.next()) {
				qdto1.setDate(rs);
			} else {
				qdto1 = null;
			}
			con.close();
			return qdto1;
		}
		public void readone(int no) throws Exception {
			Connection con = this.getConnection();
			String sql = "update q_board set " + "q_read = q_read + 1 where q_no = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, no);
			ps.execute();
			con.close();
		}
		public void delete(int no) throws Exception{
			Connection con = this.getConnection();
			String sql = "delete q_board where q_no = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, no);
			ps.execute();
			
			con.close();
		}
		public q_boardDto edit(q_boardDto qdto) throws Exception{
			Connection con = this.getConnection();		
			String sql="update q_board set q_head = ?, q_title = ?, q_content = ? where q_no = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, qdto.getQ_head());
			ps.setString(2, qdto.getQ_title());
			ps.setString(3, qdto.getQ_content());
			ps.setInt(4, qdto.getQ_no());
			ps.execute();	
			con.close();
			return qdto;
			}
		public q_boardDto getdown(String qdto) throws Exception {
			Connection con = this.getConnection();
			String sql = "select * from q_board where q_savename= ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, qdto);
			ResultSet rs = ps.executeQuery();

			q_boardDto qdto1 = new q_boardDto();

			if (rs.next()) {
				qdto1.setDate(rs);
			} else {
				qdto1 = null;
			}
			con.close();
			return qdto1;
		}
		
}
