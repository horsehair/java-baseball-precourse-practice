package baseball.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

	List<Integer> convertStringToIntegerList(String stringOfNumber) {
		List<Integer> integerList = Arrays.stream(stringOfNumber.split(""))
			.map(Integer::new)
			.collect(Collectors.toList());
		return integerList;
	}
}
