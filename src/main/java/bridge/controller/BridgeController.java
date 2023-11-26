package bridge.controller;

import static bridge.constant.ErrorMessage.GAME_COMMAND_INVALID_ERROR_MESSAGE;
import static bridge.constant.OutputMessage.BRIDGE_GAME_START_MESSAGE;

import bridge.BridgeRandomNumberGenerator;
import bridge.constant.ErrorMessage;
import bridge.constant.GameCommand;
import bridge.constant.MovingCommand;
import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.domain.GameResult;
import bridge.domain.GameResults;
import bridge.exceptionHandler.InvalidInputHandler;
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
        GameResults gameResults = play(bridge);
        GameResults finalGameResults = retryOrQuit(bridge, gameResults);
        outputView.printResult(finalGameResults, bridgeGame.getAttemptCount());
    }

    private GameResults retryOrQuit(Bridge bridge, GameResults gameResults) {
        while (gameResults.isFailedGame() && createRetryCommand().isRetry()) {
            bridgeGame.retry();
            gameResults = play(bridge);
        }
        return gameResults;
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
        return InvalidInputHandler.createObjectWithInput(
                MovingCommand::fromInput,
                inputView::readMoving,
                GAME_COMMAND_INVALID_ERROR_MESSAGE
        );
    }

    private Bridge createBridge() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return InvalidInputHandler.createObjectWithInput(
                size -> new Bridge(bridgeMaker.makeBridge(Integer.parseInt(size))),
                inputView::readBridgeSize,
                ErrorMessage.BRIDGE_SIZE_ERROR_MESSAGE
        );
    }

    private GameCommand createRetryCommand() {
        return InvalidInputHandler.createObjectWithInput(
                GameCommand::fromInput,
                inputView::readGameCommand,
                GAME_COMMAND_INVALID_ERROR_MESSAGE
        );
    }
}
