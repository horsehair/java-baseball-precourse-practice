package baseball.view;

import baseball.controller.BaseballController;
import camp.nextstep.edu.missionutils.Console;

public class BaseballView {
	private BaseballController baseballController = new BaseballController();

	public void getStringOfNumberFromClient() {
		System.out.print("숫자를 입력해주세요 : ");
		String stringOfNumberFromClient = Console.readLine();
		this.baseballController.playGameOneTime(stringOfNumberFromClient);
	}
}
