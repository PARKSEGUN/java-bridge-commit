package bridge.exception;

import static bridge.constant.ErrorMessage.MOVING_KEY_INVALID_ERROR_MESSAGE;

public class MovingKeyInvalidException extends IllegalArgumentException {
    public static final MovingKeyInvalidException exception = new MovingKeyInvalidException();

    public MovingKeyInvalidException() {
        super(MOVING_KEY_INVALID_ERROR_MESSAGE);
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }

}
