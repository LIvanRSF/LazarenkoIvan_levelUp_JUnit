package suite.classes.calculator;

import junit.calc.tests.BooleanCalcTest;
import junit.calc.tests.PowSqrtCalcTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@SelectClasses({BooleanCalcTest.class, PowSqrtCalcTest.class})
@Suite
public class OtherFuncCalcSuite {
}
