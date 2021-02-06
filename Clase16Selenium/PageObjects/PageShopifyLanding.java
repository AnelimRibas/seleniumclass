package Clase16Selenium.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageShopifyLanding extends BaseUITest {

    //public WebDriver driver;

    public PageShopifyLanding(WebDriver driver){

        this.driver = driver;
    }

   public PageShopifyLogin goToLogin(){

        driver.navigate().to("https://accounts.shopify.com/store-login");

        PageShopifyLogin pageShopifyLogin = new PageShopifyLogin(driver);
        return pageShopifyLogin;

    }

    public PageShopifyPricing goToPricing(){

        driver.findElement(By.xpath("(//*[@href='/pricing'])[1]")).click();

        PageShopifyPricing pageShopifyPricing = new PageShopifyPricing(driver);
        return pageShopifyPricing;


    }



}
