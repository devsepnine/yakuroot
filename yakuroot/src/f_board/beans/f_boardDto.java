package f_board.beans;

import java.net.URLEncoder;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class f_boardDto {
	@Override
	public String toString() {
		return "f_boardDto [f_no=" + f_no + ", f_head=" + f_head + ", f_title=" + f_title + ", f_writer=" + f_writer
				+ ", f_content=" + f_content + ", f_read=" + f_read + ", f_when=" + f_when + ", f_parent=" + f_parent
				+ ", f_depth=" + f_depth + ", f_team=" + f_team + ", f_savename=" + f_savename + ", f_uploadname="
				+ f_uploadname + ", f_len=" + f_len + ", f_type=" + f_type + "]";
	}
	private int f_no;
	private String f_head; 
	private String f_title;
	private String f_writer;
	private String f_content;
	private int f_read;
	private String f_when;
	private int f_parent;
	private int f_depth;
	private int f_team;
	private String f_savename;
	private String f_uploadname;
	private long f_len;
	private String f_type;

	public String getF_savename() {
		return f_savename;
	}
	public void setF_savename(String f_savename) {
		this.f_savename = f_savename;
	}
	public String getF_uploadname() {
		return f_uploadname;
	}
	public void setF_uploadname(String f_uploadname) {
		this.f_uploadname = f_uploadname;
	}
	public long getF_len() {
		return f_len;
	}
	public void setF_len(long f_len) {
		this.f_len = f_len;
	}
	public String getF_type() {
		return f_type;
	}
	public void setF_type(String f_type) {
		this.f_type = f_type;
	}
	public f_boardDto() {
		super();
	}
	public int getF_no() {
		return f_no;
	}
	public void setF_no(int f_no) {
		this.f_no = f_no;
	}
	public String getF_head() {
		return f_head;
	}
	public void setF_head(String f_head) {
		this.f_head = f_head;
	}
	public String getF_title() {
		return f_title;
	}
	public void setF_title(String f_title) {
		this.f_title = f_title;
	}
	public String getF_writer() {
		return f_writer;
	}
	public void setF_writer(String f_writer) {
		this.f_writer = f_writer;
	}
	public String getF_content() {
		return f_content;
	}
	public void setF_content(String f_content) {
		this.f_content = f_content;
	}
	public int getF_read() {
		return f_read;
	}
	public void setF_read(int f_read) {
		this.f_read = f_read;
	}
	public String getF_when() {
		return f_when;
	}
	public void setF_when(String f_when) {
		this.f_when = f_when;
	}
	public int getF_parent() {
		return f_parent;
	}
	public void setF_parent(int f_parent) {
		this.f_parent = f_parent;
	}
	public int getF_depth() {
		return f_depth;
	}
	public void setF_depth(int f_depth) {
		this.f_depth = f_depth;
	}
	public int getF_team() {
		return f_team;
	}
	public void setF_team(int f_team) {
		this.f_team = f_team;
	}

	public void setDate(ResultSet rs) throws SQLException{
		this.setF_no(rs.getInt("f_no"));
		this.setF_head(rs.getString("f_head"));
		this.setF_title(rs.getString("f_title"));
		this.setF_writer(rs.getString("f_writer"));
		this.setF_content(rs.getString("f_content"));
		this.setF_when(rs.getString("f_when"));
		this.setF_read(rs.getInt("f_read"));
		this.setF_parent(rs.getInt("f_parent"));
		this.setF_depth(rs.getInt("f_depth"));
		this.setF_team(rs.getInt("f_team"));
		this.setF_savename(rs.getString("f_savename"));
		this.setF_uploadname(rs.getString("f_uploadname"));
		this.setF_len(rs.getLong("f_len"));
		this.setF_type(rs.getString("f_type"));
	}
	
	public String getDate() {
//		2019-06-18 12:18:07.0
		return f_when.substring(0,10);
	}
	public String getTime() {
		return f_when.substring(11,16);
	}
//	시간만 반환하는 메소드 getTime
	public String setWhen(String when) {
		return this.f_when = when;
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
