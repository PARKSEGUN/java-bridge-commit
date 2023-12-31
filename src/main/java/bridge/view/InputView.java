package bridge.view;

import java.util.Scanner;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    Scanner scanner = new Scanner(System.in);

    /**
     * 다리의 길이를 입력받는다.
     */
    public String readBridgeSize() {
        String input = scanner.nextLine();
        return input;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String input = scanner.nextLine();
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String input = scanner.nextLine();
        return input;
    }
}
