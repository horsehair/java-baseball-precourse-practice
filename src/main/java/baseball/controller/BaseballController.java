package baseball.controller;

import baseball.service.BaseballService;
import baseball.service.Result;
import baseball.view.BaseballView;

public class BaseballController {
	private BaseballService baseballService = new BaseballService();
	private BaseballView baseballView = new BaseballView();

	public BaseballController() {
		System.out.println("숫자 야구 게임을 시작합니다.");
	}

	public void startGame() {
		this.baseballService.startGame();
		String stringOfNumberFromClient = this.baseballView.getStringOfNumberFromClient();
		this.playGameOneTime(stringOfNumberFromClient);
	}

	public void playGameOneTime(String stringOfNumberFromClient) throws IllegalArgumentException {
		this.validateInput(stringOfNumberFromClient);
		Result result = this.baseballService.playGameOneTime(stringOfNumberFromClient);
		String resultString = this.baseballService.getResultString(result);
		this.baseballView.printResult(resultString);
		boolean isGameOver = this.baseballService.checkIsGameOver(result);
		if (isGameOver) {
			this.checkRestartGame();
			return;
		}
		String newStringOfNumberFromClient = this.baseballView.repeatGame();
		playGameOneTime(newStringOfNumberFromClient);
	}

	void checkRestartGame() {
		String stringOneOrTwoForCheckRestartGame = this.baseballView.checkRestartGame();
		if (stringOneOrTwoForCheckRestartGame.equals("1")) {
			this.startGame();
		}
	}

	void validateInput(String input) throws IllegalArgumentException{
		if (input.length() != 3) {
			throw new IllegalArgumentException("3자리 숫자를 입력해야 합니다.");
		}
	}
}
