package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class SearchProductPage extends BasePage {

    By Searchbox = By.xpath("//input[@id='twotabsearchtextbox']");
    By SearchButton = By.id("nav-search-submit-button");
    By SearchResult = By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']//span[contains(text(),'Fossil watches for women')]");
    By WatchResult = By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]");
    By AddToCart_button = By.xpath("//input[@id='add-to-cart-button']");
    By Cart_icon=By.xpath("//span[@class='nav-cart-icon nav-sprite']");
    By Cart_product=By.xpath("//span[@class='a-truncate-cut']");
    By Success_Msg=By.xpath("//span[@class='a-size-medium-plus a-color-base sw-atc-text a-text-bold']");

    public SearchProductPage(WebDriver driver) {
        super(driver);
    }

    public void SearchProduct() {
        //waitForPresenceOfWebElement(Searchbox);
        click(Searchbox);
        entertext(Searchbox, "Fossil Watch for Women");
        click(SearchButton);
        ScrollPageDown();
        waitForPresenceOfWebElement(WatchResult);

    }

    public void ClearPreviousSearchResult(){
        waitForPresenceOfWebElement(Searchbox);
        cleartext(Searchbox);
    }

    public String ValidateSearchResult() throws InterruptedException {
        return getText(WatchResult);


    }


    public void GoToProduct() {
        click(WatchResult);

        switchWindow(AddToCart_button);

    }
    public void AddProductToCart(){
        click(AddToCart_button);

    }
    public void ClickOnCartIcon() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        click(Cart_icon);


    }


    public String ValidateAddedToCartMsg(){
        //driver.navigate().refresh();
        waitForPresenceOfWebElement(Success_Msg);
        return getText(Success_Msg);


//        if (getText(Success_Msg).contains("Added to Cart")){
//           System.out.println("Product Successfully added to cart");}
//

//        if (getText(Cart_product).contains("Watch")){
//            System.out.println("Product Successfully added to cart");
//        }

    }



}

