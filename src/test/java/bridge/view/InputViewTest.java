package bridge.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.stream.Stream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class InputViewTest {

    private final InputView inputView = new InputView();

    @AfterEach
    void tearDown() {
    }

    public InputStream createInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @ParameterizedTest(name = "다리 길이 입력값이 ({0})이라면 예외발생")
    @DisplayName("다리 길이 입력이 올바른 값이 아니라면 예외 발생")
    @MethodSource
    void bridgeSizeInputInvalid(String input) {
        //given
        System.setIn(createInput(input));
        //when
        Throwable result = catchThrowable(inputView::readBridgeSize);
        //then
        assertThat(result).isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> bridgeSizeInputInvalid() {
        return Stream.of(
                Arguments.of("한글"),
                Arguments.of("English"),
                Arguments.of("~!@#"),
                Arguments.of("1111111111111111111111")
        );
    }

    @ParameterizedTest(name = "다리 길이 입력값이 {0}이라면 정상")
    @DisplayName("다리 길이 입력이 올바른 값이라면 정상")
    @MethodSource
    void bridgeSizeInputValid(String input) {
        //given
        System.setIn(createInput(input));
        //when
        Throwable result = catchThrowable(inputView::readBridgeSize);
        //then
        assertThat(result).doesNotThrowAnyException();
    }

    private static Stream<Arguments> bridgeSizeInputValid() {
        return Stream.of(
                Arguments.of("1"),
                Arguments.of("12"),
                Arguments.of("123"),
                Arguments.of("1234")
        );
    }


}