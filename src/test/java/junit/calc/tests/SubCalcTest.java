package junit.calc.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class SubCalcTest extends BaseCalcTestClass {

    @ParameterizedTest
    @MethodSource("dataproviders.calculator.SubCalcDataProvider#subCalcDataProvider")
    public void subLongTest(long a, long b, long expectedResult) {
        long actualResult = calc.sub(a, b);
        assertEquals(expectedResult, actualResult);
    }

    @ParameterizedTest
    @MethodSource("dataproviders.calculator.SubCalcDataProvider#subCalcDataProvider")
    public void subDoubleTest(double a, double b, double expectedResult) {
        double actualResult = calc.sub(a, b);
        assertEquals(expectedResult, actualResult);
    }
}
