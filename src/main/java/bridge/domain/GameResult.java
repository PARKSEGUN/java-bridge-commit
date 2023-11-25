package bridge.domain;

import bridge.constant.MovingCommand;

public class GameResult {

    private final MovingCommand movingCommand;
    private final Boolean isSuccess;

    public GameResult(MovingCommand movingCommand, Boolean isSuccess) {
        this.movingCommand = movingCommand;
        this.isSuccess = isSuccess;
    }

    public MovingCommand getMovingCommand() {
        return movingCommand;
    }

    public Boolean getSuccess() {
        return isSuccess;
    }
}
