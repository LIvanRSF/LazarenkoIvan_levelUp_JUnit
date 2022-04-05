package junit.mail.selenium.tests;

import junit.mail.selenium.tests.mail.page.object.MailAuthorized;
import junit.mail.selenium.tests.mail.page.object.MailCreateAndEditLetter;
import junit.mail.selenium.tests.mail.page.object.MailLoggingInAndOut;
import junit.mail.selenium.tests.mail.page.object.folders.MailSentFolder;
import junit.mail.selenium.tests.mail.page.object.folders.MailTestFolder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

public class MailExerciseTwoTest extends SeleniumBasePage {

    @Test
    public void secondTaskTest() {

        String login = "junittestmail@mail.ru";
        String password = "RaueAi^IpP12";
        String recipient = login;   //письмо себе
        String subject = "Письмо себе Тест";
        String mailTextContent = "Несмотря на дождь и грязь - мы налаживаем связь!";

        //Войти в почту
        MailLoggingInAndOut logging = new MailLoggingInAndOut(driver);
        logging.loggingIn(login, password);

        //Убедиться, что вход осуществлен успешно
        MailAuthorized loggedUser = new MailAuthorized(driver);
        WebElement user = loggedUser.loggedUser();
        Assertions.assertEquals(user.getText(), login.toLowerCase());

        //Создать новое письмо (заполнить адресата (самого себя),
        // тему письма (должно содержать слово Тест) и тело)
        MailCreateAndEditLetter letter = new MailCreateAndEditLetter(driver);
        letter.createLetter(recipient, subject, mailTextContent);

        // отправить письмо
        letter.editLetterWindow().sendNotEmptyLetter();

        //Verify, что письмо появилось в папке отправленные
        MailSentFolder sent = new MailSentFolder(driver);
        sent.clickSentFolderButton();
        var sentFolderIsNotEmpty = sent.sentFolderIsNotEmpty();
        Assertions.assertTrue(sentFolderIsNotEmpty);

        //Verify, что письмо появилось в папке «Тест»
        var testFolder = new MailTestFolder(driver);
        testFolder.clickTestFolderButton();
        var testLettersFolderIsNotEmpty = testFolder.testFolderIsNotEmpty();
        Assertions.assertTrue(testLettersFolderIsNotEmpty);

        //Открыть письмо в папке Тест
        testFolder.clickOnTestLetterInFolder();

        //Verify контент, адресата и тему письма
        String recipientInTestLetter = testFolder.readLetterWindow().getRecipient();
        Assertions.assertEquals(recipient, recipientInTestLetter);

        String subjectInTestLetter = testFolder.readLetterWindow().getSubject();
        Assertions.assertEquals(subject, subjectInTestLetter);

        String textContentInTestLetter = testFolder.readLetterWindow().getMailTextContent();
        Assertions.assertEquals(mailTextContent, textContentInTestLetter);

        //Выйти из учётной записи
        logging.loggingOut();
    }
}
