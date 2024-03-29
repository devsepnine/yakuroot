package match.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MatchupDao {
	
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
		
//		경기일정 가져오는 메소드
		public List<MatchupDto> getMatchup() throws Exception{
			Connection con = getConnection();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			String sql = "select * from matchup where m_date > to_date('"+sdf.format(System.currentTimeMillis())+"', 'YYYY/MM/DD HH24:MI:SS') order by match_no desc";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			List<MatchupDto> list = new ArrayList<MatchupDto>();
			while(rs.next()) {
				MatchupDto updto = new MatchupDto(rs);
				list.add(updto);
			}
			con.close();
			return list;
		}

//		지난 경기일정 가져오는 메소드
		public List<MatchupDto> getMatchDown() throws Exception{
			Connection con = getConnection();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			String sql = "select * from matchup where m_date < to_date('"+sdf.format(System.currentTimeMillis())+"', 'YYYY/MM/DD HH24:MI:SS') order by match_no desc";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			List<MatchupDto> list = new ArrayList<MatchupDto>();
			while(rs.next()) {
				MatchupDto updto = new MatchupDto(rs);
				list.add(updto);
			}
			con.close();
			return list;
		}
		
		//최근 4경기 가져오는 메소드
		public List<MatchupDto> get4Matchup() throws Exception{
			Connection con = getConnection();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			String sql = "select * from (select a.*, rownum as rnum from (select * from matchup where m_date > to_date('"+sdf.format(System.currentTimeMillis())+"', 'YYYY/MM/DD HH24:MI:SS') order by match_no desc) a)where rnum < 6";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			List<MatchupDto> list = new ArrayList<MatchupDto>();
			while(rs.next()) {
				MatchupDto updto = new MatchupDto(rs);
				list.add(updto);
			}
			con.close();
			return list;
		}

}
