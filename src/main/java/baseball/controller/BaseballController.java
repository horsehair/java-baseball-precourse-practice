package baseball.controller;

import baseball.service.BaseballService;
import baseball.service.Result;
import baseball.view.BaseballView;

public class BaseballController {
	private BaseballService baseballService = new BaseballService();
	private BaseballView baseballView = new BaseballView();

	public void startGame() {
		this.baseballService.startGame();
		this.baseballView.getStringOfNumberFromClient();
	}

	public void playGameOneTime(String stringOfNumberFromClient) {
		this.baseballService.playGameOneTime(stringOfNumberFromClient);
	}
}
