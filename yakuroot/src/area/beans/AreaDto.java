package area.beans;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AreaDto {
	private int a_no;
	private int s_no;
	private int a_row;
	private int a_col;
	private String a_name;
	public int getA_no() {
		return a_no;
	}
	public void setA_no(int a_no) {
		this.a_no = a_no;
	}
	public int getS_no() {
		return s_no;
	}
	public void setS_no(int s_no) {
		this.s_no = s_no;
	}
	public int getA_row() {
		return a_row;
	}
	public void setA_row(int a_row) {
		this.a_row = a_row;
	}
	public int getA_col() {
		return a_col;
	}
	public void setA_col(int a_col) {
		this.a_col = a_col;
	}
	public String getA_name() {
		return a_name;
	}
	public void setA_name(String a_name) {
		this.a_name = a_name;
	}
	@Override
	public String toString() {
		return "AreaDto [a_no=" + a_no + ", s_no=" + s_no + ", a_row=" + a_row + ", a_col=" + a_col + ", a_name="
				+ a_name + "]";
	}
	public AreaDto() {
		super();
	}
	
	public AreaDto(ResultSet rs) throws SQLException {
		this.setS_no(rs.getInt("s_no"));
		this.setA_no(rs.getInt("a_no"));
		this.setA_row(rs.getInt("a_row"));
		this.setA_col(rs.getInt("a_col"));
		this.setA_name(rs.getString("a_name"));
	}
}
