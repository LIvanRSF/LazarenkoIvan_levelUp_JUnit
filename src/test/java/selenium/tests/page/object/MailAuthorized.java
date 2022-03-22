package selenium.tests.page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MailAuthorized extends MailIndexPage {

    public MailAuthorized(WebDriver driver) {
        super(driver);
    }

    public WebElement loggedUser() {
        WebElement loggedUser = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//span[@class = 'ph-project__user-name svelte-1hiqrvn']")));
        return loggedUser;
    }

    public void createLetter(String recipient, String subject, String mailTextContent) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text() = 'Написать письмо']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
                "//*[@class='head_container--3W05z'] " + "//input[@class='container--H9L5q size_s--3_M-_ dark--7GF6F']")))
            .sendKeys(recipient);
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//input[@class='container--H9L5q size_s--3_M-_ dark--7GF6F'][@name='Subject']")))
            .sendKeys(subject);
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[contains(@class,'editable-byb8')]/*/*")))
            .sendKeys(mailTextContent);
        wait.until((ExpectedConditions.elementToBeClickable(
            By.xpath("//span[text() = 'Написать письмо']")))).click();
    }
}
