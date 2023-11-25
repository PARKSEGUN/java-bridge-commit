package bridge.domain;

import static bridge.constant.MovingCommand.DOWN;
import static bridge.constant.MovingCommand.UP;
import static org.assertj.core.api.Assertions.assertThat;

import bridge.constant.MovingCommand;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BridgeTest {


    private final Bridge bridge = new Bridge(List.of("U", "U", "D", "D", "U"));

    @ParameterizedTest(name = "{0}번 라운드에서 {1} 커맨드로 다리를 건널 수 있는지에 대한 결과는 {2}")
    @DisplayName("다리를 건널 수 있는지 테스트")
    @MethodSource
    void canCrossBridge(int currentRound, MovingCommand movingCommand, boolean expectedResult) {
        //given

        //when
        Boolean result = bridge.canCross(currentRound, movingCommand);
        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> canCrossBridge() {
        return Stream.of(
                Arguments.of(1, DOWN, false),
                Arguments.of(2, UP, true),
                Arguments.of(3, DOWN, true),
                Arguments.of(5, UP, true)
        );
    }

    @ParameterizedTest(name = "다리의 길이는 {1}여야 한다")
    @DisplayName("다리의 길이 값을 제대로 불러오는지 테스트")
    @MethodSource
    void bridgeSizeTest(Bridge bridge, int expectedResult) {
        //given

        //when
        int result = bridge.size();
        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> bridgeSizeTest() {
        return Stream.of(
                Arguments.of(new Bridge(List.of("U", "U", "D", "D", "U")), 5),
                Arguments.of(new Bridge(List.of("D", "D", "U", "D")), 4),
                Arguments.of(new Bridge(List.of("D", "D", "U")), 3)
        );
    }
}