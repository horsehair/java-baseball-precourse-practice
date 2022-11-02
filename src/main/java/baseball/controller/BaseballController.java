package baseball.controller;

import baseball.service.BaseballService;
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
		String resultString = this.baseballService.playGameOneTime(stringOfNumberFromClient);
		String newStringOfNumberFromClient = this.baseballView.repeatGame(resultString);
		playGameOneTime(newStringOfNumberFromClient);
	}
}
