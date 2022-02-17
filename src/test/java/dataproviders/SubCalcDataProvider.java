package dataproviders;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;

public class SubCalcDataProvider {

    public static Stream<Arguments> subCalcDataProvider() {
        return Stream.of(
            Arguments.arguments(7, 3, 4),
            Arguments.arguments(7, 2, 5),
            Arguments.arguments(7, 1, 6)
        );
    }
}
