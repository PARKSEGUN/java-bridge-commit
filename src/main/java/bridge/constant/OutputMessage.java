package bridge.constant;

public final class OutputMessage {
    public static final String BRIDGE_GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    public static final String REQUEST_MOVING_COMMAND_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    public static final String REQUEST_RETRY_COMMAND_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    public static final String FINAL_GAME_RESULT_MESSAGE = "\n최종 게임 결과";
    public static final String SUCCESS = "성공";
    public static final String FAIL = "실패";

    public static final String GAME_RESULT_FORMAT = "\n게임 성공 여부: %s";
    public static final String ATTEMPT_COUNT_FORMAT = "총 시도한 횟수: %d";
}
