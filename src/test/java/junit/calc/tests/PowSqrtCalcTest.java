package junit.calc.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PowSqrtCalcTest extends BaseCalcTestClass {

    @ParameterizedTest
    @CsvSource({
        "2, 4, 16",
        "3, 3, 27",
        "2, 5, 32"
    })
    public void powTest(double a, double b, double expectedResult) {
        double actualResult = calc.pow(a, b);
        assertEquals(expectedResult, actualResult);
    }

    @ParameterizedTest
    @CsvSource({
        "16, 4",
        "9, 3",
        "4, 2"
    })
    public void sqrtTest(double a, double expectedResult) {
        double actualResult = calc.sqrt(a);
        assertEquals(expectedResult, actualResult);
    }
}
