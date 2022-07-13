package suite.classes.mail;

import junit.mail.selenium.tests.MailExerciseOneTest;
import junit.mail.selenium.tests.MailExerciseThreeTest;
import junit.mail.selenium.tests.MailExerciseTwoTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@SelectClasses({MailExerciseOneTest.class, MailExerciseTwoTest.class, MailExerciseThreeTest.class})
@Suite
public class MailPageObjectAllExercisesSuite {
}
