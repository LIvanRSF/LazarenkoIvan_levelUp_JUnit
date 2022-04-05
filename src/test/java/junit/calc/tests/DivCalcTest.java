package junit.calc.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class DivCalcTest extends BaseCalcTestClass {

    @ParameterizedTest
    @MethodSource("dataproviders.calculator.DivCalcDataProvider#divCalcDataProvider")
    public void divLongTest(long a, long b, long expectedResult) {
        long actualResult = calc.div(a, b);
        assertEquals(expectedResult, actualResult);
    }

    @ParameterizedTest
    @MethodSource("dataproviders.calculator.DivCalcDataProvider#divCalcDataProvider")
    public void divDoubleTest(double a, double b, double expectedResult) {
        double actualResult = calc.div(a, b);
        assertEquals(expectedResult, actualResult);
    }
}
