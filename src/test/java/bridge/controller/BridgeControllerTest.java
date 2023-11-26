package bridge.controller;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import bridge.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeControllerTest extends NsTest {
    @Test
    @DisplayName("3번 재시도 후 모든 다리를 건넌다.")
    void finalTest1() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "D", "R", "D", "R", "D", "R", "U", "D", "U");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O |   | O ]",
                    "[   | O |   ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 4"
            );
            /*
             *   [ O |   | O ] 출력이 [   | O |   ] 이 출력보다 먼저 나와야한다.
             * */
            int upSideIndex = output().indexOf("[ O |   | O ]");
            int downSideIndex = output().indexOf("[   | O |   ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 1);
    }

    @Test
    @DisplayName("3번 재시도 후 2번 라운드에서 종료.")
    void finalTest2() {
        assertRandomNumberInRangeTest(() -> {
            run("3",
                    "U", "D", "D", "R",
                    "U", "D", "D", "R",
                    "U", "D", "D", "R",
                    "U", "U", "Q");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O | X ]",
                    "[   |   ]",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 4"
            );

            int upSideIndex = output().indexOf("[ O | X ]");
            int downSideIndex = output().indexOf("[   |   ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 1);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }

}