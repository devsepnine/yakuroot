package club.beans;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClubDto {
	private int c_no;//구단 고유 번호
	private String c_name;//구단 이름
	private String c_photo;//구단 로고
	private String c_club;//구단 소개
	private String c_player;//구단 선수 소개
	private String c_stadium;//구단 홈 경기장 소개
	private String c_year;//구단 창단 년도
	private String c_born;//구단 연고지
	private String c_map;//홈 경기장 지도 좌표
	
	
	public ClubDto(ResultSet rs) throws SQLException {
		this.setC_no(rs.getInt("c_no"));
		this.setC_name(rs.getString("c_name"));
		this.setC_photo(rs.getString("c_photo"));
		this.setC_club(rs.getString("c_club"));
		this.setC_player(rs.getString("c_player"));
		this.setC_stadium(rs.getString("c_stadium"));
		this.setC_year(rs.getString("c_year"));
		this.setC_born(rs.getString("c_born"));
		this.setC_map(rs.getString("c_map"));
	}
	
	
	public ClubDto() {
		super();
	}


	@Override
	public String toString() {
		return "ClubDto [c_no=" + c_no + ", c_name=" + c_name + ", c_photo=" + c_photo + ", c_club=" + c_club
				+ ", c_player=" + c_player + ", c_stadium=" + c_stadium + ", c_year=" + c_year + ", c_born=" + c_born
				+ ", c_map=" + c_map + "]";
	}
	
	
	public int getC_no() {
		return c_no;
	}
	public void setC_no(int c_no) {
		this.c_no = c_no;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public String getC_photo() {
		return c_photo;
	}
	public void setC_photo(String c_photo) {
		this.c_photo = c_photo;
	}
	public String getC_club() {
		return c_club;
	}
	public void setC_club(String c_club) {
		this.c_club = c_club;
	}
	public String getC_player() {
		return c_player;
	}
	public void setC_player(String c_player) {
		this.c_player = c_player;
	}
	public String getC_stadium() {
		return c_stadium;
	}
	public void setC_stadium(String c_stadium) {
		this.c_stadium = c_stadium;
	}
	public String getC_year() {
		return c_year;
	}
	public void setC_year(String c_year) {
		this.c_year = c_year;
	}
	public String getC_born() {
		return c_born;
	}
	public void setC_born(String c_born) {
		this.c_born = c_born;
	}
	public String getC_map() {
		return c_map;
	}
	public void setC_map(String c_map) {
		this.c_map = c_map;
	}

	
	
}
