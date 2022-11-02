package baseball.controller;

import baseball.service.BaseballService;

public class BaseballController {
	private BaseballService baseballService = new BaseballService();

	void startGame() {
		this.baseballService.startGame();
	}
}
