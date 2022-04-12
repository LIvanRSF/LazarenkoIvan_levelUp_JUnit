package junit.mail.selenium.tests.mail.page.object.folders;

import junit.mail.selenium.tests.mail.page.object.MailAbstractBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MailRecycleBinFolder extends MailAbstractBasePage {

    @FindBy(css = ("a[href='/trash/']"))
    private WebElement recycleBinFolderButton;

    public MailRecycleBinFolder(WebDriver driver) {
        super(driver);
    }

    public void clickRecycleBinFolderButton() {
        wait.until(ExpectedConditions.elementToBeClickable(recycleBinFolderButton)).click();
    }

    public boolean recycleBinFolderIsNotEmpty() {
        try {
            var draftsInFolder = wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(
                By.xpath("//*[contains(@href,'/trash/1')]"), 0));
            return true;
        } catch (Exception exception) {
            return false;
        }
    }
}
