package notice_board.beans;

import java.net.URLEncoder;
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
	private int f_parent;
	private int f_depth;
	private int f_team;
	private String n_savename;
	private String n_uploadname;
	public n_boardDto() {
		super();
	}
	@Override
	public String toString() {
		return "n_boardDto [n_no=" + n_no + ", n_head=" + n_head + ", n_title=" + n_title + ", n_writer=" + n_writer
				+ ", n_content=" + n_content + ", n_read=" + n_read + ", n_when=" + n_when + ", f_parent=" + f_parent
				+ ", f_depth=" + f_depth + ", f_team=" + f_team + ", n_savename=" + n_savename + ", n_uploadname="
				+ n_uploadname + ", n_len=" + n_len + ", n_type=" + n_type + ", n_count=" + n_count + "]";
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
	public String getN_savename() {
		return n_savename;
	}
	public void setN_savename(String n_savename) {
		this.n_savename = n_savename;
	}
	public String getN_uploadname() {
		return n_uploadname;
	}
	public void setN_uploadname(String n_uploadname) {
		this.n_uploadname = n_uploadname;
	}
	public long getN_len() {
		return n_len;
	}
	public void setN_len(long n_len) {
		this.n_len = n_len;
	}
	public String getN_type() {
		return n_type;
	}
	public void setN_type(String n_type) {
		this.n_type = n_type;
	}
	public int getN_count() {
		return n_count;
	}
	public void setN_count(int n_count) {
		this.n_count = n_count;
	}
	private long n_len;
	private String n_type;
	private int n_count;
	
	public void setDate(ResultSet rs) throws SQLException{
		this.setN_no(rs.getInt("n_no"));
		this.setN_head(rs.getString("n_head"));
		this.setN_title(rs.getString("n_title"));
		this.setN_writer(rs.getString("n_writer"));
		this.setN_content(rs.getString("n_content"));
		this.setN_when(rs.getString("n_when"));
		this.setN_read(rs.getInt("n_read"));
		this.setN_savename(rs.getString("n_savename"));
		this.setN_uploadname(rs.getString("n_uploadname"));
		this.setN_len(rs.getLong("n_len"));
		this.setN_type(rs.getString("n_type"));
	}
	public void setDateA(ResultSet rs) throws SQLException{
		this.setN_no(rs.getInt("n_no"));
		this.setN_head(rs.getString("n_head"));
		this.setN_title(rs.getString("n_title"));
		this.setN_writer(rs.getString("n_writer"));
		this.setN_content(rs.getString("n_content"));
		this.setN_when(rs.getString("n_when"));
		this.setN_read(rs.getInt("n_read"));
		this.setF_parent(rs.getInt("f_parent"));
		this.setF_depth(rs.getInt("f_depth"));
		this.setF_team(rs.getInt("f_team"));
		this.setN_savename(rs.getString("n_savename"));
		this.setN_uploadname(rs.getString("n_uploadname"));
		this.setN_len(rs.getLong("n_len"));
		this.setN_type(rs.getString("n_type"));
		this.setN_count(rs.getInt("n_count"));
		
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
	public String getSendname() throws Exception{
		return URLEncoder.encode(n_uploadname,"UTF-8");
	}

}
