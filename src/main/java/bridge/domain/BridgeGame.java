package bridge.domain;

import bridge.constant.MovingCommand;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private static final int START_ROUND = 1;
    private static final int START_COUNT = 1;

    private int currentRound;
    private int attemptCount;

    public BridgeGame() {
        this.currentRound = START_ROUND;
        this.attemptCount = START_COUNT;
    }

    public void moveToNextRound() {
        currentRound++;
    }

    public boolean isGameOver(Bridge bridge) {
        return bridge.size() < currentRound;
    }


    public boolean isMoving(Bridge bridge, List<GameResult> gameResults) {
        if (gameResults.isEmpty()) {
            return true;
        }
        if ((isGameOver(bridge)) || (gameResults.get(gameResults.size() - 1).isFailed())) {
            return false;
        }
        return true;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public GameResult move(Bridge bridge, MovingCommand movingCommand) {
        return new GameResult(movingCommand, bridge.canCross(currentRound, movingCommand));
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
