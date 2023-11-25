package bridge.controller;

import static bridge.constant.ErrorMessage.BRIDGE_SIZE_ERROR_MESSAGE;
import static bridge.constant.ErrorMessage.MOVING_COMMAND_INVALID_ERROR_MESSAGE;
import static bridge.constant.OutputMessage.BRIDGE_GAME_START_MESSAGE;
import static bridge.constant.OutputMessage.REQUEST_MOVING_COMMAND_MESSAGE;

import bridge.constant.MovingCommand;
import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.GameResult;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.ArrayList;
import java.util.List;

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
        System.out.println(bridge);
        play(bridge);
    }

    private void play(Bridge bridge) {
        List<GameResult> gameResults = new ArrayList<>();
        while (true) {
            MovingCommand movingCommand = createMovingCommand();
            gameResults.add(bridgeGame.move(bridge, movingCommand));
            outputView.printMap(gameResults);
        }

    }

    private MovingCommand createMovingCommand() {
        while (true) {
            outputView.printGameMessage(REQUEST_MOVING_COMMAND_MESSAGE);
            try {
                return MovingCommand.findByInput(inputView.readMoving());
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(MOVING_COMMAND_INVALID_ERROR_MESSAGE);
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
