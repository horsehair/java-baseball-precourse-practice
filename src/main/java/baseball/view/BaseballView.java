package baseball.view;

import baseball.controller.BaseballController;
import camp.nextstep.edu.missionutils.Console;

public class BaseballView {

	public String getStringOfNumberFromClient() {
		System.out.print("숫자를 입력해주세요 : ");
		String stringOfNumberFromClient = Console.readLine();
		return stringOfNumberFromClient;
	}

	public void printResult(String resultString) {
		System.out.println(resultString);
	}

	public String repeatGame() {
		String stringOfNumberFromClient = this.getStringOfNumberFromClient();
		return stringOfNumberFromClient;
	}

	public String checkRestartGame() {
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		String stringOneOrTwoForCheckRestartGame = Console.readLine();
		return stringOneOrTwoForCheckRestartGame;
	}
}
