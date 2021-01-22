package clase13Selenium.practico13;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DocusignFactoryTest {


    public WebDriver driver;

    @BeforeMethod
    public void setup(){

        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://go.docusign.com/o/trial/");
        driver.manage().window().maximize();
    }

    @Test

    public void getTitleDS(){

        ejercicio1Practico13 utility= new ejercicio1Practico13(driver);

        System.out.println("Título de la página: " + utility.getTitle());

        Assert.assertEquals(utility.getTitle(), "DocuSign Free Trial");

    }

    @AfterMethod
    public void closeDriver(){
        driver.close();
    }
}
