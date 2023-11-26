package bridge.domain;

import bridge.constant.MovingCommand;
import bridge.validator.BridgeValidator;
import java.util.List;

public class Bridge {
    private final List<String> bridgeInfo;

    public Bridge(List<String> bridgeInfo) {
        BridgeValidator.validateSize(bridgeInfo.size());
        this.bridgeInfo = bridgeInfo;
    }

    //검증용(지우기)
    @Override
    public String toString() {
        return "Bridge{" +
                "bridgeInfo=" + bridgeInfo +
                '}';
    }

    public Boolean canCross(int currentRound, MovingCommand movingCommand) {
        return bridgeInfo.get(currentRound - 1).equals(movingCommand.getCommand());
    }

    public int size() {
        return bridgeInfo.size();
    }
}
