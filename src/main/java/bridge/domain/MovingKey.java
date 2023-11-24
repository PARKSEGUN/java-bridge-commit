package bridge.domain;

import static bridge.validator.MovingKeyValidator.validateInvalid;

public class MovingKey {
    private final String key;

    public MovingKey(String key) {
        validateInvalid(key);
        this.key = key;
    }
}
