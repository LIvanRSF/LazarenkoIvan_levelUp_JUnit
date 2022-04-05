package suite.classes.calculator;

import junit.calc.tests.MultCalcTest;
import junit.calc.tests.SumCalcTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@SelectClasses({SumCalcTest.class, MultCalcTest.class})
@Suite
public class SumAndMultCalcSuite {
}
