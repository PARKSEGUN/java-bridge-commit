package bridge.exceptionHandler;

import bridge.view.OutputView;
import java.util.function.Function;
import java.util.function.Supplier;

public class InvalidInputHandler {

    public static <T> T createObjectWithInput(Function<String, T> creator, Supplier<String> inputMethod,
                                              String errorMessage) {
        OutputView outputView = new OutputView();
        while (true) {
            try {
                return creator.apply(inputMethod.get());
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(errorMessage);
            }
        }
    }

}
