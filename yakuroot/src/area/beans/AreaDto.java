package area.beans;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AreaDto {
	private int a_no;
	private int stadium_no;
	private int a_row;
	private int a_col;
	private String a_name;
	
	
	public int getA_no() {
		return a_no;
	}

	public void setA_no(int a_no) {
		this.a_no = a_no;
	}

	public int getStadium_no() {
		return stadium_no;
	}

	public void setStadium_no(int stadium_no) {
		this.stadium_no = stadium_no;
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

	public AreaDto() {
		super();
	}
	
	
	@Override
	public String toString() {
		return "AreaDto [a_no=" + a_no + ", stadium_no=" + stadium_no + ", a_row=" + a_row + ", a_col=" + a_col
				+ ", a_name=" + a_name + "]";
	}

	public AreaDto(ResultSet rs) throws SQLException {
		this.setStadium_no(rs.getInt("s_no"));
		this.setA_no(rs.getInt("a_no"));
		this.setA_row(rs.getInt("a_row"));
		this.setA_col(rs.getInt("a_col"));
		this.setA_name(rs.getString("a_name"));
	}
}
