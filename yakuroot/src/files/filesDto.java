package files;

import java.net.URLEncoder;
import java.sql.ResultSet;
import java.sql.SQLException;

public class filesDto {
	private String savename;
	private String uploadname;
	private long len;
	private String type;
	

	
	@Override
	public String toString() {
		return "filesDto [savename=" + savename + ", uploadname=" + uploadname + ", len=" + len + ", type=" + type
				+ "]";
	}
	public filesDto() {
		super();

	}
	public String getSavename() {
		return savename;
	}
	public void setSavename(String savename) {
		this.savename = savename;
	}
	public String getUploadname() {
		return uploadname;
	}
	public String getSendname() throws Exception{
		return URLEncoder.encode(uploadname,"UTF-8");
	}
	public void setUploadname(String uploadname) {
		this.uploadname = uploadname;
	}
	public long getLen() {
		return len;
	}
	public void setLen(long len) {
		this.len = len;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setDate(ResultSet rs) throws SQLException{
		this.setSavename(rs.getString("savename"));
		this.setUploadname(rs.getString("uploadname"));
		this.setLen(rs.getLong("len"));
		this.setType(rs.getString("type"));

	}
}
