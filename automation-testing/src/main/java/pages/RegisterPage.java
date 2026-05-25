package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {

    @FindBy(id = "name")
    private WebElement nameInput;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "confirm-password")
    private WebElement confirmPasswordInput;

    @FindBy(css = "button[type='submit']")
    private WebElement registerButton;

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void register(String name, String email, String password, String confirmPassword) {
        type(nameInput, name);
        type(emailInput, email);
        type(passwordInput, password);
        type(confirmPasswordInput, confirmPassword);
        click(registerButton);
    }
}
