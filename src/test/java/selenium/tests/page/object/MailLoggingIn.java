package selenium.tests.page.object;

import java.util.Locale;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MailLoggingIn extends MailIndexPage {

    @FindBy(xpath = ("//*[@id = 'grid:middle'] //button[text() = 'Войти']"))
    private WebElement logInButton;

    @FindBy(css = ("#login-content input[name='username']"))
    private WebElement accountNameField;

    @FindBy(xpath = ("//span[text() = 'Ввести пароль']"))
    private WebElement enterPasswordButton;

    @FindBy(xpath = ("//input[@placeholder = 'Пароль']"))
    private WebElement passwordField;

    @FindBy(xpath = ("//span[text() = 'Войти']"))
    private WebElement submitEnterButton;

    public MailLoggingIn(WebDriver driver) {
        super(driver);
    }

    public void loggingIn(String accountName, String password) {
        open();
        //Нажимаем кнопку "Войти" на главной странице
        wait.until(ExpectedConditions.elementToBeClickable(logInButton)).click();
        //Переключаемся на фрейм авторизации
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(
            By.cssSelector("iframe.ag-popup__frame__layout__iframe")));
        //Передаем логин
        wait.until(ExpectedConditions.visibilityOf(accountNameField)).sendKeys(accountName);
        wait.until(ExpectedConditions.elementToBeClickable(enterPasswordButton)).click();
        //Передаем пароль
        wait.until(ExpectedConditions.visibilityOf(passwordField)).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(submitEnterButton)).click();

        System.out.println(driver.getCurrentUrl());
        //Убеждаемся, что вход выполнен успешно
        WebElement loggedUser = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//span[@class = 'ph-project__user-name svelte-1hiqrvn']")));
        Assertions.assertEquals(loggedUser.getText(), accountName.toLowerCase());
    }
}
