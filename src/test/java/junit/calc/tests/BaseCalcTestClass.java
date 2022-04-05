package junit.calc.tests;

import org.junit.jupiter.api.BeforeEach;
import ru.levelup.qa.at.calculator.Calculator;

public abstract class BaseCalcTestClass {

    protected Calculator calc;

    @BeforeEach
    public void setUp() {

        calc = new Calculator();
    }
}
