package g_board.beans;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class g_boardDto {
	private int g_no;
	private String g_head;
	private String g_title;
	private String g_writer;
	private String g_content;
	private int g_read;
	private String g_when;
	private int g_parent;
	private int g_depth;
	private int g_team;
	
	@Override
	public String toString() {
		return "g_boardDto [g_no=" + g_no + ", g_head=" + g_head + ", g_title=" + g_title + ", g_writer=" + g_writer
				+ ", g_content=" + g_content + ", g_read=" + g_read + ", g_when=" + g_when + ", g_parent=" + g_parent
				+ ", g_depth=" + g_depth + ", g_team=" + g_team + "]";
	}
	public g_boardDto() {
		super();
	}
	public int getG_no() {
		return g_no;
	}
	public void setG_no(int g_no) {
		this.g_no = g_no;
	}
	public String getG_head() {
		return g_head;
	}
	public void setG_head(String g_head) {
		this.g_head = g_head;
	}
	public String getG_title() {
		return g_title;
	}
	public void setG_title(String g_title) {
		this.g_title = g_title;
	}
	public String getG_writer() {
		return g_writer;
	}
	public void setG_writer(String g_writer) {
		this.g_writer = g_writer;
	}
	public String getG_content() {
		return g_content;
	}
	public void setG_content(String g_content) {
		this.g_content = g_content;
	}
	public int getG_read() {
		return g_read;
	}
	public void setG_read(int g_read) {
		this.g_read = g_read;
	}
	public String getG_when() {
		return g_when;
	}
	public void setG_when(String g_when) {
		this.g_when = g_when;
	}
	public int getG_parent() {
		return g_parent;
	}
	public void setG_parent(int g_parent) {
		this.g_parent = g_parent;
	}
	public int getG_depth() {
		return g_depth;
	}
	public void setG_depth(int g_depth) {
		this.g_depth = g_depth;
	}
	public int getG_team() {
		return g_team;
	}
	public void setG_team(int g_team) {
		this.g_team = g_team;
	}
	public void setDate(ResultSet rs) throws SQLException{
		this.setG_no(rs.getInt("g_no"));
		this.setG_head(rs.getString("g_head"));
		this.setG_title(rs.getString("g_title"));
		this.setG_writer(rs.getString("g_writer"));
		this.setG_content(rs.getString("g_content"));
		this.setG_when(rs.getString("g_when"));
		this.setG_read(rs.getInt("g_read"));
		this.setG_parent(rs.getInt("g_parent"));
		this.setG_depth(rs.getInt("g_depth"));
		this.setG_team(rs.getInt("g_team"));
	}
	public String getDate() {
//		2019-06-18 12:18:07.0
		return g_when.substring(0,10);
	}
	public String getTime() {
		return g_when.substring(11,16);
	}
//	시간만 반환하는 메소드 getTime
	public String setWhen(String when) {
		return this.g_when = when;
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
