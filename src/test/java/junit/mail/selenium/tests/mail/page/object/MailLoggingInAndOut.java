package junit.mail.selenium.tests.mail.page.object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MailLoggingInAndOut extends MailIndexPage {

    @FindBy(css = ("button[data-testid='enter-mail-primary']"))
    private WebElement logInButton;

    @FindBy(css = ("#login-content input[name='username']"))
    private WebElement accountNameField;

    @FindBy(css = ("button[data-test-id='next-button']"))
    private WebElement enterPasswordButton;

    @FindBy(css = ("input[name='password']"))
    private WebElement passwordField;

    @FindBy(css = ("button[data-test-id='submit-button']"))
    private WebElement submitEnterButton;

    @FindBy(css = ("iframe.ag-popup__frame__layout__iframe"))
    private WebElement loginFrame;

    @FindBy(css = ("div[class='ph-project ph-project__account svelte-1hiqrvn ph-project-any']"))
    private WebElement accountIcon;

    @FindBy(xpath = ("//a[contains(@href,'//auth.mail.ru/cgi-bin/logout')]"))
    private WebElement logoutButton;

    public MailLoggingInAndOut(WebDriver driver) {
        super(driver);
    }

    public void loggingIn(String accountName, String password) {
        open();
        //Нажимаем кнопку "Войти" на главной странице
        wait.until(ExpectedConditions.elementToBeClickable(logInButton)).click();
        //Переключаемся на фрейм авторизации
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(loginFrame));
        //Передаем логин
        wait.until(ExpectedConditions.visibilityOf(accountNameField)).sendKeys(accountName);
        wait.until(ExpectedConditions.elementToBeClickable(enterPasswordButton)).click();
        //Передаем пароль
        wait.until(ExpectedConditions.visibilityOf(passwordField)).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(submitEnterButton)).click();
    }

    public void loggingOut() {
        //заходим в меню аккаунта
        wait.until(ExpectedConditions.elementToBeClickable(accountIcon)).click();
        //выбираем "Выйти"
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton)).click();
    }
}
