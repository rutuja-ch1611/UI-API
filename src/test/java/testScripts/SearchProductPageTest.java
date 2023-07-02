package testScripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.SearchProductPage;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchProductPageTest extends BaseTest {

    SearchProductPage searchPage;
    @BeforeMethod
    public void initObject(){
        searchPage=new SearchProductPage(getDriver());
    }
    @Test
    public void SearchDesiredProduct() throws InterruptedException {
        searchPage.SearchProduct();
        searchPage.ValidateSearchResult();
        assertThat(searchPage.ValidateSearchResult().contains("Watch"));
        System.out.println("Search result is relevant");
        searchPage.GoToProduct();
        searchPage.AddProductToCart();
        assertThat(searchPage.ValidateAddedToCartMsg().contains("Added to Cart"));
        System.out.println("Product is successfully added to the cart");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));


        }


    }

