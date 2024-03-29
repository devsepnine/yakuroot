package club.beans;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClubSeasonScoreDto {
	private int c_game;//구단 경기수
	private int c_win;//구단 승
	private int c_loss;//구단 패
	private int c_draw;//구단 무승부
	private double c_victory;//구단 승률
	private double c_gap;//구단 게임차
	private String c_last_ten;//구단 최근 10경기 성적
	private String c_continue;//구단 연속 성적
	
	public void setData(ResultSet rs) throws SQLException {
		this.setC_game(rs.getInt("c_game"));
		this.setC_win(rs.getInt("c_win"));
		this.setC_loss(rs.getInt("c_loss"));
		this.setC_draw(rs.getInt("c_draw"));
		this.setC_victory(rs.getDouble("c_victory"));
		this.setC_gap(rs.getDouble("c_gap"));
		this.setC_last_ten(rs.getString("c_last_ten"));
		this.setC_continue(rs.getString("c_continue"));
	}
	
	public ClubSeasonScoreDto() {
		super();
	}
	@Override
	public String toString() {
		return "ClubSeasonScoreDto [c_game=" + c_game + ", c_win=" + c_win + ", c_loss=" + c_loss + ", c_draw=" + c_draw
				+ ", c_victory=" + c_victory + ", c_gap=" + c_gap + ", c_last_ten=" + c_last_ten + ", c_continue="
				+ c_continue + "]";
	}
	public int getC_game() {
		return c_game;
	}
	public void setC_game(int c_game) {
		this.c_game = c_game;
	}
	public int getC_win() {
		return c_win;
	}
	public void setC_win(int c_win) {
		this.c_win = c_win;
	}
	public int getC_loss() {
		return c_loss;
	}
	public void setC_loss(int c_loss) {
		this.c_loss = c_loss;
	}
	public int getC_draw() {
		return c_draw;
	}
	public void setC_draw(int c_draw) {
		this.c_draw = c_draw;
	}
	public double getC_victory() {
		return c_victory;
	}
	public void setC_victory(double c_victory) {
		this.c_victory = c_victory;
	}
	public double getC_gap() {
		return c_gap;
	}
	public void setC_gap(double c_gap) {
		this.c_gap = c_gap;
	}
	public String getC_last_ten() {
		return c_last_ten;
	}
	public void setC_last_ten(String c_last_ten) {
		this.c_last_ten = c_last_ten;
	}
	public String getC_continue() {
		return c_continue;
	}
	public void setC_continue(String c_continue) {
		this.c_continue = c_continue;
	}
	
	
	
	
	
}
