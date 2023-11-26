package bridge.constant;

import bridge.validator.MovingCommandValidator;
import java.util.Arrays;

public enum MovingCommand {
    UP("U", 2),
    DOWN("D", 1);

    private final String command;
    private final int floor;

    MovingCommand(String command, int floor) {
        this.command = command;
        this.floor = floor;
    }

    //제네릭을 사용해서 줄여보기
    public static MovingCommand fromInput(String input) {
        MovingCommandValidator.validateMovingCommandInvalid(input);
        return Arrays.stream(values())
                .filter(movingCommand -> movingCommand.commandEquals(input))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("이동할 입력값은 U 또는 D 이어야 합니다"));
    }

    public static MovingCommand fromFloor(int inputFloor) {
        return Arrays.stream(values())
                .filter(movingCommand -> movingCommand.floor == inputFloor)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("주어진 층수의 다리는 존재하지 않습니다."));
    }

    private boolean commandEquals(String input) {
        return command.equals(input);
    }

    public String getCommand() {
        return command;
    }
}
