package junit.mail.selenium.tests.mail.page.object;

import java.time.Duration;
import junit.mail.selenium.tests.mail.page.object.components.ComponentEditLetterWindow;
import junit.mail.selenium.tests.mail.page.object.components.ComponentReadLetterWindow;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class MailAbstractBasePage {

    private static final String SITE_URL = "https://mail.ru/";

    protected WebDriver driver;
    protected WebDriverWait wait;

    protected ComponentEditLetterWindow editLetterWindow;
    protected ComponentReadLetterWindow readLetterWindow;

    public MailAbstractBasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
        editLetterWindow = new ComponentEditLetterWindow(driver);
        readLetterWindow = new ComponentReadLetterWindow(driver);
    }

    public void open(String relativePageUrl) {
        driver.navigate().to(SITE_URL + relativePageUrl);
    }

    public ComponentEditLetterWindow editLetterWindow() {
        return editLetterWindow;
    }

    public ComponentReadLetterWindow readLetterWindow() {
        return readLetterWindow;
    }
}
