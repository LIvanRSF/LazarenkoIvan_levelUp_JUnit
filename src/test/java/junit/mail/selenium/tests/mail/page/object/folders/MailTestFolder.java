package junit.mail.selenium.tests.mail.page.object.folders;

import junit.mail.selenium.tests.mail.page.object.MailAbstractBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MailTestFolder extends MailAbstractBasePage {

    @FindBy(css = ("a[href='/1/']"))
    private WebElement testFolderButton;

    @FindBy(xpath = ("//*[contains(@href,'/1/1')]"))
    private WebElement testLetterInFolder;

    public MailTestFolder(WebDriver driver) {
        super(driver);
    }

    public void clickTestFolderButton() {
        wait.until(ExpectedConditions.elementToBeClickable(testFolderButton))
            .click();
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

    public void clickOnTestLetterInFolder() {
        wait.until(ExpectedConditions.elementToBeClickable(testLetterInFolder))
            .click();
    }
}
