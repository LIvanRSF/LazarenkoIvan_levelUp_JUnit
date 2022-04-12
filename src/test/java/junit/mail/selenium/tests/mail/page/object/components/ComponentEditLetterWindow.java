package junit.mail.selenium.tests.mail.page.object.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ComponentEditLetterWindow extends AbstractComponentsBasePage {

    @FindBy(xpath = ("//span[contains(@class,'button2_close')]"))
    private WebElement closeAfterSentFrameButton;

    @FindBy(css = ("span[data-title-shortcut='Ctrl+Enter']"))
    private WebElement sendLetterButton;

    @FindBy(xpath = ("//div[@class='contactsContainer--3RMuQ']//span[contains(@class,'text')]"))
    private WebElement recipient;

    @FindBy(xpath = ("//div[@class='subject__wrapper--2mk6m']//input"))
    private WebElement subject;

    @FindBy(xpath = ("//div[contains(@class,'editable-container-')]//div[contains(@class,'cl')]/*[1]"))
    private WebElement textContent;

    @FindBy(css = ("span[data-title-shortcut='Ctrl+S']"))
    private WebElement saveInDraftButton;

    @FindBy(css = ("button[type='button'][tabindex='700']"))
    private WebElement closeLetterWindowButton;
    String subjectAttribute = "value";

    public ComponentEditLetterWindow(WebDriver driver) {
        super(driver);
    }

    public void sendNotEmptyLetter() {
        wait.until(ExpectedConditions.elementToBeClickable(sendLetterButton))
            .click();
        wait.until(ExpectedConditions.elementToBeClickable(closeAfterSentFrameButton))
            .click();
    }

    public String getRecipient() {
        String recipientInDraft = wait.until(ExpectedConditions.visibilityOf(recipient)).getText();
        return recipientInDraft;
    }

    public String getSubject() {
        String subjectInDraft = wait.until(ExpectedConditions.visibilityOf(subject)).getAttribute(subjectAttribute);
        return subjectInDraft;
    }

    public String getMailTextContent() {
        String textContentInDraft = wait.until(ExpectedConditions.visibilityOf(textContent)).getText();
        return textContentInDraft;
    }

    public void saveInDraft() {
        wait.until(ExpectedConditions.elementToBeClickable(saveInDraftButton))
            .click();
    }

    public void closeLetterWindow() {
        wait.until(ExpectedConditions.elementToBeClickable(closeLetterWindowButton))
            .click();
    }
}
