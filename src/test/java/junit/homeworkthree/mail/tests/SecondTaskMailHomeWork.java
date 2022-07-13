package junit.homeworkthree.mail.tests;

import junit.homeworkthree.BaseSeleniumClass;
import junit.homeworkthree.mail.helpfull.classes.CreateAndEditLetterMail;
import junit.homeworkthree.mail.helpfull.classes.LoggingInAndOutMail;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SecondTaskMailHomeWork extends BaseSeleniumClass {

    String accountName = "junittestmail@mail.ru";
    String password = "RaueAi^IpP12";
    String recipient = accountName; //письмо себе
    String subject = "Письмо себе Тест";
    String mailTextContent = "Несмотря на дождь и грязь - мы налаживаем связь!";

    @Test
    public void secondExercise() {

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

        // //Verify, что письмо появилось в папке отправленные
        wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("a[href='/sent/']")))
            .click();
        var sentFolderIsNotEmpty = sentFolderIsNotEmpty();
        Assertions.assertTrue(sentFolderIsNotEmpty);

        //Verify, что письмо появилось в папке «Тест»
        wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("a[href='/1/']")))
            .click();
        var testLettersFolderIsNotEmpty = testFolderIsNotEmpty();
        Assertions.assertTrue(testLettersFolderIsNotEmpty);

        //Открыть письмо в папке Тест
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[contains(@href,'/1/1')]")))
            .click();

        //Verify контент, адресата и тему письма
        String recipientInDraft = letter.getRecipientOnReadLetterWindow();
        Assertions.assertEquals(recipient, recipientInDraft);

        String subjectInDraft = letter.getSubjectOnReadLetterWindow();
        Assertions.assertEquals(subject, subjectInDraft);

        String textContentInDraft = letter.getMailTextContentOnReadLetterWindow();
        Assertions.assertEquals(mailTextContent, textContentInDraft);

        //Выйти из учётной записи
        loggingIn.loggingOut();
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

    public boolean testFolderIsNotEmpty() {
        try {
            var draftsInFolder = wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(
                By.xpath("//*[contains(@href,'/1/1')]"), 0));
            return true;
        } catch (Exception exception) {
            return false;
        }
    }
}
