package PracticoOnce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ejercicio7 {

    private WebDriver inicializarDriver(String url){

        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        return driver;
    }

    @Test

    public void spotifyByPlaceHolder() throws InterruptedException {

        WebDriver driver = inicializarDriver("https://www.spotify.com/co/signup/");

        String byPlaceholderEmail= "input[placeholder=\"Introduce tu correo electrónico.\"]";
        String byPlaceholderConfEmail= "input[placeholder=\"Vuelve a introducir tu correo electrónico.\"]";
        String byPlaceholderPass= "*[placeholder='Crea una contraseña.']";
        String byPlaceholderProfile = "*[placeholder='Introduce un nombre de perfil.']";
        String byPlaceholderDay = "*[placeholder='DD']";
        String byPlaceholderYear = "*[placeholder='AAAA']";

        driver.findElement(By.cssSelector(byPlaceholderEmail)).sendKeys("test2021@test.com");
        driver.findElement(By.cssSelector(byPlaceholderConfEmail)).sendKeys("test2021@test.com");
        driver.findElement(By.cssSelector(byPlaceholderPass)).sendKeys("testtest");
        driver.findElement(By.cssSelector(byPlaceholderProfile)).sendKeys("test2021");
        driver.findElement(By.cssSelector(byPlaceholderDay)).sendKeys("21");

        //Dropdown
        WebElement monthElement=  driver.findElement(By.cssSelector("*#month"));
        Select month = new Select(monthElement);
        month.selectByVisibleText("Febrero");

        driver.findElement(By.cssSelector(byPlaceholderYear)).sendKeys("2000");

        //Radio
        driver.findElement(By.xpath("(//span[@class='Indicator-sc-16vj7o8-0 kSKYRE'])[2]")).click();

        //driver.findElement(By.cssSelector("label>input[value=\"female\"]")).click();  El elemento localizado  no es clicable.

        //Check

        driver.findElement(By.cssSelector("span[class = 'Indicator-sc-11vkltc-0 dA-dPKg']")).click();


        driver.findElement(By.cssSelector("button[type='submit']")).click();

        String mensaje= driver.findElement(By.xpath("(//*[contains(text(), 'Confirma que no eres un robot.')])[1]")).getText();

        /*WebElement mensajeError =driver.findElement(By.xpath("(//*[contains(text(), 'Confirma que no eres un robot.')])[1]"));
        String mensaje=mensajeError.getText();*/

        //System.out.println(mensaje);

        String mensajeEsperado = "Confirma que no eres un robot.";

        Assert.assertEquals(mensaje,mensajeEsperado);
    }

}
