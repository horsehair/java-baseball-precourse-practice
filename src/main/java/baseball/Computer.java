package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

public class Computer {
    int[] targetNumber = new int[3];
    static final int digits = 3;

    void startGame() {
        System.out.println("before: " + targetNumber[0]+targetNumber[1]+targetNumber[2]);
        this.resetTargetNumber();
        System.out.println("after: " + targetNumber[0]+targetNumber[1]+targetNumber[2]);
        System.out.println(Arrays.toString(getInput()));
    }

    void resetTargetNumber() {
        for (int i = 0; i < digits; i++) {
            targetNumber[i] = Randoms.pickNumberInRange(1, 9);
        }
    }

    int[] getInput() {
        String input = Console.readLine();
        int[] inputIntArray = convertStringToIntArray(input);
        return inputIntArray;
    }

    int[] convertStringToIntArray(String numberString) {
        char[] charArray = numberString.toCharArray();
        int[] intArray = new int[3];
        for (int i = 0; i < digits; i++) {
            intArray[i] = Character.getNumericValue(charArray[i]);
        }
        return intArray;
    }
}
