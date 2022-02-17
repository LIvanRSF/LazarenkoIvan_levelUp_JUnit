package suite.classes;

import junit.calc.tests.DivCalcTest;
import junit.calc.tests.SubCalcTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@SelectClasses({SubCalcTest.class, DivCalcTest.class})
@Suite
public class SubAndDivideCalcSuite {
}
