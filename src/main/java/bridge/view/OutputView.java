package bridge.view;

import static bridge.constant.BridgeConstant.BRIDGE_FLOOR_SIZE;

import bridge.constant.MapSign;
import bridge.constant.MovingCommand;
import bridge.domain.GameResult;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String MAP_PRINT_START_SIGN = "[";
    private static final String MAP_PRINT_CLOSE_SIGN = "]";
    private static final String MAP_PRINT_MOVING_FORMAT = " %s ";

    private static final String MAP_PRINT_DIVIDE_SIGN = "|";

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public void printGameMessage(String gameMessage) {
        System.out.println(gameMessage);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<GameResult> gameResults) {
        for (int floor = BRIDGE_FLOOR_SIZE; floor > 0; floor--) {
            printMapByFloor(MovingCommand.findByFloor(floor), gameResults);
            System.out.println();
        }

    }

    private void printMapByFloor(MovingCommand movingCommand, List<GameResult> gameResults) {
        System.out.print(MAP_PRINT_START_SIGN);
        for (GameResult gameResult : gameResults) {
            System.out.print(String.format(MAP_PRINT_MOVING_FORMAT, MapSign.of(gameResult, movingCommand).getSign()));
            if (gameResults.get(gameResults.size() - 1).equals(gameResult)) {
                break;
            }
            System.out.print(MAP_PRINT_DIVIDE_SIGN);
        }
        System.out.print(MAP_PRINT_CLOSE_SIGN);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
