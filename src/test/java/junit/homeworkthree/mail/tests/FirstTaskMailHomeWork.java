package junit.homeworkthree.mail.tests;

import junit.homeworkthree.BaseSeleniumClass;
import junit.homeworkthree.mail.helpfull.classes.CreateAndEditLetterMail;
import junit.homeworkthree.mail.helpfull.classes.LoggingInAndOutMail;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FirstTaskMailHomeWork extends BaseSeleniumClass {

    String accountName = "junittestmail@mail.ru";
    String password = "RaueAi^IpP12";
    String recipient = "fallouttoday@mail.ru";
    String subject = "Письмо из черновика";
    String mailTextContent = "Лети скорей, родная почта: письмо для теста - это срочно!";

    @Test
    public void firstExercise() {

        //Войти в почту
        var loggingIn = new LoggingInAndOutMail(driver);
        loggingIn.loggingIn(accountName, password);

        //Убедиться, что вход осуществлен успешно
        WebElement user = loggingIn.getAuthorizedUser();
        Assertions.assertEquals(accountName.toLowerCase(), user.getText());

        //Создать письмо, заполнить тему, адресата, тело
        CreateAndEditLetterMail letter = new CreateAndEditLetterMail(driver);
        letter.createLetter(recipient, subject, mailTextContent);

        //Сохранить его как черновик
        wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("span[data-title-shortcut='Ctrl+S']")))
            .click();
        wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("button[type='button'][tabindex='700']")))
            .click();

        //Перейти в папку Черновики
        wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("a[href='/drafts/']")))
            .click();

        //Verify, что письмо сохранено в черновиках
        var draftsFolderIsNotEmpty = draftsFolderIsNotEmpty();
        Assertions.assertTrue(draftsFolderIsNotEmpty);
        //Открыть черновик
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[contains(@href,'/drafts/0')]")))
            .click();

        //Verify контент, адресата и тему письма
        String recipientInDraft = letter.getRecipientOnEditLetterWindow();
        Assertions.assertEquals(recipient, recipientInDraft);

        String subjectInDraft = letter.getSubjectOnEditLetterWindow();
        Assertions.assertEquals(subject, subjectInDraft);

        String textContentInDraft = letter.getMailTextContentOnEditLetterWindow();
        Assertions.assertEquals(mailTextContent, textContentInDraft);

        //Отправить письмо, нажав кнопку "отправить"
        wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("span[data-title-shortcut='Ctrl+Enter']")))
            .click();
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[contains(@class,'button2_close')]")))
            .click();

        //verify, что письмо исчезло из черновиков
        var draftsFolderIsEmpty = draftsFolderIsEmpty();
        Assertions.assertTrue(draftsFolderIsEmpty);

        //Verify, что письмо появилось в папке отправленные
        wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("a[href='/sent/']")))
            .click();
        var sentFolderIsNotEmpty = sentFolderIsNotEmpty();
        Assertions.assertTrue(sentFolderIsNotEmpty);

        //Выйти из учётной записи
        loggingIn.loggingOut();
    }

    public boolean draftsFolderIsNotEmpty() {
        try {
            wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(
                By.xpath("//*[contains(@href,'/drafts/0')]"), 0));
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    public boolean draftsFolderIsEmpty() {
        try {
            wait.until(ExpectedConditions.numberOfElementsToBeLessThan(
                By.xpath("//*[contains(@href,'/drafts/0')]"), 1));
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    public boolean sentFolderIsNotEmpty() {
        try {
            wait.until(ExpectedConditions
                .numberOfElementsToBeMoreThan(By.xpath("//a[contains(@href,'/sent/1')]"), 0));
            return true;
        } catch (Exception exception) {
            return false;
        }
    }
}
