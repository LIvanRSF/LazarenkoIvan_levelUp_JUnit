package junit.homeworkthree.mail.helpfull.classes;

import junit.homeworkthree.mail.tests.AbstractBasePageMail;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateAndEditLetterMail extends AbstractBasePageMail {

    String subjectAttribute = "value";
    String recipientAttribute = "title";

    public CreateAndEditLetterMail(WebDriver driver) {
        super(driver);
    }

    public void createLetter(String recipient, String subject, String mailTextContent) {
        wait.until(ExpectedConditions.elementToBeClickable(
            By.cssSelector("span[class='compose-button__txt']")))
            .click();
        wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//*[@class='head_container--3W05z'] "
                + "//input[@class='container--H9L5q size_s--3_M-_ dark--7GF6F']")))
            .sendKeys(recipient);
        wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//input[@class='container--H9L5q size_s--3_M-_ dark--7GF6F'][@name='Subject']")))
            .sendKeys(subject);
        wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//div[@role='textbox']")))
            .sendKeys(mailTextContent);
    }

    public String getRecipientOnEditLetterWindow() {
        String recipientInDraft = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//div[@class='contactsContainer--3RMuQ']//span[contains(@class,'text')]"))).getText();
        return recipientInDraft;
    }

    public String getSubjectOnEditLetterWindow() {
        String subjectInDraft = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//div[@class='subject__wrapper--2mk6m']//input"))).getAttribute(subjectAttribute);
        return subjectInDraft;
    }

    public String getMailTextContentOnEditLetterWindow() {
        String textContentInDraft = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//div[contains(@class,'editable-container-')]//div[contains(@class,'cl')]/*[1]"))).getText();
        return textContentInDraft;
    }

    public String getRecipientOnReadLetterWindow() {
        String recipientInReadLetterWindow = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.cssSelector("div[class='letter__recipients letter__recipients_short'] span[class='letter-contact']")))
                                                 .getAttribute(recipientAttribute);
        return recipientInReadLetterWindow;
    }

    public String getSubjectOnReadLetterWindow() {
        String subjectInReadLetterWindow = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.cssSelector("h2[class='thread-subject']"))).getText();
        return subjectInReadLetterWindow;
    }

    public String getMailTextContentOnReadLetterWindow() {
        String textContentInReadLetterWindow = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//div[contains(@class,'cl_')]/*"))).getText();
        return textContentInReadLetterWindow;
    }

    public void deleteLetter() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body[class]"))).sendKeys(Keys.DELETE);
    }
}
