package seat.beans;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SeatDto {
	private int seat_no;
	private int stadium_no;
	private int area_no;
	private int s_x;
	private int s_y;
	private int s_able;
	private String seat_name;


	public int getSeat_no() {
		return seat_no;
	}

	public void setSeat_no(int seat_no) {
		this.seat_no = seat_no;
	}

	public int getStadium_no() {
		return stadium_no;
	}

	public void setStadium_no(int stadium_no) {
		this.stadium_no = stadium_no;
	}

	public int getArea_no() {
		return area_no;
	}



	public void setArea_no(int area_no) {
		this.area_no = area_no;
	}



	public int getS_x() {
		return s_x;
	}



	public void setS_x(int s_x) {
		this.s_x = s_x;
	}



	public int getS_y() {
		return s_y;
	}



	public void setS_y(int s_y) {
		this.s_y = s_y;
	}



	public int getS_able() {
		return s_able;
	}



	public void setS_able(int s_able) {
		this.s_able = s_able;
	}



	public String getSeat_name() {
		return seat_name;
	}



	public void setSeat_name(String seat_name) {
		this.seat_name = seat_name;
	}
	


	public SeatDto() {
		super();
	}



	@Override
	public String toString() {
		return "SeatDto [seat_no=" + seat_no + ", stadium_no=" + stadium_no + ", area_no=" + area_no + ", s_x=" + s_x
				+ ", s_y=" + s_y + ", s_able=" + s_able + ", seat_name=" + seat_name + "]";
	}



	public SeatDto(ResultSet rs) throws SQLException {
		this.setSeat_no(rs.getInt("seat_no"));
		this.setStadium_no(rs.getInt("stadium_no"));
		this.setArea_no(rs.getInt("area_no"));
		this.setS_x(rs.getInt("s_x"));
		this.setS_y(rs.getInt("s_y"));
		this.setS_able(rs.getInt("s_able"));
		this.setSeat_name(rs.getString("seat_name"));
	}
}
