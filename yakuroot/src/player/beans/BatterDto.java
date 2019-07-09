package player.beans;

public class BatterDto {
	private int p_bat;//타자 타수
	private int p_hit;//타자 안타
	private int p_homerun;//타자 홈런
	private int p_score;//타자 득점
	private int p_stolen_base;//타자 도루
	private int p_fail_stolen_base;//타자 도루 실패
	private int p_strike_out;//타자 삼진
	private int p_dead_ball;//선수 사사구
	private double p_on_base;//타자 출루율
	private double p_long_bat;//타자 장타율
	private double p_ops;//타자 OPS
	private double p_score_bat;//타자 득점권 타율
	public int getP_bat() {
		return p_bat;
	}
	public void setP_bat(int p_bat) {
		this.p_bat = p_bat;
	}
	public int getP_hit() {
		return p_hit;
	}
	public void setP_hit(int p_hit) {
		this.p_hit = p_hit;
	}
	public int getP_homerun() {
		return p_homerun;
	}
	public void setP_homerun(int p_homerun) {
		this.p_homerun = p_homerun;
	}
	public int getP_score() {
		return p_score;
	}
	public void setP_score(int p_score) {
		this.p_score = p_score;
	}
	public int getP_stolen_base() {
		return p_stolen_base;
	}
	public void setP_stolen_base(int p_stolen_base) {
		this.p_stolen_base = p_stolen_base;
	}
	public int getP_fail_stolen_base() {
		return p_fail_stolen_base;
	}
	public void setP_fail_stolen_base(int p_fail_stolen_base) {
		this.p_fail_stolen_base = p_fail_stolen_base;
	}
	public int getP_strike_out() {
		return p_strike_out;
	}
	public void setP_strike_out(int p_strike_out) {
		this.p_strike_out = p_strike_out;
	}
	public int getP_dead_ball() {
		return p_dead_ball;
	}
	public void setP_dead_ball(int p_dead_ball) {
		this.p_dead_ball = p_dead_ball;
	}
	public double getP_on_base() {
		return p_on_base;
	}
	public void setP_on_base(double p_on_base) {
		this.p_on_base = p_on_base;
	}
	public double getP_long_bat() {
		return p_long_bat;
	}
	public void setP_long_bat(double p_long_bat) {
		this.p_long_bat = p_long_bat;
	}
	public double getP_ops() {
		return p_ops;
	}
	public void setP_ops(double p_ops) {
		this.p_ops = p_ops;
	}
	public double getP_score_bat() {
		return p_score_bat;
	}
	public void setP_score_bat(double p_score_bat) {
		this.p_score_bat = p_score_bat;
	}
	@Override
	public String toString() {
		return "BatterDto [p_bat=" + p_bat + ", p_hit=" + p_hit + ", p_homerun=" + p_homerun + ", p_score=" + p_score
				+ ", p_stolen_base=" + p_stolen_base + ", p_fail_stolen_base=" + p_fail_stolen_base + ", p_strike_out="
				+ p_strike_out + ", p_dead_ball=" + p_dead_ball + ", p_on_base=" + p_on_base + ", p_long_bat="
				+ p_long_bat + ", p_ops=" + p_ops + ", p_score_bat=" + p_score_bat + "]";
	}
	public BatterDto() {
		super();
	}
	
}
