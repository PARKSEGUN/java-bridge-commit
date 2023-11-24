package bridge.controller;

import static bridge.constant.ErrorMessage.BRIDGE_SIZE_ERROR_MESSAGE;
import static bridge.constant.ErrorMessage.MOVING_KEY_INVALID_ERROR_MESSAGE;
import static bridge.constant.OutputMessage.BRIDGE_GAME_START_MESSAGE;
import static bridge.constant.OutputMessage.REQUEST_MOVING_KEY_MESSAGE;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.MovingKey;
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
        play();
    }

    private void play() {
        MovingKey movingKey = createMovingKey();

    }

    private MovingKey createMovingKey() {
        while (true) {
            outputView.printGameMessage(REQUEST_MOVING_KEY_MESSAGE);
            try {
                return new MovingKey(inputView.readMoving());
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(MOVING_KEY_INVALID_ERROR_MESSAGE);
            }
        }
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
