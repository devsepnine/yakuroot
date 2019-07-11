package match.beans;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MatchupDto {
	private int match_no;
	private String m_date;
	private String m_team1;
	private String m_team2;
	private int m_point1;
	private int m_point2;
	private String m_stadium;
	public int getMatch_no() {
		return match_no;
	}
	public void setMatch_no(int match_no) {
		this.match_no = match_no;
	}
	public String getM_date() {
		return m_date;
	}
	public void setM_date(String m_date) {
		this.m_date = m_date;
	}
	public String getM_team1() {
		return m_team1;
	}
	public void setM_team1(String m_team1) {
		this.m_team1 = m_team1;
	}
	public String getM_team2() {
		return m_team2;
	}
	public void setM_team2(String m_team2) {
		this.m_team2 = m_team2;
	}
	public int getM_point1() {
		return m_point1;
	}
	public void setM_point1(int m_point1) {
		this.m_point1 = m_point1;
	}
	public int getM_point2() {
		return m_point2;
	}
	public void setM_point2(int m_point2) {
		this.m_point2 = m_point2;
	}
	public String getM_stadium() {
		return m_stadium;
	}
	public void setM_stadium(String m_stadium) {
		this.m_stadium = m_stadium;
	}
	@Override
	public String toString() {
		return "MatchupDto [match_no=" + match_no + ", m_date=" + m_date + ", m_team1=" + m_team1 + ", m_team2="
				+ m_team2 + ", m_point1=" + m_point1 + ", m_point2=" + m_point2 + ", m_stadium=" + m_stadium + "]";
	}
	public MatchupDto() {
		super();
	}
	
	public MatchupDto(ResultSet rs) throws SQLException {
		this.setMatch_no(rs.getInt("match_no"));
		this.setM_date(rs.getString("m_date"));
		this.setM_team1(rs.getString("m_team1"));
		this.setM_team2(rs.getString("m_team2"));
		this.setM_point1(rs.getInt("m_point1"));
		this.setM_point2(rs.getInt("m_point2"));
		this.setM_stadium(rs.getString("m_stadium"));
	}
}
