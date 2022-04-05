package junit.mail.selenium.tests.mail.page.object.folders;

import junit.mail.selenium.tests.mail.page.object.MailAbstractBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MailDraftsFolder extends MailAbstractBasePage {

    @FindBy(css = ("a[href='/drafts/']"))
    private WebElement draftsFolderButton;

    @FindBy(xpath = ("//*[contains(@href,'/drafts/0')]"))
    private WebElement draftInFolder;

    public MailDraftsFolder(WebDriver driver) {
        super(driver);
    }

    public void clickDraftsFolderButton() {
        wait.until(ExpectedConditions.elementToBeClickable(draftsFolderButton)).click();
    }

    public void clickOnDraftInFolder() {
        wait.until(ExpectedConditions.elementToBeClickable(draftInFolder)).click();
    }

    public boolean draftsFolderIsNotEmpty() {
        try {
            var draftsInFolder = wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(
                By.xpath("//*[contains(@href,'/drafts/0')]"), 0));
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    public boolean draftsFolderIsEmpty() {
        try {
            var draftsInFolder = wait.until(ExpectedConditions.numberOfElementsToBeLessThan(
                By.xpath("//*[contains(@href,'/drafts/0')]"), 1));
            return true;
        } catch (Exception exception) {
            return false;
        }
    }
}
