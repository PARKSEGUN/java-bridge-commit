package bridge.controller;

import static bridge.constant.ErrorMessage.BRIDGE_SIZE_ERROR_MESSAGE;
import static bridge.constant.ErrorMessage.MOVING_COMMAND_INVALID_ERROR_MESSAGE;
import static bridge.constant.ErrorMessage.RETRY_COMMAND_INVALID_ERROR_MESSAGE;
import static bridge.constant.OutputMessage.BRIDGE_GAME_START_MESSAGE;
import static bridge.constant.OutputMessage.REQUEST_MOVING_COMMAND_MESSAGE;
import static bridge.constant.OutputMessage.REQUEST_RETRY_COMMAND_MESSAGE;

import bridge.BridgeRandomNumberGenerator;
import bridge.constant.MovingCommand;
import bridge.constant.RetryCommand;
import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.domain.GameResult;
import bridge.domain.GameResults;
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

    //컨트롤러가 너무 복잡하다는 생각
    public void run() {
        outputView.printGameMessage(BRIDGE_GAME_START_MESSAGE);
        Bridge bridge = createBridge();
        System.out.println(bridge); //삭제
        //과연 좋은 방법인가
        GameResults gameResults = play(bridge);
        while (gameResults.isFailedGame() && createRetryCommand().isRetry()) {
            bridgeGame.retry();
            gameResults = play(bridge);
        }
        outputView.printResult(gameResults, bridgeGame.getAttemptCount());
    }

    private GameResults play(Bridge bridge) {
        List<GameResult> gameResults = new ArrayList<>();
        while (bridgeGame.isMoving(bridge, gameResults)) {
            GameResult gameResult = bridgeGame.move(bridge, createMovingCommand());
            gameResults.add(gameResult);
            outputView.printMap(gameResults);
        }
        return new GameResults(gameResults);
    }

    private MovingCommand createMovingCommand() {
        while (true) {
            outputView.printGameMessage(REQUEST_MOVING_COMMAND_MESSAGE);
            try {
                return MovingCommand.fromInput(inputView.readMoving());
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(MOVING_COMMAND_INVALID_ERROR_MESSAGE);
            }
        }
    }

    private Bridge createBridge() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        while (true) {
            try {
                return new Bridge(bridgeMaker.makeBridge(inputView.readBridgeSize()));
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(BRIDGE_SIZE_ERROR_MESSAGE);
            }
        }
    }

    private RetryCommand createRetryCommand() {
        while (true) {
            outputView.printGameMessage(REQUEST_RETRY_COMMAND_MESSAGE);
            try {
                return RetryCommand.fromInput(inputView.readGameCommand());
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(RETRY_COMMAND_INVALID_ERROR_MESSAGE);
            }
        }
    }


}
