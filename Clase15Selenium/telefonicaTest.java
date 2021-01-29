package Clase15Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class telefonicaTest {

    private static String TELEFONICA_URL = "https://www.telefonica.es/es/";
    WebDriver driver;
    WebDriverWait wait;
    Telefonica telefonica;
    FrameTelefonica frameTelefonica;

    @BeforeTest
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.telefonica.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,10);
        telefonica = new Telefonica(driver,wait);

    }

    @Test
    public void starTelefonicaTest(){

        Assert.assertEquals(telefonica.getTitle(), "Telefónica");
        Assert.assertEquals(telefonica.getUrl(),"https://www.telefonica.com/es/home");

        telefonica.clickMessagePolicy();

        frameTelefonica = telefonica.switchFrame();

    }

    @Test (dependsOnMethods={"starTelefonicaTest"})
    public void CotizacionesTabTest(){

        List<WebElement> tabsList = frameTelefonica.locateTabs("Tab");

        Assert.assertEquals(tabsList.size(), 2);

        frameTelefonica.clickTab(tabsList);

        Assert.assertEquals(frameTelefonica.ActiveTab().getText(), "BME");

    }

    @Test (dependsOnMethods = {"CotizacionesTabTest"})
    public void PrintCotizacionesTest(){

        List<WebElement> dataItemsList = frameTelefonica.locateTabs("DataItem");
        List<WebElement> dataValuesList = frameTelefonica.locateTabs("DataValue");

        Assert.assertEquals(dataItemsList.size(), 6);
        Assert.assertEquals(dataValuesList.size(), 6);

        for(WebElement di: dataItemsList){
            System.out.println("-**** "+di.getText());
        }
        for(WebElement dv: dataValuesList){
            System.out.println("-**** "+dv.getText());
        }
    }

}
