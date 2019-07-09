package club.beans;

public class ClubDto {
	private int c_no;//구단 고유 번호
	private String c_name;//구단 이름
	private String c_photo;//구단 로고
	private String c_club;//구단 소개
	private String c_player;//구단 선수 소개
	private String c_stadium;//구단 홈 경기장 소개
	private String c_reseration;//구단 경기 예매
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
	public String getC_reseration() {
		return c_reseration;
	}
	public void setC_reseration(String c_reseration) {
		this.c_reseration = c_reseration;
	}
	@Override
	public String toString() {
		return "ClucDto [c_no=" + c_no + ", c_name=" + c_name + ", c_photo=" + c_photo + ", c_club=" + c_club
				+ ", c_player=" + c_player + ", c_stadium=" + c_stadium + ", c_reseration=" + c_reseration + "]";
	}
	public ClubDto() {
		super();
	}
	
}
