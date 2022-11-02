package baseball.view;

import baseball.controller.BaseballController;
import camp.nextstep.edu.missionutils.Console;

public class BaseballView {

	public String getStringOfNumberFromClient() {
		System.out.print("숫자를 입력해주세요 : ");
		String stringOfNumberFromClient = Console.readLine();
		return stringOfNumberFromClient;
	}

	public String repeatGame(String resultString) {
		System.out.println(resultString);
		String stringOfNumberFromClient = this.getStringOfNumberFromClient();
		return stringOfNumberFromClient;
	}
}
