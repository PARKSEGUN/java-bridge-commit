package bridge.validator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import bridge.constant.MovingCommand;
import bridge.exception.MovingKeyInvalidException;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MovingCommandValidatorTest {

    @ParameterizedTest(name = "이동할 위치가 {0} 이라면 예외 발생")
    @DisplayName("이동할 위치가 U 또는 D 가 아니라면 예외 발생")
    @MethodSource
    void movingKeyInvalid(String input) {
        Throwable result = catchThrowable(() -> MovingCommand.findByInput(input));
        assertThat(result).isInstanceOf(MovingKeyInvalidException.class);
    }

    private static Stream<Arguments> movingKeyInvalid() {
        return Stream.of(
                Arguments.of("UU"),
                Arguments.of("Q"),
                Arguments.of("1"),
                Arguments.of("~")
        );
    }

    @ParameterizedTest(name = "이동할 위치가 {0} 이라면 정상")
    @DisplayName("이동할 위치가 U 또는 D 라면 정상")
    @MethodSource
    void movingKeyValid(String input) {
        Throwable result = catchThrowable(() -> MovingCommand.findByInput(input));
        assertThat(result).doesNotThrowAnyException();
    }

    private static Stream<Arguments> movingKeyValid() {
        return Stream.of(
                Arguments.of("U"),
                Arguments.of("D")
        );
    }
}