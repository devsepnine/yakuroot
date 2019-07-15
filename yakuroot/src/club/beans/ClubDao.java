package club.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ClubDao {
	
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
	
	
//  구단 데이터 넣는 메소드
	public void input(ClubDto cdto) throws Exception {
		Connection con = getConnection();
		
		String sql = "insert into club values(culb_seq.nextval, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, cdto.getC_name());
		ps.setString(2, cdto.getC_photo());
		ps.setString(3, cdto.getC_club());
		ps.setString(4, cdto.getC_stadium());
		ps.setString(5, cdto.getC_year());
		ps.setString(6, cdto.getC_born());
		ps.setString(7, cdto.getC_map());
		
		ps.execute();
		con.close();
	}
	
	
//	구단 데이터 불러오는 메소드
	public ClubDto get(int c_no) throws Exception {
		Connection con = getConnection();
		
		String sql = "select * from club where c_no = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, c_no);
		ResultSet rs = ps.executeQuery();
		
		ClubDto cdto;
		if(rs.next()) {
			cdto = new ClubDto();
			cdto.setData(rs);
		}
		else {
			cdto = null;
		}
		con.close();
		return cdto;
	}
	
	
//	등록된 구단 목록 불러오는 리스트 메소드
	public List<ClubDto> getClub() throws Exception {
		Connection con = getConnection();
		
		String sql = "select * from club";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		ClubDto cdto;
		List<ClubDto> list = new ArrayList<ClubDto>();
		while(rs.next()) {
			cdto = new ClubDto();
			cdto.setData(rs);
			list.add(cdto);
		}
		con.close();
		return list;
	}
	
	
//	구단 리스트 수정하는 메소드
	public void edit(ClubDto cdto) throws Exception {
		Connection con = getConnection();
		
		String sql = "update club set c_name=?, c_year=?, c_born=?, c_club=?, c_map = ? where c_no=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, cdto.getC_name());
		ps.setString(2, cdto.getC_year());
		ps.setString(3, cdto.getC_born());
		ps.setString(4, cdto.getC_club());
		ps.setString(5, cdto.getC_map());
		ps.setInt(6, cdto.getC_no());
		
		ps.execute();
		con.close();
	}
	
}
