package junit.mail.selenium.tests.mail.page.object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MailCreateAndEditLetter extends MailAbstractBasePage {

    @FindBy(css = ("span[class='compose-button__txt']"))
    private WebElement createLetterButton;

    @FindBy(xpath = ("//*[@class='head_container--3W05z'] "
        + "//input[@class='container--H9L5q size_s--3_M-_ dark--7GF6F']"))
    private WebElement addressOfRecipient;

    @FindBy(xpath = ("//input[@class='container--H9L5q size_s--3_M-_ dark--7GF6F'][@name='Subject']"))
    private WebElement nameOfSubject;

    @FindBy(xpath = ("//div[@role='textbox']"))
    private WebElement contentOfLatter;

    public MailCreateAndEditLetter(WebDriver driver) {
        super(driver);
    }

    public void createLetter(String recipient, String subject, String mailTextContent) {
        wait.until(ExpectedConditions.elementToBeClickable(createLetterButton))
            .click();
        wait.until(ExpectedConditions.elementToBeClickable(addressOfRecipient))
            .sendKeys(recipient);
        wait.until(ExpectedConditions.elementToBeClickable(nameOfSubject))
            .sendKeys(subject);
        wait.until(ExpectedConditions.elementToBeClickable(contentOfLatter))
            .sendKeys(mailTextContent);
    }
}
