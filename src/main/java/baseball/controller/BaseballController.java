package baseball.controller;

import baseball.service.BaseballService;
import baseball.view.BaseballView;

public class BaseballController {
	private BaseballService baseballService = new BaseballService();
	private BaseballView baseballView = new BaseballView();

	void startGame() {
		this.baseballService.startGame();
		this.baseballView.startGame();
	}
}
