package player.beans;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PitcherDto {
	private double p_era;//투수 ERA
	private int p_standing;//투수 선발 경기
	private int p_shutouts;//투수 완투
	private int p_win;//투수 승
	private int p_loss;//투수 패
	private int p_save;//투수 세이브
	private int p_hold;//투수 홀드
	private double p_victory;//투수 승률
	private String p_inning;//투수 이닝
	private double p_hit_rate;//피안타율
	private int p_loss_point;//실점
	private int p_self_defense;//투수 자책점
	private double p_wip;//투수 WIP
	
	
	public void setData(ResultSet rs) throws SQLException {
		this.setP_era(rs.getDouble("p_era"));
		this.setP_standing(rs.getInt("p_standing"));
		this.setP_shutouts(rs.getInt("p_shutouts"));
		this.setP_win(rs.getInt("p_win"));
		this.setP_loss(rs.getInt("p_loss"));
		this.setP_save(rs.getInt("p_save"));
		this.setP_hold(rs.getInt("p_hold"));
		this.setP_victory(rs.getDouble("p_victory"));
		this.setP_inning(rs.getString("p_inning"));
		this.setP_hit_rate(rs.getDouble("p_hit_rate"));
		this.setP_loss(rs.getInt("p_loss_point"));
		this.setP_self_defense(rs.getInt("p_self_defense"));
		this.setP_wip(rs.getDouble("p_wip"));
	}
	
	
	public PitcherDto() {
		super();
	}
	
	
	@Override
	public String toString() {
		return "PitcherDto [p_era=" + p_era + ", p_standing=" + p_standing + ", p_shutouts=" + p_shutouts + ", p_win="
				+ p_win + ", p_loss=" + p_loss + ", p_save=" + p_save + ", p_hold=" + p_hold + ", p_victory="
				+ p_victory + ", p_inning=" + p_inning + ", p_hit_rate=" + p_hit_rate + ", p_loss_point=" + p_loss_point
				+ ", p_self_defense=" + p_self_defense + ", p_wip=" + p_wip + "]";
	}
	
	
	public double getP_era() {
		return p_era;
	}
	public void setP_era(double p_era) {
		this.p_era = p_era;
	}
	public int getP_standing() {
		return p_standing;
	}
	public void setP_standing(int p_standing) {
		this.p_standing = p_standing;
	}
	public int getP_shutouts() {
		return p_shutouts;
	}
	public void setP_shutouts(int p_shutouts) {
		this.p_shutouts = p_shutouts;
	}
	public int getP_win() {
		return p_win;
	}
	public void setP_win(int p_win) {
		this.p_win = p_win;
	}
	public int getP_loss() {
		return p_loss;
	}
	public void setP_loss(int p_loss) {
		this.p_loss = p_loss;
	}
	public int getP_save() {
		return p_save;
	}
	public void setP_save(int p_save) {
		this.p_save = p_save;
	}
	public int getP_hold() {
		return p_hold;
	}
	public void setP_hold(int p_hold) {
		this.p_hold = p_hold;
	}
	public double getP_victory() {
		return p_victory;
	}
	public void setP_victory(double p_victory) {
		this.p_victory = p_victory;
	}
	public String getP_inning() {
		return p_inning;
	}
	public void setP_inning(String p_inning) {
		this.p_inning = p_inning;
	}
	public double getP_hit_rate() {
		return p_hit_rate;
	}
	public void setP_hit_rate(double p_hit_rate) {
		this.p_hit_rate = p_hit_rate;
	}
	public int getP_loss_point() {
		return p_loss_point;
	}
	public void setP_loss_point(int p_loss_point) {
		this.p_loss_point = p_loss_point;
	}
	public int getP_self_defense() {
		return p_self_defense;
	}
	public void setP_self_defense(int p_self_defense) {
		this.p_self_defense = p_self_defense;
	}
	public double getP_wip() {
		return p_wip;
	}
	public void setP_wip(double p_wip) {
		this.p_wip = p_wip;
	}
	
	
}
