package bridge.validator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import bridge.exception.BridgeSizeOutRangeException;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BridgeValidatorTest {
    @ParameterizedTest(name = "다리 길이가 {0} 일때 예외발생")
    @DisplayName("다리 길이가 3이상 20이하 아니라면 예외 처리")
    @MethodSource
    void bridgeSizeOutRange(int bridgeSize) {
        Throwable result = catchThrowable(() -> BridgeValidator.validateSize(bridgeSize));
        assertThat(result).isInstanceOf(BridgeSizeOutRangeException.class);
    }

    private static Stream<Arguments> bridgeSizeOutRange() {
        return Stream.of(
                Arguments.of(1),
                Arguments.of(2),
                Arguments.of(21),
                Arguments.of(22)
        );
    }

    @ParameterizedTest(name = "다리 길이가 {0} 일때 정상")
    @DisplayName("다리 길이가 3이상 20이하라면 정상")
    @MethodSource
    void bridgeSizeInRange(int bridgeSize) {
        Throwable result = catchThrowable(() -> BridgeValidator.validateSize(bridgeSize));
        assertThat(result).doesNotThrowAnyException();
    }

    private static Stream<Arguments> bridgeSizeInRange() {
        return Stream.of(
                Arguments.of(3),
                Arguments.of(4),
                Arguments.of(19),
                Arguments.of(20)
        );
    }
}