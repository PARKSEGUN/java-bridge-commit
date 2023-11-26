package bridge.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameResults {
    private final List<GameResult> gameResults;

    public GameResults(List<GameResult> gameResults) {
        this.gameResults = new ArrayList<>(gameResults);
    }

    public boolean isFailedGame() {
        if (gameResults.isEmpty()) {
            return false;
        }
        return gameResults.get(gameResults.size() - 1).isFailed();
    }

    public List<GameResult> getGameResults() {
        return Collections.unmodifiableList(gameResults);
    }


}
