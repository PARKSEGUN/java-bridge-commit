package bridge.domain;

import bridge.BridgeRandomNumberGenerator;
import bridge.constant.MovingCommand;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static final int START_ROUND = 0;
    private int currentRound;

    public BridgeGame() {
        this.currentRound = START_ROUND;
    }

    public Bridge createBridge(int size) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return new Bridge(bridgeMaker.makeBridge(size));
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public GameResult move(Bridge bridge, MovingCommand movingCommand) {
        return new GameResult(movingCommand, bridge.canMove(currentRound, movingCommand));
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
