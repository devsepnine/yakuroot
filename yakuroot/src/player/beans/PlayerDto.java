package player.beans;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PlayerDto {
	private int p_no;//선수 고유 번호
	private String p_club;//선수 소속 구단 로고
	private String p_photo;//선수 프로필 사진
	private String p_name;//선수 이름
	private int p_bnum;//선수 등번호
	private String p_birth;//선수 생일
	private int p_height;//선수 키
	private int p_weight;//선수 몸무게
	private String p_position;//선수 포지션
	
	public void setData(ResultSet rs) throws SQLException {
		this.setP_no(rs.getInt("p_no"));
		this.setP_club(rs.getString("p_club"));
		this.setP_photo(rs.getString("p_photo"));
		this.setP_name(rs.getString("p_name"));
		this.setP_bnum(rs.getInt("p_bnum"));
		this.setP_birth(rs.getString("p_birth"));
		this.setP_height(rs.getInt("p_height"));
		this.setP_weight(rs.getInt("p_weight"));
		this.setP_position(rs.getString("p_position"));
	}
	
	public PlayerDto() {
		super();
	}
	@Override
	public String toString() {
		return "PlayerDto [p_no=" + p_no + ", p_club=" + p_club + ", p_photo=" + p_photo + ", p_name=" + p_name
				+ ", p_bnum=" + p_bnum + ", p_birth=" + p_birth + ", p_height=" + p_height + ", p_weight=" + p_weight
				+ ", p_position=" + p_position + "]";
	}
	public int getP_no() {
		return p_no;
	}
	public void setP_no(int p_no) {
		this.p_no = p_no;
	}
	public String getP_club() {
		return p_club;
	}
	public void setP_club(String p_club) {
		this.p_club = p_club;
	}
	public String getP_photo() {
		return p_photo;
	}
	public void setP_photo(String p_photo) {
		this.p_photo = p_photo;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public int getP_bnum() {
		return p_bnum;
	}
	public void setP_bnum(int p_bnum) {
		this.p_bnum = p_bnum;
	}
	public String getP_birth() {
		return p_birth;
	}
	public void setP_birth(String p_birth) {
		this.p_birth = p_birth;
	}
	public int getP_height() {
		return p_height;
	}
	public void setP_height(int p_height) {
		this.p_height = p_height;
	}
	public int getP_weight() {
		return p_weight;
	}
	public void setP_weight(int p_weight) {
		this.p_weight = p_weight;
	}
	public String getP_position() {
		return p_position;
	}
	public void setP_position(String p_position) {
		this.p_position = p_position;
	}
	
		
}
