package bridge.domain;

import static bridge.constant.MovingCommand.DOWN;
import static bridge.constant.MovingCommand.UP;
import static org.assertj.core.api.Assertions.assertThat;

import bridge.constant.MovingCommand;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BridgeGameTest {

    private final Bridge bridge = new Bridge(List.of("U", "U", "D", "D", "U"));
    private final int INIT_COUNT = 1;
    private BridgeGame bridgeGame = new BridgeGame();


    @BeforeEach
    void setUp() {
        bridgeGame = new BridgeGame();
    }

    @ParameterizedTest(name = "{0}라운드에서 {1}을 입력시에 결과는 {2}")
    @DisplayName("입력한 위치에 따른 결과의 유효성 테스트")
    @MethodSource
    void bridgeMoveValidTest(int currentRound, MovingCommand movingCommand, boolean expectSuccess) {
        //given
        GameResult gameResult = null;
        //when
        for (int i = 0; i < currentRound; i++) {
            gameResult = bridgeGame.move(bridge, movingCommand);
        }
        //then
        assert gameResult != null;
        assertThat(gameResult.isSuccess()).isEqualTo(expectSuccess);
    }

    private static Stream<Arguments> bridgeMoveValidTest() {
        return Stream.of(
                Arguments.of(1, UP, true),
                Arguments.of(2, UP, true),
                Arguments.of(3, DOWN, true)
        );
    }

    @ParameterizedTest(name = "{0}라운드에서 {1}을 입력시에 결과는 {2}")
    @DisplayName("재시도를 실행하면 시도횟수는 증가한다.")
    @MethodSource
    void retryRetryGameResult(int attemptCount) {
        //given
        //when
        for (int i = 0; i < attemptCount; i++) {
            bridgeGame.retry();
        }
        //then
        assertThat(bridgeGame.getAttemptCount()).isEqualTo(attemptCount + 1);
    }

    private static Stream<Arguments> retryRetryGameResult() {
        return Stream.of(
                Arguments.of(1),
                Arguments.of(2),
                Arguments.of(3)
        );
    }
}