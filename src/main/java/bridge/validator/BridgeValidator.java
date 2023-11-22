package bridge.validator;

import bridge.constant.BridgeConstant;
import bridge.exception.BridgeSizeOutRangeException;

public class BridgeValidator {

    public static void validateBridgeSize(int size) {
        if (size < BridgeConstant.BRIDGE_MIN_SIZE || size > BridgeConstant.BRIDGE_MAX_SIZE) {
            throw BridgeSizeOutRangeException.exception;
        }
    }
}
