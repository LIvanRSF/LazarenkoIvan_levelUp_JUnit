package selenium.tests;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class SeleniumBasePage {

    protected WebDriver driver;

    @BeforeAll
    public static void beforeAll() {

        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    //    @AfterEach
    //    void tearDown() {
    //        driver.quit();
    //    }
}
