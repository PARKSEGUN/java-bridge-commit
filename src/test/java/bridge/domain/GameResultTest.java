package bridge.domain;

import static bridge.constant.MovingCommand.DOWN;
import static bridge.constant.MovingCommand.UP;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class GameResultTest {
    @ParameterizedTest(name = "결과가 {0} 이라면 {1}이다.")
    @DisplayName("한 라운드의 성공 여부를 판단한다.")
    @MethodSource
    void checkGameIsSuccess(GameResult gameResult, boolean expectedResult) {
        //given
        //when
        boolean result = gameResult.isSuccess();
        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> checkGameIsSuccess() {
        return Stream.of(
                Arguments.of(new GameResult(UP, false), false),
                Arguments.of(new GameResult(UP, true), true),
                Arguments.of(new GameResult(DOWN, false), false),
                Arguments.of(new GameResult(DOWN, true), true)
        );
    }
}