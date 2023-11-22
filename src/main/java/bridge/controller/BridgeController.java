package bridge.controller;

import static bridge.constant.ErrorMessage.BRIDGE_SIZE_ERROR_MESSAGE;
import static bridge.constant.OutputMessage.BRIDGE_GAME_START_MESSAGE;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {

    private final BridgeGame bridgeGame;
    private final OutputView outputView;
    private final InputView inputView;

    public BridgeController(BridgeGame bridgeGame, OutputView outputView, InputView inputView) {
        this.bridgeGame = bridgeGame;
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void run() {
        outputView.printGameMessage(BRIDGE_GAME_START_MESSAGE);
        Bridge bridge = createBridge();
       
    }

    private Bridge createBridge() {
        while (true) {
            try {
                return bridgeGame.createBridge(inputView.readBridgeSize());
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(BRIDGE_SIZE_ERROR_MESSAGE);
            }
        }
    }
}
