package junit.mail.selenium.tests.mail.page.object;

import org.openqa.selenium.WebDriver;

public class MailIndexPage extends MailAbstractBasePage {

    public MailIndexPage(WebDriver driver) {

        super(driver);
    }

    public void open() {
        open("");
    }
}
