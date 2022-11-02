package baseball.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class BaseballModel {
	private List<Integer> targetNumberList = new ArrayList<>(Arrays.asList(0, 0, 0));

	public void setTargetNumberList() {
		this.targetNumberList = new ArrayList<>(Arrays.asList(0, 0, 0));
		for (int indexOfList = 0; indexOfList < 3; indexOfList++) {
			setTargetNumber(indexOfList);
		}
		System.out.println("너만 알려줄게~ 비밀이야 (테스트용): " + this.targetNumberList);
	}

	void setTargetNumber(int indexOfList) {
		boolean isInTargetNumberList = true;
		int randomNumber = 0;
		while (isInTargetNumberList) {
			randomNumber = Randoms.pickNumberInRange(1, 9);
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
