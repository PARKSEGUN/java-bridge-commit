package bridge.validator;

import static bridge.constant.GameCommand.QUIT;
import static bridge.constant.GameCommand.RETRY;

import bridge.exception.RetryCommandInvalidException;

public class RetryCommandValidator {
    public static void validateRetryCommandInvalid(String input) {
        if (input.equals(RETRY.getCommand()) || input.equals(QUIT.getCommand())) {
            return;
        }
        throw RetryCommandInvalidException.exception;
    }
}
