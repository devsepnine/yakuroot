package player.beans;

import java.sql.Connection;
import java.sql.DriverManager;

public class PlayerDao {
	
//	연결 메소드
	public Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "yakuroot", "baseball");
		return con;
	}
	
//	선수 프로필 데이터 불러오는 메소드
	
//	타자 데이터 불러오는 메소드
	
//	투수 데이터 불러오는 메소드

}
