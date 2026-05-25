package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.File;

public class BaseTest {
    protected WebDriver driver;
    protected String baseUrl;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        // options.addArguments("--headless"); // Uncomment to run without UI
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        // Path to the frontend index.html
        File file = new File("../frontend/index.html");
        baseUrl = "file:///" + file.getAbsolutePath();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public void navigateTo(String page) {
        File file = new File("../frontend/" + page);
        driver.get("file:///" + file.getAbsolutePath());
    }
}
