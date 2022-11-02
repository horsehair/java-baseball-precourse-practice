package baseball.service;

public class Result {
	private int balls;
	private int strikes;

	void setResult(int balls, int strikes) {
		this.balls = balls;
		this.strikes = strikes;
	}

	int getBalls() {
		return this.balls;
	}

	int getStrikes() {
		return this.strikes;
	}

	void addBalls() {
		this.balls += 1;
	}

	void addStrikes() {
		this.strikes += 1;
	}
}
