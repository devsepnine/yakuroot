package resdata.beans;

import java.sql.ResultSet;
import java.sql.SQLException;

public class resdataDto {
	int r_no;
	int member_no;
	int seat_no;
	int match_no;
	String r_time;
	public int getR_no() {
		return r_no;
	}
	public void setR_no(int r_no) {
		this.r_no = r_no;
	}
	public int getMember_no() {
		return member_no;
	}
	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}
	public int getSeat_no() {
		return seat_no;
	}
	public void setSeat_no(int seat_no) {
		this.seat_no = seat_no;
	}
	public int getMatch_no() {
		return match_no;
	}
	public void setMatch_no(int match_no) {
		this.match_no = match_no;
	}
	public String getR_time() {
		return r_time;
	}
	public void setR_time(String r_time) {
		this.r_time = r_time;
	}
	@Override
	public String toString() {
		return "resdataDto [r_no=" + r_no + ", member_no=" + member_no + ", seat_no=" + seat_no + ", match_no="
				+ match_no + ", r_time=" + r_time + "]";
	}
	public resdataDto() {
		super();
	}
	
	public resdataDto(ResultSet rs) throws SQLException {
		this.setR_no(rs.getInt("r_no"));
		this.setMember_no(rs.getInt("member_no"));
		this.setMatch_no(rs.getInt("match_no"));
		this.setSeat_no(rs.getInt("seat_no"));
		this.setR_time(rs.getString("r_time"));
	}
}
