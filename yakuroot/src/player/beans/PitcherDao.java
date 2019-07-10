package player.beans;

import java.sql.Connection;
import java.sql.DriverManager;

public class PitcherDao {
	
//	연결 메소드
	public Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "yakuroot", "baseball");
		return con;
	}
	

}
