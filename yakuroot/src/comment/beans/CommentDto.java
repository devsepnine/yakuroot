package comment.beans;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CommentDto {
	private int no;
	private String writer;
	private String content;
	private String when;
	private int origin;
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWhen() {
		return when;
	}
	public void setWhen(String when) {
		this.when = when;
	}
	public int getOrigin() {
		return origin;
	}
	public void setOrigin(int origin) {
		this.origin = origin;
	}
	public void setData(ResultSet rs) throws SQLException{
		this.setNo(rs.getInt("no"));
		this.setWriter(rs.getString("writer"));
		this.setContent(rs.getString("content"));
		this.setWhen(rs.getString("when"));
		this.setOrigin(rs.getInt("origin"));
	}
	public String getDate() {
//		2019-06-18 12:18:07.0
		return when.substring(0,10);
	}
	public String getTime() {
		return when.substring(11,16);
	}
}
