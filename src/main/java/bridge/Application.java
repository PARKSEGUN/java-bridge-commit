package bridge;

import bridge.controller.BridgeController;
import bridge.domain.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BridgeController bridgeController = new BridgeController(new BridgeGame(), new OutputView(), new InputView());
        bridgeController.run();
    }
}
