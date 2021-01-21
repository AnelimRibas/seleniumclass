package clase13Selenium.practico13Ejercicio8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class utilities {

    WebDriver driver;

    public utilities(WebDriver driver)
    {
        this.driver = driver;
    }

    public String manageDataForm(){

        String url = driver.getCurrentUrl();
        System.out.println("la url es:" + url);

        driver.findElement(By.xpath("//a[contains(text(),'Registrarse')]")).click();

        return url;
    }

    public void manageDataSignUp(){

        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("prueba@prueba.com");
        driver.findElement(By.name("confirm")).sendKeys("prueba@prueba.com");
        driver.findElement(By.tagName("button")).click();
    }
}
