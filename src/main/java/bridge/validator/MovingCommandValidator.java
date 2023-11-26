package bridge.validator;

import static bridge.constant.BridgeConstant.BRIDGE_DOWN_SIGN;
import static bridge.constant.BridgeConstant.BRIDGE_UP_SIGN;

import bridge.exception.MovingKeyInvalidException;

public class MovingCommandValidator {
    public static void validateMovingCommandInvalid(String input) {
        if (input.equals(BRIDGE_UP_SIGN) || input.equals(BRIDGE_DOWN_SIGN)) {
            return;
        }
        throw MovingKeyInvalidException.exception;
    }
}
