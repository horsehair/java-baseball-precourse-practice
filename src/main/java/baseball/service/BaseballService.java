package baseball.service;

import baseball.model.BaseballModel;

public class BaseballService {
	private BaseballModel baseballModel = new BaseballModel();

	void startGame() {
		this.baseballModel.setTargetNumber();
	}
}
