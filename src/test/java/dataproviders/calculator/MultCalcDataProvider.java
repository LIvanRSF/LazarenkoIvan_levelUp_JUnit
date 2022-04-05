package dataproviders.calculator;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;

public class MultCalcDataProvider {

    public static Stream<Arguments> subCalcDataProvider() {
        return Stream.of(
            Arguments.arguments(3, 3, 9),
            Arguments.arguments(4, 5, 20),
            Arguments.arguments(3, 11, 33)
        );
    }
}
