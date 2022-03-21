package selenium.tests.page.object;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MailSearchResultPage extends MailAbstractBasePage {

    @FindBy(xpath = ("//div[contains(@class, 'y8h')]"))
    private List<WebElement> products;

    public MailSearchResultPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getProductTitles() {
        List<String> productTitles = new ArrayList<>();

        for (int i = 0; i < products.size(); i++) {
            productTitles.add(products.get(i).getText());
        }

        return productTitles;
    }
}
