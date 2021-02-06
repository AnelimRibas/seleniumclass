package Clase16Selenium.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PageShopifyLogin extends BaseUITest {

    //public WebDriver driver;


    public PageShopifyLogin(WebDriver driver){
        this.driver = driver;
    }


    public List<WebElement> clicNextAndMessage(){

        driver.findElement(By.xpath("//button[@name='commit']")).click();

        WebElement alertMessage = driver.findElement(By.xpath("//span[contains(text(),'Dire')]"));

        List<WebElement> arrayAlertMessage = driver.findElements(By.className("validation-error__message"));

        return arrayAlertMessage;
    }
}
