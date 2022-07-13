package junit.homeworkthree.mail.helpfull.classes;

import junit.homeworkthree.mail.tests.AbstractBasePageMail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoggingInAndOutMail extends AbstractBasePageMail {

    public LoggingInAndOutMail(WebDriver driver) {
        super(driver);
    }

    public void loggingIn(String accountName, String password) {
        //нажимаем кнопку "Войти" для авторизации
        wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("button[data-testid='enter-mail-primary']")))
            .click();
        //Переключаемся на фрейм авторизации
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(
            By.cssSelector("iframe.ag-popup__frame__layout__iframe")));
        //Передаем логин
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("#login-content input[name='username']")))
            .sendKeys(accountName);
        wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("button[data-test-id='next-button']")))
            .click();
        //Передаем пароль
        wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("input[name='password']")))
            .sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("button[data-test-id='submit-button']")))
            .click();
    }

    public WebElement getAuthorizedUser() {
        WebElement loggedUser = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//span[@class = 'ph-project__user-name svelte-1hiqrvn']")));
        return loggedUser;
    }

    public void loggingOut() {
        //заходим в меню аккаунта
        wait.until(ExpectedConditions.elementToBeClickable(
            By.cssSelector("div[class='ph-project ph-project__account svelte-1hiqrvn ph-project-any']")))
            .click();
        //выбираем "Выйти"
        wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//a[contains(@href,'//auth.mail.ru/cgi-bin/logout')]")))
            .click();
    }
}
