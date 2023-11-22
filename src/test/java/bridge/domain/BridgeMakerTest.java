package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.BridgeRandomNumberGenerator;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BridgeMakerTest {

    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    @ParameterizedTest(name = "다리 길이가 {0} 일때 다리 생성")
    @DisplayName("다리가 올바르게 생성 되는지 테스트")
    @MethodSource
    void bridgeMakerSuccess(int bridgeSize) {
        //given
        List<String> bridgeInfo = bridgeMaker.makeBridge(bridgeSize);
        //when
        long result = bridgeInfo.stream()
                .filter((info) -> info.equals("U") || info.equals("D"))
                .count();
        //then
        assertThat(result).isEqualTo(bridgeSize);
    }

    private static Stream<Arguments> bridgeMakerSuccess() {
        return Stream.of(
                Arguments.of(3),
                Arguments.of(4),
                Arguments.of(19),
                Arguments.of(20)
        );
    }
}