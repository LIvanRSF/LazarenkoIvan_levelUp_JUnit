package dataproviders.calculator;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;

public class SumCalcDataProvider {

    public static Stream<Arguments> sumCalcDataProvider() {
        return Stream.of(
            Arguments.arguments(2, 3, 5),
            Arguments.arguments(3, 4, 7),
            Arguments.arguments(4, 5, 9)
        );
    }
}
