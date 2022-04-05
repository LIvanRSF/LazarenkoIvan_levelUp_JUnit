package junit.mail.selenium.tests.mail.page.object.folders;

import junit.mail.selenium.tests.mail.page.object.MailAbstractBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MailInboxFolder extends MailAbstractBasePage {

    @FindBy(css = ("a[href='/inbox/']"))
    private WebElement inboxFolderButton;

    @FindBy(xpath = ("//*[contains(@href,'/inbox/1')]"))
    private WebElement inboxLetterInFolder;

    public MailInboxFolder(WebDriver driver) {
        super(driver);
    }

    public void clickInboxFolderButton() {
        wait.until(ExpectedConditions.elementToBeClickable(inboxFolderButton)).click();
    }

    public void clickOnInboxLetterInFolder() {
        wait.until(ExpectedConditions.elementToBeClickable(inboxLetterInFolder)).click();
    }

    public boolean inboxFolderIsNotEmpty() {
        try {
            var draftsInFolder = wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(
                By.xpath("//*[contains(@href,'/inbox/1')]"), 0));
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    public boolean inboxFolderIsEmpty() {
        try {
            var draftsInFolder = wait.until(ExpectedConditions.numberOfElementsToBeLessThan(
                By.xpath("//*[contains(@href,'/inbox/1')]"), 1));
            return true;
        } catch (Exception exception) {
            return false;
        }
    }
}
