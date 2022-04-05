package junit.calc.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TrigoCalcTest extends BaseCalcTestClass {

    @ParameterizedTest
    @CsvSource({
        "45.0, 1.0",
        "10.0, 1.0",
        "225.0, 1.0"
    })
    public void tangTest(double a, double expectedResult) {
        double actualResult = calc.tg(Math.toRadians(a));
        assertEquals(expectedResult, actualResult);
    }

    @ParameterizedTest
    @CsvSource({
        "45.0, 0.6557942026326724",
        "0.0, 0.0",
        "225.0, 0.9992238948786412"
    })
    public void catangTest(double a, double expectedResult) {
        double actualResult = calc.ctg(Math.toRadians(a));
        assertEquals(expectedResult, actualResult);
    }

    @ParameterizedTest
    @CsvSource({
        "10.0, 0.0",
        "40.0, 0.49999999999999994",
        "70.0, 0.8660254037844386"
    })
    //негативный кейс, т.к. при вызове косинуса вызывается на самоем деле синус
    public void cosTest(double a, double expectedResult) {
        double actualResult = calc.cos(Math.toRadians(a));
        assertNotEquals(expectedResult, actualResult);
    }

    @ParameterizedTest
    @CsvSource({
        "0.0, 0.0",
        "30.0, 0.49999999999999994",
        "60.0, 0.8660254037844386"
    })
    public void sinTest(double a, double expectedResult) {
        double actualResult = calc.sin(Math.toRadians(a));
        assertEquals(expectedResult, actualResult);
    }
}
