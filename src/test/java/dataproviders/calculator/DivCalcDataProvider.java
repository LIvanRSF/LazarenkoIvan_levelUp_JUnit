package dataproviders.calculator;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;

public class DivCalcDataProvider {

    public static Stream<Arguments> divCalcDataProvider() {
        return Stream.of(
            Arguments.arguments(10, 5, 2),
            Arguments.arguments(14, 2, 7),
            Arguments.arguments(33, 11, 3)
        );
    }
}
