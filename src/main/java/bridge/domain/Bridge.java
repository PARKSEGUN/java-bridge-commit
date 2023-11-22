package bridge.domain;

import java.util.List;

public class Bridge {
    private final List<String> bridgeInfo;

    public Bridge(List<String> bridgeInfo) {
        this.bridgeInfo = bridgeInfo;
    }

    //검증용(지우기)
    @Override
    public String toString() {
        return "Bridge{" +
                "bridgeInfo=" + bridgeInfo +
                '}';
    }
}
