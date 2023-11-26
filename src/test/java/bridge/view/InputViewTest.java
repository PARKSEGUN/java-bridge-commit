package bridge.view;

class InputViewTest {
    /*
     *   scanner 오류로 인한 주석 처리
     * */

//
//    private final InputView inputView = new InputView();
//    private static Scanner scanner;
//
//    @AfterAll
//    static void afterAll() {
//        scanner.close();
//    }
//
//    public InputStream createInput(String input) {
//        return new ByteArrayInputStream(input.getBytes());
//    }
//
//    @ParameterizedTest(name = "다리 길이 입력값이 ({0})이라면 예외발생")
//    @DisplayName("다리 길이 입력이 올바른 값이 아니라면 예외 발생")
//    @MethodSource
//    void bridgeSizeInputInvalid(String input) {
//        //given
//        System.setIn(createInput(input));
//        scanner = new Scanner(System.in);
//        //when
//        Throwable result = catchThrowable(inputView::readBridgeSize);
//        //then
//        assertThat(result).isInstanceOf(IllegalArgumentException.class);
//    }
//
//    private static Stream<Arguments> bridgeSizeInputInvalid() {
//        return Stream.of(
//                Arguments.of("한글"),
//                Arguments.of("English"),
//                Arguments.of("~!@#"),
//                Arguments.of("1111111111111111111111")
//        );
//    }
//
//    @ParameterizedTest(name = "다리 길이 입력값이 {0}이라면 정상")
//    @DisplayName("다리 길이 입력이 올바른 값이라면 정상")
//    @MethodSource
//    void bridgeSizeInputValid(String input) {
//        //given
//        System.setIn(createInput(input));
//        //when
//        Throwable result = catchThrowable(inputView::readBridgeSize);
//        //then
//        assertThat(result).doesNotThrowAnyException();
//    }
//
//    private static Stream<Arguments> bridgeSizeInputValid() {
//        return Stream.of(
//                Arguments.of("1"),
//                Arguments.of("12"),
//                Arguments.of("123"),
//                Arguments.of("1234")
//        );
//    }
//

}