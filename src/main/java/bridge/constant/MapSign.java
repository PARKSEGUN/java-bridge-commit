package bridge.constant;

import bridge.domain.GameResult;

public enum MapSign {
    CORRECT("O"),
    INCORRECT("X"),
    NONE(" ");

    private final String sign;

    MapSign(String sign) {
        this.sign = sign;
    }

    //if문 클린한지 다시 보기
    public static MapSign of(GameResult gameResult, MovingCommand movingCommand) {
        if (gameResult.getMovingCommand().equals(movingCommand)) {
            if (gameResult.getSuccess().equals(true)) {
                return CORRECT;
            }
            return INCORRECT;
        }
        return NONE;
    }


    public String getSign() {
        return sign;
    }
}
