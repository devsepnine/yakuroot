package files;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class filesDao {
	
	public Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "yakuroot", "baseball");
		return con;
	}
	
	public void insert(filesDto fdto) throws Exception{
		Connection con = this.getConnection();
		String sql = "insert into files values(?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, fdto.getSavename());
		ps.setString(2, fdto.getUploadname());
		ps.setLong(3, fdto.getLen());
		ps.setString(4, fdto.getType());
		ps.execute();
		con.close();
		
	}
	public List<filesDto> list() throws Exception{
		Connection con = this.getConnection();
		String sql = "select * from files";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<filesDto> list = new ArrayList<filesDto>();
		while (rs.next()) {
			filesDto fdto = new filesDto();
			fdto.setDate(rs);
			list.add(fdto);
		}
		con.close();		
		return list;
	}
	public filesDto get(String savename) throws Exception{
		Connection con = this.getConnection();
		String sql = "select * from files where savename = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, savename);
		ResultSet rs = ps.executeQuery();
		filesDto fdto = new filesDto();
		if(rs.next()) {
			fdto.setDate(rs);
		}else {
			fdto=null;
		}
		con.close();
		return fdto;
	}
	public void delete(String savename) throws Exception{
		Connection con = this.getConnection();
		String sql = "delete files where savename = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, savename);
		ps.execute();
		con.close();
	}
}
