package junit.mail.selenium.tests.mail.page.object.components;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ComponentReadLetterWindow extends AbstractComponentsBasePage {

    @FindBy(css = ("div[class='letter__recipients letter__recipients_short'] span[class='letter-contact']"))
    private WebElement recipient;

    @FindBy(css = ("h2[class='thread-subject']"))
    private WebElement subject;

    @FindBy(xpath = ("//div[contains(@class,'cl_')]/*"))
    private WebElement textContent;

    String recipientAttribute = "title";

    public ComponentReadLetterWindow(WebDriver driver) {
        super(driver);
    }

    public String getRecipient() {
        String recipientInReadLetterWindow = wait.until(ExpectedConditions.visibilityOf(recipient))
                                                 .getAttribute(recipientAttribute);
        return recipientInReadLetterWindow;
    }

    public String getSubject() {
        String subjectInReadLetterWindow = wait.until(ExpectedConditions.visibilityOf(subject)).getText();
        return subjectInReadLetterWindow;
    }

    public String getMailTextContent() {
        String textContentInReadLetterWindow = wait.until(ExpectedConditions.visibilityOf(textContent)).getText();
        return textContentInReadLetterWindow;
    }

    public void deleteLetter() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body[class]"))).sendKeys(Keys.DELETE);
    }
}
