package clase13Selenium.practico13Ejercicio3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class testSleep {

    /*Crear un método que acceda a Salesforce y espere 5 segundos antes de hacer click en “Forgot
      password”.*/

    WebDriver driver;

@Test
    public void setup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://login.salesforce.com/");
        Thread.sleep(5000);
        driver.findElement(By.partialLinkText("Olvidó")).click();
    }


}
