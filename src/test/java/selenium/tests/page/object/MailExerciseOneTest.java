package selenium.tests.page.object;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.tests.SeleniumBasePage;

public class MailExerciseOneTest extends SeleniumBasePage {

    @Test
    public void simpleTest() {
        //Войти в почту
        MailLoggingIn loggingIn = new MailLoggingIn(driver);
        loggingIn.loggingIn("Junittestmail@mail.ru", "RaueAi^IpP12");

        //Убедиться, что вход осуществлен успешно
        WebElement loggedUser = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//span[@class = 'ph-project__user-name svelte-1hiqrvn']")));
        Assertions.assertEquals(loggedUser.getText(), "Junittestmail@mail.ru".toLowerCase());
    }
}
