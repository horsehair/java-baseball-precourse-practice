package baseball.model;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class BaseballModel {
	private List<Integer> targetNumberList;

	void setTargetNumberList() {
		for (int i = 0; i < 3; i++) {
			int randomNumber = Randoms.pickNumberInRange(1, 9);
			targetNumberList.set(i, randomNumber);
		}
	}

	List<Integer> getTargetNumberList() {
		return this.targetNumberList;
	}
}
