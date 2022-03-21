package selenium.tests.page.object;

import org.openqa.selenium.WebDriver;

public class MailAuthorized extends MailIndexPage {

    public MailAuthorized(WebDriver driver) {
        super(driver);
        driver.navigate().to("https://calls.mail.ru/embed/p2p/?email=junittestmail%40mail.ru");
    }
}
