package baseball.service;

import java.util.List;

import baseball.model.BaseballModel;

public class BaseballService {
	private BaseballModel baseballModel = new BaseballModel();

	public void startGame() {
		this.baseballModel.setTargetNumberList();
	}

	public Object playGameOneTime(String stringOfNumberFromClient) {
		List<Integer> clientNumberList = this.convertStringToIntegerList(stringOfNumberFromClient);
		Object resultOfGame = this.calculateResultOfGame(clientNumberList);
		return resultOfGame;
	}
}
