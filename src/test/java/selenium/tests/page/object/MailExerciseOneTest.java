package selenium.tests.page.object;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import selenium.tests.SeleniumBasePage;

public class MailExerciseOneTest extends SeleniumBasePage {

    @Test
    public void simpleTest() {
        String login = "Junittestmail@mail.ru";
        String password = "RaueAi^IpP12";

        //Войти в почту
        MailLoggingIn loggingIn = new MailLoggingIn(driver);
        loggingIn.loggingIn(login, password);

        //Убедиться, что вход осуществлен успешно
        MailAuthorized loggedUser = new MailAuthorized(driver);
        WebElement user = loggedUser.loggedUser();
        Assertions.assertEquals(user.getText(), login.toLowerCase());

        //Создать письмо, заполнить тему, адресата, тело + отправить
        loggedUser.createLetter("fallouttoday@mail.ru", "Testovoe1", "Привет, мир!");
    }
}
