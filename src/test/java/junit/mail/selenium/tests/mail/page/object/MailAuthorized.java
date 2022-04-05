package junit.mail.selenium.tests.mail.page.object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MailAuthorized extends MailIndexPage {

    @FindBy(xpath = ("//span[@class = 'ph-project__user-name svelte-1hiqrvn']"))
    private WebElement authorizedUser;

    public MailAuthorized(WebDriver driver) {
        super(driver);
    }

    public WebElement loggedUser() {
        WebElement loggedUser = wait.until(ExpectedConditions.visibilityOf(authorizedUser));
        return loggedUser;
    }
}
