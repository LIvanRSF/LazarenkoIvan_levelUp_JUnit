package suite.classes.mail;

import junit.homeworkthree.mail.tests.FirstTaskMailHomeWork;
import junit.homeworkthree.mail.tests.SecondTaskMailHomeWork;
import junit.homeworkthree.mail.tests.ThirdTaskMailHomeWork;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@SelectClasses({FirstTaskMailHomeWork.class, SecondTaskMailHomeWork.class, ThirdTaskMailHomeWork.class})
@Suite
public class MailProceduralAllExercisesSuite {
}
