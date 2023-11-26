package bridge.exception;

import static bridge.constant.ErrorMessage.RETRY_COMMAND_INVALID_ERROR_MESSAGE;

public class RetryCommandInvalidException extends IllegalArgumentException {
    public static final RetryCommandInvalidException exception = new RetryCommandInvalidException();

    public RetryCommandInvalidException() {
        super(RETRY_COMMAND_INVALID_ERROR_MESSAGE);
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }

}
