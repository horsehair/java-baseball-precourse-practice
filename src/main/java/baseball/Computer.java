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
        compareInputWithTarget();
        boolean checkRestart = checkRestart();
        if(checkRestart) {
            startGame();
        };
    }

    void resetTargetNumber() {
        targetNumber[0] = Randoms.pickNumberInRange(1, 9);
        while(true) {
            int temp = Randoms.pickNumberInRange(1, 9);
            if (temp != targetNumber[0]) {
                targetNumber[1] = temp;
                break;
            }
        }
        while(true) {
            int temp = Randoms.pickNumberInRange(1, 9);
            if (temp != targetNumber[0] && temp != targetNumber[1]) {
                targetNumber[2] = temp;
                break;
            }
        }

    }

    int[] getInput() {
        System.out.print("숫자를 입력해주세요 : ");
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

    void compareInputWithTarget() {
        int[] input = getInput();
        int strikes = checkStrikes(input);
        int ballsIncludeStrikes = checkBallsIncludeStrikes(input);
        int balls = ballsIncludeStrikes - strikes;
        returnResult(strikes, balls);
        if (checkEnd(strikes) == false) {
            compareInputWithTarget();
        }
    }

    int checkStrikes(int[] input) {
        int strikes = 0;
        for (int i = 0; i < digits; i++) {
            strikes += returnIntOfSameOrNot(input[i], targetNumber[i]);
        }
        return strikes;
    }

    int checkBallsIncludeStrikes(int[] input) {
        int ballsIncludeStrikes = 0;
        for (int i = 0; i < digits; i++) {
            ballsIncludeStrikes += returnIntoOfIncludeOrNot(input[i], targetNumber);
        }
        return ballsIncludeStrikes;
    }

    int returnIntOfSameOrNot(int a, int b) {
        if (a == b) {
            return 1;
        }
        return 0;
    }

    int returnIntoOfIncludeOrNot(int a, int[] b) {
        boolean isIncluded = Arrays.stream(b)
            .anyMatch(num -> num == a);
        if (isIncluded) {
            return 1;
        }
        return 0;
    }

    void returnResult(int strikes, int balls) {
        String checkResult = checkResult(strikes, balls);
        if (checkResult.equals("낫싱")) {
            System.out.println("낫싱");
        }
        if (checkResult.equals("스트라이크만")) {
            System.out.println(strikes + "스트라이크");
        }
        if (checkResult.equals("볼만")) {
            System.out.println(balls + "볼");
        }
        if (checkResult.equals("둘다")) {
            System.out.println(balls + "볼 " + strikes + "스트라이크");
        }
    }

    String checkResult(int strikes, int balls) {
        if (strikes == 0 && balls == 0) {
            return "낫싱";
        }
        if (balls == 0) {
            return "스트라이크만";
        }
        if (strikes == 0) {
            return "볼만";
        }
        return "둘다";
    }

    boolean checkEnd(int strikes) {
        if (strikes != 3) {
            return false;
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        return true;
    }

    boolean checkRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
//        System.out.println(input);
        if (input.equals("1")) {
            return true;
        }
        return false;
    }

}
