package junit.mail.selenium.tests;

import junit.mail.selenium.tests.mail.page.object.MailAuthorized;
import junit.mail.selenium.tests.mail.page.object.MailCreateAndEditLetter;
import junit.mail.selenium.tests.mail.page.object.MailLoggingInAndOut;
import junit.mail.selenium.tests.mail.page.object.folders.MailDraftsFolder;
import junit.mail.selenium.tests.mail.page.object.folders.MailSentFolder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

public class MailExerciseOneTest extends SeleniumBasePage {

    @Test
    public void firstTaskTest() {
        String login = "junittestmail@mail.ru";
        String password = "RaueAi^IpP12";
        String recipient = "fallouttoday@mail.ru";
        String subject = "Письмо из черновика";
        String mailTextContent = "Лети скорей, родная почта: письмо для теста - это срочно!";

        //Войти в почту
        MailLoggingInAndOut logging = new MailLoggingInAndOut(driver);
        logging.loggingIn(login, password);

        //Убедиться, что вход осуществлен успешно
        MailAuthorized loggedUser = new MailAuthorized(driver);
        WebElement user = loggedUser.loggedUser();
        Assertions.assertEquals(user.getText(), login.toLowerCase());

        //Создать письмо, заполнить тему, адресата, тело
        MailCreateAndEditLetter letter = new MailCreateAndEditLetter(driver);
        letter.createLetter(recipient, subject, mailTextContent);

        //Сохранить его как черновик
        letter.editLetterWindow().saveInDraft();
        letter.editLetterWindow().closeLetterWindow();

        //Перейти в папку Черновики
        MailDraftsFolder drafts = new MailDraftsFolder(driver);
        drafts.clickDraftsFolderButton();

        //Verify, что письмо сохранено в черновиках
        var draftsFolderIsNotEmpty = drafts.draftsFolderIsNotEmpty();
        Assertions.assertTrue(draftsFolderIsNotEmpty);
        //Открыть черновик
        drafts.clickOnDraftInFolder();

        //Verify контент, адресата и тему письма
        String recipientInDraft = drafts.editLetterWindow().getRecipient();
        Assertions.assertEquals(recipientInDraft, recipient);

        String subjectInDraft = drafts.editLetterWindow().getSubject();
        Assertions.assertEquals(subjectInDraft, subject);

        String textContentInDraft = drafts.editLetterWindow().getMailTextContent();
        Assertions.assertEquals(textContentInDraft, mailTextContent);

        //Отправить письмо, нажав кнопку "отправить"
        letter.editLetterWindow().sendNotEmptyLetter();

        //verify, что письмо исчезло из черновиков
        var draftsFolderIsEmpty = drafts.draftsFolderIsEmpty();
        Assertions.assertTrue(draftsFolderIsEmpty);

        //Verify, что письмо появилось в папке отправленные
        MailSentFolder sent = new MailSentFolder(driver);
        sent.clickSentFolderButton();
        var sentFolderIsNotEmpty = sent.sentFolderIsNotEmpty();
        Assertions.assertTrue(sentFolderIsNotEmpty);

        //Выйти из учётной записи
        logging.loggingOut();
    }
}
