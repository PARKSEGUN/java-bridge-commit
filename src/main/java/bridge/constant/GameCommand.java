package bridge.constant;

import bridge.validator.RetryCommandValidator;
import java.util.Arrays;

public enum GameCommand {
    RETRY("R"),
    QUIT("Q");

    private final String command;


    GameCommand(String command) {
        this.command = command;
    }

    public static GameCommand fromInput(String input) {
        RetryCommandValidator.validateRetryCommandInvalid(input);
        return Arrays.stream(values())
                .filter(gameCommand -> gameCommand.getCommand().equals(input))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("이동할 입력값은 R 또는 Q 이어야 합니다"));
    }

    public boolean isRetry() {
        return this == RETRY;
    }

    public String getCommand() {
        return command;
    }
}
