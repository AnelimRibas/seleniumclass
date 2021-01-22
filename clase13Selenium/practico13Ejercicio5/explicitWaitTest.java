package clase13Selenium.practico13Ejercicio5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class explicitWaitTest {

    /*Acceder a https://www.spotify.com/uy/signup/
    Completar el email y la confirmación del email con test@test.com
    Esperar que aparezca el mensaje de error utilizando un explicit wait
    Validar que el mensaje de error sea “Este correo electrónico ya está conectado a una
    cuenta.”*/

    WebDriver driver;

    @BeforeMethod

    public void setup(){

        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.spotify.com/co/signup/");
    }

    @Test

    public void spotifyExplicitWaitTest(){

        utility util = new utility(driver);
        util.fillEmail();

        WebDriverWait wait = new WebDriverWait(driver,10);
        String path= "//span[contains(text(),'Este correo electrónico ya está conectado a una cuenta.')]";
        //Forma1
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(path),"Este correo electrónico ya está conectado a una cuenta."));
        //Forma2
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path)));

        String message = driver.findElement(By.xpath(path)).getText();
        Assert.assertEquals(message,"Este correo electrónico ya está conectado a una cuenta. Inicia sesión.");

    }

    @AfterMethod
    public void close(){
        driver.close();
    }




}
