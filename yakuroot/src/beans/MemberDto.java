package beans;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDto {
	private int m_no;
	private String m_id;
	private String m_pw;
	private String m_name;
	private String m_birth;
	private String m_phone;
	private String m_email;
	private String m_postcode;
	private String m_addr1;
	private String m_addr2;
	private String m_fav;
	private String m_resdata;
	private String m_auth;
	private String m_regist;
	private String m_lasttime;
	
	


	

	@Override
	public String toString() {
		return "MemberDto [m_no=" + m_no + ", m_id=" + m_id + ", m_pw=" + m_pw + ", m_name=" + m_name + ", m_birth="
				+ m_birth + ", m_phone=" + m_phone + ", m_email=" + m_email + ", m_postcode=" + m_postcode
				+ ", m_addr1=" + m_addr1 + ", m_addr2=" + m_addr2 + ", m_fav=" + m_fav + ", m_resdata=" + m_resdata
				+ ", m_auth=" + m_auth + ", m_regist=" + m_regist + ", m_lasttime=" + m_lasttime + "]";
	}






	public MemberDto() {
		super();
	}






	public MemberDto(ResultSet rs) throws SQLException{
		this.setM_no(rs.getInt("m_no"));
		this.setM_id(rs.getString("m_id"));                                  
		this.setM_name(rs.getString("m_name"));
		this.setM_birth(rs.getString("m_birth"));
		this.setM_phone(rs.getString("m_phone"));
		this.setM_email(rs.getString("m_email"));
		this.setM_postcode(rs.getString("m_postcode"));
		this.setM_addr1(rs.getString("m_addr1"));
		this.setM_addr2(rs.getString("m_addr2"));
		this.setM_fav(rs.getString("m_fav"));
		this.setM_resdata(rs.getString("m_resdata"));
		this.setM_auth(rs.getString("m_auth"));
		this.setM_regist(rs.getString("m_regist"));
		this.setM_lasttime(rs.getString("m_lasttime"));
	}






	public int getM_no() {
		return m_no;
	}






	public void setM_no(int m_no) {
		this.m_no = m_no;
	}






	public String getM_id() {
		return m_id;
	}






	public void setM_id(String m_id) {
		this.m_id = m_id;
	}






	public String getM_pw() {
		return m_pw;
	}






	public void setM_pw(String m_pw) {
		this.m_pw = m_pw;
	}






	public String getM_name() {
		return m_name;
	}






	public void setM_name(String m_name) {
		this.m_name = m_name;
	}






	public String getM_birth() {
		return m_birth;
	}






	public void setM_birth(String m_birth) {
		this.m_birth = m_birth;
	}






	public String getM_phone() {
		return m_phone;
	}






	public void setM_phone(String m_phone) {
		this.m_phone = m_phone;
	}






	public String getM_email() {
		return m_email;
	}






	public void setM_email(String m_email) {
		this.m_email = m_email;
	}






	public String getM_postcode() {
		return m_postcode;
	}






	public void setM_postcode(String m_postcode) {
		this.m_postcode = m_postcode;
	}






	public String getM_addr1() {
		return m_addr1;
	}






	public void setM_addr1(String m_addr1) {
		this.m_addr1 = m_addr1;
	}






	public String getM_addr2() {
		return m_addr2;
	}






	public void setM_addr2(String m_addr2) {
		this.m_addr2 = m_addr2;
	}






	public String getM_fav() {
		return m_fav;
	}






	public void setM_fav(String m_fav) {
		this.m_fav = m_fav;
	}






	public String getM_resdata() {
		return m_resdata;
	}






	public void setM_resdata(String m_resdata) {
		this.m_resdata = m_resdata;
	}






	public String getM_auth() {
		return m_auth;
	}






	public void setM_auth(String m_auth) {
		this.m_auth = m_auth;
	}






	public String getM_regist() {
		return m_regist;
	}






	public void setM_regist(String m_regist) {
		this.m_regist = m_regist;
	}






	public String getM_lasttime() {
		return m_lasttime;
	}






	public void setM_lasttime(String m_lasttime) {
		this.m_lasttime = m_lasttime;
	}



	

}
