package clase13Selenium.practico13Ejercicio5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class utility {

    WebDriver driver;


    public utility (WebDriver remoteDriver){

    this.driver = remoteDriver;

    }

    public void fillEmail(){

        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("test@test.com");
        driver.findElement(By.xpath("//input[@id='confirm']")).sendKeys("test@test.com");
        //driver.findElement(By.xpath("//span[contains(text(),'Este correo electrónico ya está conectado a una cuenta.')]"));


    }


}
