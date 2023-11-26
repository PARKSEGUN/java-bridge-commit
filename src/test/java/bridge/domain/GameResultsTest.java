package bridge.domain;

import static bridge.constant.MovingCommand.DOWN;
import static bridge.constant.MovingCommand.UP;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class GameResultsTest {

    private final List<GameResult> gameResults = new ArrayList<>();

    @ParameterizedTest(name = "전체 결과에 {0}결과가 추가된다면 성공 여부는 {1}이다.")
    @DisplayName("게임의 실패 여부를 판단한다.")
    @MethodSource
    void checkGameIsSuccess(GameResult gameResult, boolean expectedResult) {
        //given
        gameResults.add(gameResult);
        GameResults newGameResults = new GameResults(gameResults);
        //when
        boolean result = newGameResults.isFailedGame();
        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> checkGameIsSuccess() {
        return Stream.of(
                Arguments.of(new GameResult(UP, false), true),
                Arguments.of(new GameResult(UP, true), false),
                Arguments.of(new GameResult(DOWN, false), true),
                Arguments.of(new GameResult(DOWN, true), false)
        );
    }
}