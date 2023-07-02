package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;


public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;
    public JavascriptExecutor js;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        js= (JavascriptExecutor) driver;

    }

    public void waitForPresenceOfWebElement(By locator) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    public void entertext(By locator, String text) {
        driver.findElement(locator).sendKeys(text);


    }

    public void ScrollPageDown(){
        js.executeScript("window.scrollBy(0,200)");

    }

    public boolean isElementDisplayed(By locator) {
        return driver.findElement(locator).isDisplayed();
    }

    public void switchWindow(By locator) {
        String parent=driver.getWindowHandle();
        Set<String>s=driver.getWindowHandles();
        Iterator<String>I1=s.iterator();
        while(I1.hasNext()) {
            String childdwindow = I1.next();
            if (!parent.equals(childdwindow)) {
                driver.switchTo().window(childdwindow);
                System.out.println(driver.switchTo().window(childdwindow));
            }
        }

        //driver.switchTo().window(parent);


        }
    public void cleartext(By locator){
        driver.findElement(locator).clear();


        }




    }










