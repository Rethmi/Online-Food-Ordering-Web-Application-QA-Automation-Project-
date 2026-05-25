package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class MenuPage extends BasePage {

    @FindBy(css = ".product-card button")
    private List<WebElement> addToCartButtons;

    @FindBy(id = "cart-link")
    private WebElement cartLink;

    @FindBy(id = "logout-btn")
    private WebElement logoutButton;

    public MenuPage(WebDriver driver) {
        super(driver);
    }

    public void addFirstItemToCart() {
        if (!addToCartButtons.isEmpty()) {
            click(addToCartButtons.get(0));
        }
    }

    public void goToCart() {
        click(cartLink);
    }

    public void logout() {
        click(logoutButton);
    }

    public String getCartCount() {
        return cartLink.getText();
    }
}
