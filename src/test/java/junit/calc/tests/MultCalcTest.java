package junit.calc.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class MultCalcTest extends BaseCalcTestClass {

    @ParameterizedTest
    @MethodSource("dataproviders.MultCalcDataProvider#subCalcDataProvider")
    public void multLongTest(long a, long b, long expectedResult) {
        long actualResult = calc.mult(a, b);
        assertEquals(expectedResult, actualResult);
    }

    @ParameterizedTest
    @MethodSource("dataproviders.MultCalcDataProvider#subCalcDataProvider")
    public void multDoubleTest(double a, double b, double expectedResult) {
        double actualResult = calc.mult(a, b);
        assertEquals(expectedResult, actualResult);
    }
}
