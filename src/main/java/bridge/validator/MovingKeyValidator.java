package bridge.validator;

import static bridge.constant.BridgeConstant.BRIDGE_DOWN_SIGN;
import static bridge.constant.BridgeConstant.BRIDGE_UP_SIGN;

import bridge.exception.MovingKeyInvalidException;

public class MovingKeyValidator {
    public static void validateInvalid(String key) {
        if (key.equals(BRIDGE_UP_SIGN) || key.equals(BRIDGE_DOWN_SIGN)) {
            return;
        }
        throw MovingKeyInvalidException.exception;
    }
}
