package junit.mail.selenium.tests.mail.page.object.folders;

import junit.mail.selenium.tests.mail.page.object.MailAbstractBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MailSentFolder extends MailAbstractBasePage {

    @FindBy(css = ("a[href='/sent/']"))
    private WebElement sentFolderButton;

    @FindBy(xpath = ("//*[contains(@href,'/sent/1')]"))
    private WebElement sentInFolder;

    public MailSentFolder(WebDriver driver) {
        super(driver);
    }


    public void clickSentFolderButton() {
        wait.until(ExpectedConditions.elementToBeClickable(sentFolderButton))
            .click();
    }

    public void clickOnDraftInFolder() {
        wait.until(ExpectedConditions.elementToBeClickable(sentInFolder))
            .click();
    }

    public boolean sentFolderIsNotEmpty() {
        try {
            var sentInFolder = wait.until(ExpectedConditions
                .numberOfElementsToBeMoreThan(By.xpath("//a[contains(@href,'/sent/1')]"), 0));
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    public boolean sentFolderIsEmpty() {
        try {
            var draftsInFolder = wait.until(ExpectedConditions.numberOfElementsToBeLessThan(
                By.xpath("//*[contains(@href,'/sent/1')]"), 1));
            return true;
        } catch (Exception exception) {
            return false;
        }
    }
}
