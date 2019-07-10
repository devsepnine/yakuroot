package club.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ClubDao {
	
//	연결 메소드
	public Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "yakuroot", "baseball");
		return con;
	}
//  구단 데이터 넣는 메소드
	public void input(ClubDto cdto) throws Exception {
		Connection con = getConnection();
		
		String sql = "insert into club values(culb_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, cdto.getC_name());
		ps.setString(2, cdto.getC_photo());
		ps.setString(3, cdto.getC_club());
		ps.setString(4, cdto.getC_player());
		ps.setString(5, cdto.getC_stadium());
		ps.setString(6, cdto.getC_year());
		ps.setString(7, cdto.getC_born());
		ps.setString(8, cdto.getC_map());
		
		ps.execute();
		con.close();
	}
//	구단 데이터 불러오는 메소드
	
//	구단 소개 불러오는 메소드
	
//	구단 소속 선수 불러오는 메소드
	
//	구단 홈 경기장 정보 불러오는 메소드
	
//	음 뭔지 모르겠는데 하나 더 있어야 할 것 같은 메소드
	
//	구단 시즌 성적 데이터 불러오는 메소드

}
