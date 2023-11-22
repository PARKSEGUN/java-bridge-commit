package bridge.domain;

import static bridge.constant.BridgeConstant.BRIDGE_DOWN_SIGN;
import static bridge.constant.BridgeConstant.BRIDGE_UP_POSITION;
import static bridge.constant.BridgeConstant.BRIDGE_UP_SIGN;

import bridge.BridgeNumberGenerator;
import bridge.validator.BridgeValidator;
import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        BridgeValidator.validateBridgeSize(size);
        List<String> bridgeInfo = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int bridgeNumber = bridgeNumberGenerator.generate();
            bridgeInfo.add(checkUpOrDown(bridgeNumber));
        }
        return bridgeInfo;
    }

    private String checkUpOrDown(int bridgeNumber) {
        if (bridgeNumber == BRIDGE_UP_POSITION) {
            return BRIDGE_UP_SIGN;
        }
        return BRIDGE_DOWN_SIGN;
    }

}
