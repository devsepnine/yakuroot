package area.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class AreaDao {
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
		
		public List<AreaDto> getArea(int stadium_no)throws Exception{
			Connection con = getConnection();
			String sql = "select * from area where stadium_no = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, stadium_no);
			ResultSet rs = pstmt.executeQuery();
			List<AreaDto> adtolist = new ArrayList<AreaDto>();
			while(rs.next()) {
				AreaDto adto = new AreaDto(rs);
				adtolist.add(adto);
			}
			con.close();
			return adtolist;
		}
		
		public AreaDto getArea_n(int area_no)throws Exception{
			Connection con = getConnection();
			String sql = "select * from area where a_no = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, area_no);
			ResultSet rs = pstmt.executeQuery();
			AreaDto adto = new AreaDto();
			if(rs.next()) {
				adto = new AreaDto(rs);
			}
			con.close();
			return adto;
		}

}

