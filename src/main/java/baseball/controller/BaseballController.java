package baseball.controller;

import baseball.service.BaseballService;
import baseball.service.Result;
import baseball.view.BaseballView;

public class BaseballController {
	private BaseballService baseballService = new BaseballService();
	private BaseballView baseballView = new BaseballView();

	public void startGame() {
		this.baseballService.startGame();
		String stringOfNumberFromClient = this.baseballView.getStringOfNumberFromClient();
		this.playGameOneTime(stringOfNumberFromClient);
	}

	public void playGameOneTime(String stringOfNumberFromClient) {
		if (stringOfNumberFromClient.equals("종료")) {
			return;
		}
		Result result = this.baseballService.playGameOneTime(stringOfNumberFromClient);
		boolean isGameOver = this.baseballService.checkIsGameOver(result);
		if (isGameOver) {
			this.checkRestartGame();
			return;
		}
		String resultString = this.baseballService.getResultString(result);
		String newStringOfNumberFromClient = this.baseballView.repeatGame(resultString);
		playGameOneTime(newStringOfNumberFromClient);
	}

	void checkRestartGame() {
		String oneForRestartGameOrTwo = this.baseballView.checkRestartGame();
		if (oneForRestartGameOrTwo.equals("1")) {
			this.startGame();
		}
	}
}
