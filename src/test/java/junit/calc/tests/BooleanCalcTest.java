package junit.calc.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BooleanCalcTest extends BaseCalcTestClass {

    @ParameterizedTest
    @CsvSource({
        "4,true",
        "7,true",
        "-4,false",
        "0,false"
    })
    public void isPositiveTest(long a, boolean expectedResult) {
        boolean actualResult = calc.isPositive(a);
        assertEquals(expectedResult, actualResult);
    }

    @ParameterizedTest
    @CsvSource({
        "-44,true",
        "-17,true",
        "514,false"
    })
    public void isNegativeTest(long a, boolean expectedResult) {
        boolean actualResult = calc.isNegative(a);
        assertEquals(expectedResult, actualResult);
    }
}
