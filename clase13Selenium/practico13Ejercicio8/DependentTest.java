package clase13Selenium.practico13Ejercicio8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DependentTest<urlPagina> {

    WebDriver driver;
    WebDriverWait wait;
    private final String urlPagina= "https://www.spotify.com/co/";
    private final String messageForm = "Este correo electrónico ya está conectado a una cuenta. Inicia sesión.";
    utilities manageData;

    @BeforeTest
    public void setup(){

        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.spotify.com/co/");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver,10);

    }
@Test
    public void ValidarIngresoASpotify(){

        manageData = new utilities(driver);

        String url = manageData.manageDataForm();

        //Validar ingreso a la oágina principal
        Assert.assertEquals(url,urlPagina);

       //Validar ingreso a la página de registrarse

        WebElement textH2 = driver.findElement(By.xpath("//h2[contains(text(), 'Regístrate gratis para escuchar')]"));
        Assert.assertEquals(textH2.getText(), "Regístrate gratis para escuchar");
    }

    @Test(dependsOnMethods={"ValidarIngresoASpotify"})

    public void IngresarDatosRegistro(){

         //Forma1
        //presenceOfElementLocated //visibilityOf
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='email']")));

        //Forma2
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@name='email']"))));

        manageData.manageDataSignUp();
    }

    @Test(dependsOnMethods = {"IngresarDatosRegistro"})
    public void ValidarMensajeRequerido(){

        String xpath= "//span[contains(text(),'Este correo electrónico')]";
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(xpath),messageForm));
        String message = driver.findElement(By.xpath(xpath)).getText();
        Assert.assertEquals(message, messageForm);
    }

    @AfterTest
    public void close(){
        driver.close();
    }

}
