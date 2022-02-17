package junit.calc.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class SumCalcTest extends BaseCalcTestClass {

    @ParameterizedTest
    @MethodSource("dataproviders.SumCalcDataProvider#sumCalcDataProvider")
    public void sumLongTest(long a, long b, long expectedResult) {
        long actualResult = calc.sum(a, b);
        assertEquals(expectedResult, actualResult);
    }

    @ParameterizedTest
    @MethodSource("dataproviders.SumCalcDataProvider#sumCalcDataProvider")
    public void sumDoubleTest(double a, double b, double expectedResult) {
        double actualResult = calc.sum(a, b);
        assertEquals(expectedResult, actualResult);
    }
}
