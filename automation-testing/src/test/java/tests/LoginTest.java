package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void testValidLogin() {
        navigateTo("login.html");
        LoginPage loginPage = new LoginPage(driver);
        
        // Note: Assumes a user is registered or we use a pre-registered one.
        // For local storage, we might need to register first in the same session.
        loginPage.login("test@example.com", "password123");
        
        // Assert redirected to menu (in real app, check URL or a menu element)
        Assert.assertTrue(driver.getCurrentUrl().contains("menu.html"), "Login failed - not redirected to menu");
    }

    @Test
    public void testInvalidLogin() {
        navigateTo("login.html");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("wrong@example.com", "wrongpass");
        
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message NOT displayed for invalid login");
    }
}
