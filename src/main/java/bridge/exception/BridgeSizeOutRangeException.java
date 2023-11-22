package bridge.exception;

import static bridge.constant.ErrorMessage.BRIDGE_SIZE_ERROR_MESSAGE;

public class BridgeSizeOutRangeException extends IllegalArgumentException {

    public static final BridgeSizeOutRangeException exception = new BridgeSizeOutRangeException();

    public BridgeSizeOutRangeException() {
        super(BRIDGE_SIZE_ERROR_MESSAGE);
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
