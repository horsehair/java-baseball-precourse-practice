package baseball.service;

import baseball.model.BaseballModel;

public class BaseballService {
	private BaseballModel baseballModel = new BaseballModel();

	public void startGame() {
		this.baseballModel.setTargetNumberList();
	}
}
