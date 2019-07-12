package q_board.beans;

import java.net.URLEncoder;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class q_boardDto {
	private int q_no;
	private String q_head;
	private String q_title;
	private String q_writer;
	private String q_content;
	private int q_read;
	private String q_when;
	private int q_parent;
	private int q_depth;
	private int q_team;
	private String q_savename;
	private String q_uploadname;
	private long q_len;
	private String q_type;
	@Override
	public String toString() {
		return "q_boardDto [q_no=" + q_no + ", q_head=" + q_head + ", q_title=" + q_title + ", q_writer=" + q_writer
				+ ", q_content=" + q_content + ", q_read=" + q_read + ", q_when=" + q_when + ", q_parent=" + q_parent
				+ ", q_depth=" + q_depth + ", q_team=" + q_team + ", q_savename=" + q_savename + ", q_uploadname="
				+ q_uploadname + ", q_len=" + q_len + ", q_type=" + q_type + "]";
	}
	public q_boardDto() {
		super();
	}
	public int getQ_no() {
		return q_no;
	}
	public void setQ_no(int q_no) {
		this.q_no = q_no;
	}
	public String getQ_head() {
		return q_head;
	}
	public void setQ_head(String q_head) {
		this.q_head = q_head;
	}
	public String getQ_title() {
		return q_title;
	}
	public void setQ_title(String q_title) {
		this.q_title = q_title;
	}
	public String getQ_writer() {
		return q_writer;
	}
	public void setQ_writer(String q_writer) {
		this.q_writer = q_writer;
	}
	public String getQ_content() {
		return q_content;
	}
	public void setQ_content(String q_content) {
		this.q_content = q_content;
	}
	public int getQ_read() {
		return q_read;
	}
	public void setQ_read(int q_read) {
		this.q_read = q_read;
	}
	public String getQ_when() {
		return q_when;
	}
	public void setQ_when(String q_when) {
		this.q_when = q_when;
	}
	public int getQ_parent() {
		return q_parent;
	}
	public void setQ_parent(int q_parent) {
		this.q_parent = q_parent;
	}
	public int getQ_depth() {
		return q_depth;
	}
	public void setQ_depth(int q_depth) {
		this.q_depth = q_depth;
	}
	public int getQ_team() {
		return q_team;
	}
	public void setQ_team(int q_team) {
		this.q_team = q_team;
	}
	public String getQ_savename() {
		return q_savename;
	}
	public void setQ_savename(String q_savename) {
		this.q_savename = q_savename;
	}
	public String getQ_uploadname() {
		return q_uploadname;
	}
	public void setQ_uploadname(String q_uploadname) {
		this.q_uploadname = q_uploadname;
	}
	public long getQ_len() {
		return q_len;
	}
	public void setQ_len(long q_len) {
		this.q_len = q_len;
	}
	public String getQ_type() {
		return q_type;
	}
	public void setQ_type(String q_type) {
		this.q_type = q_type;
	}
	public void setDate(ResultSet rs) throws SQLException{
		this.setQ_no(rs.getInt("q_no"));
		this.setQ_head(rs.getString("q_head"));
		this.setQ_title(rs.getString("q_title"));
		this.setQ_writer(rs.getString("q_writer"));
		this.setQ_content(rs.getString("q_content"));
		this.setQ_when(rs.getString("q_when"));
		this.setQ_read(rs.getInt("q_read"));
		this.setQ_parent(rs.getInt("q_parent"));
		this.setQ_depth(rs.getInt("q_depth"));
		this.setQ_team(rs.getInt("q_team"));
		this.setQ_savename(rs.getString("q_savename"));
		this.setQ_uploadname(rs.getString("q_uploadname"));
		this.setQ_len(rs.getLong("q_len"));
		this.setQ_type(rs.getString("q_type"));
	}
	public String getSendname() throws Exception{
		return URLEncoder.encode(q_uploadname,"UTF-8");
	}
	public String getDate() {
//		2019-06-18 12:18:07.0
		return q_when.substring(0,10);
	}
	public String getTime() {
		return q_when.substring(11,16);
	}
//	시간만 반환하는 메소드 getTime
	public String setWhen(String when) {
		return this.q_when = when;
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
