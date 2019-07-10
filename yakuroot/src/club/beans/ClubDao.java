package club.beans;

import java.sql.Connection;
import java.sql.DriverManager;

public class ClubDao {
	
//	연결 메소드
	public Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "yakuroot", "baseball");
		return con;
	}
//  구단 데이터 넣는 메소드
	
//	구단 데이터 불러오는 메소드
	
//	구단 소개 불러오는 메소드
	
//	구단 소속 선수 불러오는 메소드
	
//	구단 홈 경기장 정보 불러오는 메소드
	
//	음 뭔지 모르겠는데 하나 더 있어야 할 것 같은 메소드
	
//	구단 시즌 성적 데이터 불러오는 메소드

}
