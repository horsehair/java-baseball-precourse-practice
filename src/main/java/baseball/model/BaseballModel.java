package baseball.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class BaseballModel {
	private List<Integer> targetNumberList = new ArrayList<>(Arrays.asList(0, 0, 0));

	public void setTargetNumberList() {
		for (int indexOfList = 0; indexOfList < 3; indexOfList++) {
			setTargetNumber(indexOfList);
		}
		System.out.println(this.targetNumberList);
	}

	void setTargetNumber(int indexOfList) {
		boolean isInTargetNumberList = true;
		int randomNumber = 0;
		while (isInTargetNumberList) {
			randomNumber = Randoms.pickNumberInRange(1, 9);
			System.out.println(randomNumber);
			isInTargetNumberList = checkIsNumberInTargetList(randomNumber);
		}
		targetNumberList.set(indexOfList, randomNumber);
	}

	boolean checkIsNumberInTargetList(int number) {
		return this.targetNumberList.contains(number);
	}

	public List<Integer> getTargetNumberList() {
		return this.targetNumberList;
	}
}
