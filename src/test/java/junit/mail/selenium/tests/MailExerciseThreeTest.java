package junit.mail.selenium.tests;

import junit.mail.selenium.tests.mail.page.object.MailAuthorized;
import junit.mail.selenium.tests.mail.page.object.MailCreateAndEditLetter;
import junit.mail.selenium.tests.mail.page.object.MailLoggingInAndOut;
import junit.mail.selenium.tests.mail.page.object.folders.MailInboxFolder;
import junit.mail.selenium.tests.mail.page.object.folders.MailRecycleBinFolder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

public class MailExerciseThreeTest extends SeleniumBasePage {

    @Test
    public void thirdTaskTest() {

        String login = "junittestmail@mail.ru";
        String password = "RaueAi^IpP12";
        String recipient = login;   //письмо себе
        String subject = "Письмо для удаления";
        String mailTextContent = "Лети скорей, родная почта: письмо для теста - это срочно!";

        //Войти в почту
        MailLoggingInAndOut logging = new MailLoggingInAndOut(driver);
        logging.loggingIn(login, password);

        //Assert, что вход выполнен успешно
        MailAuthorized loggedUser = new MailAuthorized(driver);
        WebElement user = loggedUser.loggedUser();
        Assertions.assertEquals(user.getText(), login.toLowerCase());

        //Создать новое письмо (заполнить адресата (самого себя), тему письма и тело)
        MailCreateAndEditLetter latter = new MailCreateAndEditLetter(driver);
        latter.createLetter(recipient, subject, mailTextContent);

        //Отправить письмо
        latter.editLetterWindow().sendNotEmptyLetter();

        //Verify, что письмо появилось в папке Входящие
        var inboxFolder = new MailInboxFolder(driver);
        var inboxFolderIsNotEmpty = inboxFolder.inboxFolderIsNotEmpty();
        Assertions.assertTrue(inboxFolderIsNotEmpty);

        //Verify контент, адресата и тему письма (должно совпадать с пунктом 3)
        inboxFolder.clickOnInboxLetterInFolder();

        String recipientInInboxLetter = inboxFolder.readLetterWindow().getRecipient();
        Assertions.assertEquals(recipient, recipientInInboxLetter);

        String subjectInInboxLetter = inboxFolder.readLetterWindow().getSubject();
        Assertions.assertEquals(subject, subjectInInboxLetter);

        String textContentInInboxLetter = inboxFolder.readLetterWindow().getMailTextContent();
        Assertions.assertEquals(mailTextContent, textContentInInboxLetter);

        //Удалить письмо
        inboxFolder.readLetterWindow().deleteLetter();

        //Verify что письмо появилось в папке Корзина
        var recycleBin = new MailRecycleBinFolder(driver);
        recycleBin.clickRecycleBinFolderButton();

        var recycleBinFolderIsNotEmpty = recycleBin.recycleBinFolderIsNotEmpty();
        Assertions.assertTrue(recycleBinFolderIsNotEmpty);

        //Выйти из учётной записи
        logging.loggingOut();
    }
}
