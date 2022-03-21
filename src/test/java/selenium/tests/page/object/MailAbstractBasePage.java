package selenium.tests.page.object;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class MailAbstractBasePage {

    private static final String SITE_URL = "https://mail.ru/";

    protected WebDriver driver;
    protected WebDriverWait wait;

    public MailAbstractBasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void open(String relativePageUrl) {

        driver.navigate().to(SITE_URL + relativePageUrl);
    }
}
