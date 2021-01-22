package clase13Selenium.practico13Ejercicio4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class implicitWaitTest {

    /*Ejercicio
    Crear un método llamado implicitWaitTest que acceda a Salesforce y espera hasta 10
    segundos antes de tirar una excepción.
    Hacer click en Forgot Account*/

    public void setup(){

        WebDriver driver;
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://login.salesforce.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[contains(text(),'Forgot')]"));
    }
}
