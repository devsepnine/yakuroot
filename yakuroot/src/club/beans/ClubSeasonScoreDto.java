package club.beans;

public class ClubSeasonScoreDto {
	private int c_game;//구단 경기수
	private int c_win;//구단 승
	private int c_loss;//구단 패
	private int c_draw;//구단 무승부
	private double c_victory;//구단 승률
	private String c_last_ten;//구단 최근 10경기 성적
	private String c_contineu;//구단 연속 성적
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
	public String getC_last_ten() {
		return c_last_ten;
	}
	public void setC_last_ten(String c_last_ten) {
		this.c_last_ten = c_last_ten;
	}
	public String getC_contineu() {
		return c_contineu;
	}
	public void setC_contineu(String c_contineu) {
		this.c_contineu = c_contineu;
	}
	@Override
	public String toString() {
		return "ClubSeasonScoreDto [c_game=" + c_game + ", c_win=" + c_win + ", c_loss=" + c_loss + ", c_draw=" + c_draw
				+ ", c_victory=" + c_victory + ", c_last_ten=" + c_last_ten + ", c_contineu=" + c_contineu + "]";
	}
	public ClubSeasonScoreDto() {
		super();
	}
	
}
