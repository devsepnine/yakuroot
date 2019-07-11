package player.beans;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BatterDao {
	
//	연결 메소드
//	DBCP 방식 (미리 만들어두고 렌탈하는 방식)
	//	context.xml에 있는 resource 정보를 알아야만 렌탈이가능하다.
	//	static 키워드를 붙여서 DAO 모든 인스턴스에서 공용으로 적용
		static DataSource src; //import sql datasource
	//	static 전용 초기화 구문을 이용한다(초기화가 복잡함으로)
		static {
	//		파일과 자원을 찾을수 있는 탐사 객체를 만듬
	//		2. 탐사객체를 이용하여 jdbc 오라클 이름을 가진 자원 정보를 src에 대입한다.
			try {
				Context ctx = new InitialContext(); // 탐사객체 import naming
				src = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle"); // "?" 대한 내용을 찾아온다.			
			}catch(Exception e) {
				System.err.println("dbcp err");
				e.printStackTrace();
				
			}
		}
//		접속하는 메소드
		public Connection getConnection() throws Exception{
			return src.getConnection();
		}

}
