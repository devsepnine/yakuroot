package stadium.beans;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StadiumDto {

	private int s_no;
	private String s_name;
	public int getS_no() {
		return s_no;
	}
	public void setS_no(int s_no) {
		this.s_no = s_no;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	@Override
	public String toString() {
		return "StadiumDto [s_no=" + s_no + ", s_name=" + s_name + "]";
	}
	public StadiumDto() {
		super();
	}
	
	public StadiumDto(ResultSet rs) throws SQLException {
		this.setS_name(rs.getString("s_name"));
		this.setS_no(s_no = rs.getInt("s_no"));
	}
	
	
}
