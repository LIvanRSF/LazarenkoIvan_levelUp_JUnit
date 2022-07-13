package junit.homeworkthree.mail.tests;

import junit.homeworkthree.BaseSeleniumClass;
import junit.homeworkthree.mail.helpfull.classes.CreateAndEditLetterMail;
import junit.homeworkthree.mail.helpfull.classes.LoggingInAndOutMail;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ThirdTaskMailHomeWork extends BaseSeleniumClass {

    String accountName = "junittestmail@mail.ru";
    String password = "RaueAi^IpP12";
    String recipient = accountName; //письмо себе
    String subject = "Письмо для удаления";
    String mailTextContent = "Лети скорей, родная почта: письмо для теста - это срочно!";

    @Test
    public void thirdExercise() {

        //Войти в почту
        var loggingIn = new LoggingInAndOutMail(driver);
        loggingIn.loggingIn(accountName, password);

        // //Убедиться, что вход осуществлен успешно
        WebElement user = loggingIn.getAuthorizedUser();
        Assertions.assertEquals(accountName.toLowerCase(), user.getText());

        //Создать новое письмо (заполнить адресата (самого себя),
        // тему письма (должно содержать слово Тест) и тело)
        CreateAndEditLetterMail letter = new CreateAndEditLetterMail(driver);
        letter.createLetter(recipient, subject, mailTextContent);

        // отправить письмо
        wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("span[data-title-shortcut='Ctrl+Enter']")))
            .click();
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[contains(@class,'button2_close')]")))
            .click();

        //Verify, что письмо появилось в папке Входящие
        var inboxFolderIsNotEmpty = inboxFolderIsNotEmpty();
        Assertions.assertTrue(inboxFolderIsNotEmpty);

        //Verify контент, адресата и тему письма (должно совпадать с пунктом 3)
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[contains(@href,'/inbox/1')]")))
            .click();

        String recipientInDraft = letter.getRecipientOnReadLetterWindow();
        Assertions.assertEquals(recipient, recipientInDraft);

        String subjectInDraft = letter.getSubjectOnReadLetterWindow();
        Assertions.assertEquals(subject, subjectInDraft);

        String textContentInDraft = letter.getMailTextContentOnReadLetterWindow();
        Assertions.assertEquals(mailTextContent, textContentInDraft);

        //Удалить письмо
        letter.deleteLetter();

        //Verify что письмо появилось в папке Корзина
        wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("a[href='/trash/']")))
            .click();

        var recycleBinFolderIsNotEmpty = recycleBinFolderIsNotEmpty();
        Assertions.assertTrue(recycleBinFolderIsNotEmpty);

        //Выйти из учётной записи
        loggingIn.loggingOut();
    }

    public boolean inboxFolderIsNotEmpty() {
        try {
            wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(
                By.xpath("//*[contains(@href,'/inbox/1')]"), 0));
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    public boolean recycleBinFolderIsNotEmpty() {
        try {
            wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(
                By.xpath("//*[contains(@href,'/trash/1')]"), 0));
            return true;
        } catch (Exception exception) {
            return false;
        }
    }
}
