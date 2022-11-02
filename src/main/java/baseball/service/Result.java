package baseball.service;

public class Result {
	private int balls;
	private int strikes;

	void setResult(int balls, int strikes) {
		this.balls = balls;
		this.strikes = strikes;
	}

	public int getBalls() {
		return this.balls;
	}

	public int getStrikes() {
		return this.strikes;
	}

	void addBalls() {
		this.balls += 1;
	}

	void addStrikes() {
		this.strikes += 1;
	}

	public String getResultString() {
		int balls = this.balls;
		int strikes = this.strikes;
		String resultString;

		if (strikes == 3) {
			resultString = "3개의 숫자를 모두 맞히셨습니다!";
			return resultString;
		}

		if (balls == 0 && strikes == 0) {
			resultString = "낫싱";
			return resultString;
		}
		if (balls == 0) {
			resultString = String.format("%d스트라이크", strikes);
			return resultString;
		}
		if (strikes == 0) {
			resultString = String.format("%d볼", balls);
			return resultString;
		}
		resultString = String.format("%d볼 %d스트라이크", balls, strikes);
		return resultString;
	}

	boolean checkIsGameOver() {
		if (this.strikes == 3) {
			return true;
		}
		return false;
	}
}
