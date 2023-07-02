package testScripts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

public class BaseTest {

    public WebDriver driver;

    public WebDriver getDriver() {
        this.driver = driver;
        return driver;
    }
    @BeforeSuite
    public void startBrowser() throws IOException{
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in/");




    }

    @AfterSuite
    public void closeBrowser(){
        driver.quit();
    }
}

