package baseball;
import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    int[] targetNumber = new int[3];

    void startGame() {
        System.out.println("before: " + targetNumber[0]+targetNumber[1]+targetNumber[2]);
        this.resetTargetNumber();
        System.out.println("after: " + targetNumber[0]+targetNumber[1]+targetNumber[2]);
    }

    void resetTargetNumber() {
        for (int i = 0; i < targetNumber.length; i++) {
            targetNumber[i] = Randoms.pickNumberInRange(1, 9);
        }
    }
}
