package notice_board.beans;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class n_boardDto {
	private int n_no;
	private String n_head;
	private String n_title;
	private String n_writer;
	private String n_content;
	private int n_read;
	private String n_when;
	private int n_parent;
	private int n_depth;
	public n_boardDto(int n_no, String n_head, String n_title, String n_writer, String n_content, int n_read,
			String n_when, int n_parent, int n_depth, int n_team) {
		super();
		this.n_no = n_no;
		this.n_head = n_head;
		this.n_title = n_title;
		this.n_writer = n_writer;
		this.n_content = n_content;
		this.n_read = n_read;
		this.n_when = n_when;
		this.n_parent = n_parent;
		this.n_depth = n_depth;
		this.n_team = n_team;
	}
	public int getN_parent() {
		return n_parent;
	}
	public void setN_parent(int n_parent) {
		this.n_parent = n_parent;
	}
	public int getN_depth() {
		return n_depth;
	}
	public void setN_depth(int n_depth) {
		this.n_depth = n_depth;
	}
	public int getN_team() {
		return n_team;
	}
	public void setN_team(int n_team) {
		this.n_team = n_team;
	}
	private int n_team;
	
	public n_boardDto() {
		super();
	}
	
	@Override
	public String toString() {
		return "n_boardDto [n_no=" + n_no + ", n_head=" + n_head + ", n_title=" + n_title + ", n_writer=" + n_writer
				+ ", n_content=" + n_content + ", n_read=" + n_read + ", n_when=" + n_when + "]";
	}
	public int getN_no() {
		return n_no;
	}
	public void setN_no(int n_no) {
		this.n_no = n_no;
	}
	public String getN_head() {
		return n_head;
	}
	public void setN_head(String n_head) {
		this.n_head = n_head;
	}
	public String getN_title() {
		return n_title;
	}
	public void setN_title(String n_title) {
		this.n_title = n_title;
	}
	public String getN_writer() {
		return n_writer;
	}
	public void setN_writer(String n_writer) {
		this.n_writer = n_writer;
	}
	public String getN_content() {
		return n_content;
	}
	public void setN_content(String n_content) {
		this.n_content = n_content;
	}
	public int getN_read() {
		return n_read;
	}
	public void setN_read(int n_read) {
		this.n_read = n_read;
	}
	public String getN_when() {
		return n_when;
	}
	public void setN_when(String n_when) {
		this.n_when = n_when;
	}
	public void setDate(ResultSet rs) throws SQLException{
		this.setN_no(rs.getInt("n_no"));
		this.setN_head(rs.getString("n_head"));
		this.setN_title(rs.getString("n_title"));
		this.setN_writer(rs.getString("n_writer"));
		this.setN_content(rs.getString("n_content"));
		this.setN_when(rs.getString("n_when"));
		this.setN_read(rs.getInt("n_read"));
	}
	public String getDate() {
//		2019-06-18 12:18:07.0
		return n_when.substring(0,10);
	}
	public String getTime() {
		return n_when.substring(11,16);
	}
//	시간만 반환하는 메소드 getTime
	public String setWhen(String when) {
		return this.n_when = when;
	}
//	오늘인지 아닌지 판정하여 자동 시간 반환
	public String getAuto() {
		Date d = new Date();
		Format f = new SimpleDateFormat("yyyy-MM-dd");
		if(getDate().equals(f.format(d))) {
			return this.getTime();
		}else {
			return this.getDate();
		}
}

}
