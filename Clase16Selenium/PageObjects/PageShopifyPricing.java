package Clase16Selenium.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PageShopifyPricing extends BaseUITest {

    //WebDriver driver;

    public PageShopifyPricing(WebDriver driver){
        this.driver = driver;

    }


    public List<WebElement> searchListH1(){
        List<WebElement> ElemH1 = driver.findElements(By.tagName("H1"));
        return ElemH1;
    }

}
