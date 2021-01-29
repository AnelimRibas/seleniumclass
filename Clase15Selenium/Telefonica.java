package Clase15Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Telefonica {

    public WebDriver driver;
    public WebDriverWait wait;

    public Telefonica(WebDriver driver, WebDriverWait wait){

        this.driver = driver;
        this.wait = wait;
    }

    public String getTitle(){
        return driver.getTitle();
    }

    public String getUrl(){
        return driver.getCurrentUrl();
    }


    public void clickMessagePolicy(){

        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
    }

    public FrameTelefonica switchFrame(){

        driver.switchTo().frame("euroland-ticker-es");

        FrameTelefonica frameTelefonica = new FrameTelefonica(driver,wait);
        return frameTelefonica;

    }




}
