package player.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class PlayerDao {
	
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
	
//		선수 데이터 넣는 메소드
		public void input(PlayerDto pdto) throws Exception {
			Connection con = getConnection();
			
			String sql = "insert into player values(player_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, pdto.getP_club());
			ps.setString(2, pdto.getP_photo());
			ps.setString(3, pdto.getP_name());
			ps.setInt(4, pdto.getP_bnum());
			ps.setString(5, pdto.getP_birth());
			ps.setInt(6, pdto.getP_height());
			ps.setInt(7, pdto.getP_weight());
			ps.setString(8, pdto.getP_position());
			
			ps.execute();
			con.close();
		}
		
//		선수 데이터 불러오는 메소드
		public PlayerDto get(int p_no) throws Exception {
			Connection con = getConnection();
			
			String sql = "select * from player where p_no = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, p_no);
			ResultSet rs = ps.executeQuery();
			
			PlayerDto pdto;
			if(rs.next()) {
				pdto = new PlayerDto();
				pdto.setData(rs);
			}
			else {
				pdto = null;
			}
			con.close();
			return pdto;
		}
		
//		등록된 선수 목록 불러오는 리스트 메소드
		
		
		
		
		
//	선수 프로필 데이터 불러오는 메소드
	
//	타자 데이터 불러오는 메소드
	
//	투수 데이터 불러오는 메소드

}
