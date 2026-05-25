package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MenuPage;
import pages.RegisterPage;

public class EndToEndTest extends BaseTest {

    @Test
    public void testFullOrderFlow() {
        // 1. Register
        navigateTo("register.html");
        RegisterPage regPage = new RegisterPage(driver);
        regPage.register("QA Tester", "qa@example.com", "secure123", "secure123");
        
        // Browser alert handling (simple alert is used in frontend)
        driver.switchTo().alert().accept();

        // 2. Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("qa@example.com", "secure123");

        // 3. Add to Cart
        MenuPage menuPage = new MenuPage(driver);
        menuPage.addFirstItemToCart();
        driver.switchTo().alert().accept();
        
        Assert.assertEquals(menuPage.getCartCount(), "Cart (1)");

        // 4. Logout
        menuPage.logout();
        Assert.assertTrue(driver.getCurrentUrl().contains("login.html"), "Logout failed");
    }
}
