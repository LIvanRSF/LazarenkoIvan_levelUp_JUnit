package junit.homeworkthree.mail.tests;

import java.time.Duration;
import junit.homeworkthree.BaseSeleniumClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractBasePageMail extends BaseSeleniumClass {

    private static final String SITE_URL = "https://mail.ru/";

    protected WebDriver driver;
    protected WebDriverWait wait;

    public AbstractBasePageMail(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void open(String relativePageUrl) {
        driver.navigate().to(SITE_URL + relativePageUrl);
    }
}
