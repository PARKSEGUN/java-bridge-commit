package bridge.validator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import bridge.constant.GameCommand;
import bridge.exception.RetryCommandInvalidException;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class GameCommandValidatorTest {

    @ParameterizedTest(name = "재시도 여부(R,Q) 입력값이 {0} 이라면 예외 발생")
    @DisplayName("재시도 여부(R,Q) 입력값이 R 또는 Q 가 아니라면 예외 발생")
    @MethodSource
    void retryCommandInvalid(String input) {
        Throwable result = catchThrowable(() -> GameCommand.fromInput(input));
        assertThat(result).isInstanceOf(RetryCommandInvalidException.class);
    }

    private static Stream<Arguments> retryCommandInvalid() {
        return Stream.of(
                Arguments.of("RR"),
                Arguments.of("QQ"),
                Arguments.of("U"),
                Arguments.of("D")
        );
    }

    @ParameterizedTest(name = "재시도 여부(R,Q) 입력값이 {0} 이라면 정상")
    @DisplayName("재시도 여부(R,Q) 입력값이 R 또는 Q 라면 정상")
    @MethodSource
    void retryCommandValid(String input) {
        Throwable result = catchThrowable(() -> GameCommand.fromInput(input));
        assertThat(result).doesNotThrowAnyException();
    }

    private static Stream<Arguments> retryCommandValid() {
        return Stream.of(
                Arguments.of("R"),
                Arguments.of("Q")
        );
    }
}