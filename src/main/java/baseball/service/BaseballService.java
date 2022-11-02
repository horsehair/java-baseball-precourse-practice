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

	public Result playGameOneTime(String stringOfNumberFromClient) {
		List<Integer> clientNumberList = this.convertStringToIntegerList(stringOfNumberFromClient);
		Result resultOfGame = this.calculateResultOfGame(clientNumberList);
		return resultOfGame;
	}

	List<Integer> convertStringToIntegerList(String stringOfNumber) {
		List<Integer> integerList = Arrays.stream(stringOfNumber.split(""))
			.map(Integer::new)
			.collect(Collectors.toList());
		return integerList;
	}

	Result calculateResultOfGame(List<Integer> clientNumberList) {
		Result result = new Result();
		for (int indexOfClientNumberList = 0; indexOfClientNumberList < 3; indexOfClientNumberList++) {
			int numberToCompare = clientNumberList.get(indexOfClientNumberList);
			this.addResultOfCompareOneDigitWithTargetToResult(numberToCompare, indexOfClientNumberList, result);
		}
		return result;
	}

	void addResultOfCompareOneDigitWithTargetToResult(int numberToCompare, int indexOfClientNumberList, Result result) {
		boolean isStrike = checkIsStrike(numberToCompare, indexOfClientNumberList);
		if (isStrike) {
			result.addStrikes();
			return;
		}
		boolean isNumberInTargetList = checkNumberInTargetList(numberToCompare);
		if (isNumberInTargetList) {
			result.addBalls();
		}
		return;
	}

	boolean checkIsStrike(int numberToCompare, int indexOfClientNumberList) {
		List<Integer> targetNumberList = this.baseballModel.getTargetNumberList();
		int targetNumberToCompare = targetNumberList.get(indexOfClientNumberList);
		if (numberToCompare == targetNumberToCompare) {
			return true;
		}
		return false;
	}

	boolean checkNumberInTargetList(int numberToCompare) {
		List<Integer> targetNumberList = this.baseballModel.getTargetNumberList();
		boolean isNumberInTargetList = targetNumberList.contains(numberToCompare);
		if (isNumberInTargetList) {
			return true;
		}
		return false;
	}

	public boolean checkIsGameOver(Result result) {
		return result.checkIsGameOver();
	}

	public String getResultString(Result result) {
		return result.getResultString();
	}


}
