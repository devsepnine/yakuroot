package resdata.beans;

import java.sql.ResultSet;
import java.sql.SQLException;

public class resdataDto {
	int r_no;
	String member_id;
	int match_no;
	int stadium_no;
	int area_no;
	int seat_no;
	String r_time;
	

	@Override
	public String toString() {
		return "resdataDto [r_no=" + r_no + ", member_id=" + member_id + ", match_no=" + match_no + ", stadium_no="
				+ stadium_no + ", area_no=" + area_no + ", seat_no=" + seat_no + ", r_time=" + r_time + "]";
	}

	public int getR_no() {
		return r_no;
	}

	public void setR_no(int r_no) {
		this.r_no = r_no;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public int getMatch_no() {
		return match_no;
	}

	public void setMatch_no(int match_no) {
		this.match_no = match_no;
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

	public int getSeat_no() {
		return seat_no;
	}

	public void setSeat_no(int seat_no) {
		this.seat_no = seat_no;
	}

	public String getR_time() {
		return r_time;
	}

	public void setR_time(String r_time) {
		this.r_time = r_time;
	}

	public resdataDto() {
		super();
	}
	
	public resdataDto(ResultSet rs) throws SQLException {
		this.setR_no(rs.getInt("r_no"));
		this.setMember_id(rs.getString("member_id"));
		this.setMatch_no(rs.getInt("match_no"));
		this.setSeat_no(rs.getInt("seat_no"));
		this.setR_time(rs.getString("r_time"));
	}
}
