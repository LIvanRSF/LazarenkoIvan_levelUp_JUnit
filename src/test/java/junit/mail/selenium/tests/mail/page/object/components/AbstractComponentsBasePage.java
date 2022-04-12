package junit.mail.selenium.tests.mail.page.object.components;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponentsBasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public AbstractComponentsBasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }
}
