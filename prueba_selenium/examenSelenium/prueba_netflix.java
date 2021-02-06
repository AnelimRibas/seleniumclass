package examenSelenium;
import Clase14Selenium.practico14Ejercicio1.ejemploDataprovider.DataproviderClass;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class prueba_netflix {

    public WebDriver driver;
    public final String LANDTITLE= "Netflix Colombia: Ve series online, ve películas online";
    public final String LOGINTITLE= "Netflix";

    @BeforeTest
    public void setup() {

        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.netflix.com/");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void validarTituloTest(){
        System.out.println("titulo: " + driver.getTitle() );
        Assert.assertEquals(driver.getTitle(),LANDTITLE);
    }

    @Test (dependsOnMethods = {"validarTituloTest"})
    public void iniciarSesionPageTest(){

        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.netflix.com/");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//a[contains(text(),'Iniciar sesión')]")).click();

        Assert.assertEquals(driver.getTitle(),LOGINTITLE);

        System.out.println("Titulo de login" + driver.getTitle());

        List<WebElement> H1List = driver.findElements(By.tagName("h1"));

        boolean validateData= false;
        for (WebElement values: H1List){
            System.out.println("VALORES H1: -->" + values.getText() );
            if (values.getText().equals("Inicia sesión")) {
                validateData = true;
            }
        }
        Assert.assertTrue(validateData);

        String FbTxt= driver.findElement(By.xpath("//span[contains(text(),'Iniciar sesión con Facebook')]")).getText();

        Assert.assertEquals(FbTxt,"Iniciar sesión con Facebook");
    }

    @Test  (dependsOnMethods = {"iniciarSesionPageTest"})
    public void loginToNetflixErrorTest(){

        Assert.assertEquals(driver.getTitle(),LOGINTITLE);

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.findElement(By.name("userLoginId")).sendKeys("test@test.com");
        driver.findElement(By.id("id_password")).sendKeys("holamundo");
        //driver.findElement(By.xpath("//input[@type='checkbox']")).click();
        driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();

        String message = driver.findElement(By.xpath("//*[contains(text(),'Contraseña incorrecta.')]")).getText();

        Assert.assertEquals(message,"Contraseña incorrecta.");

    }

    @Test (priority = 1)
    public void fakeEmailTest(){

        driver.get("https://www.netflix.com/");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        Faker fake = new Faker();

        String email= fake.internet().emailAddress();

        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.xpath("//span[contains(text(),'COMIENZA YA')]")).click();

    }

    @Test(dataProvider="SearchProvider",dataProviderClass= DataproviderClass.class)
    public void dataProviderEmailTest(String email){

        driver.get("https://www.netflix.com/");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.findElement(By.name("email")).sendKeys(email);

    }

    @Test (priority = 2)
    @Parameters({"tagNameTestng"})
    public void printTagsTest(@Optional("a") String tagName){

        driver.get("https://www.netflix.com/");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        List<WebElement> elements = driver.findElements(By.tagName(tagName));
        if(tagName.equals("h1")) {
            for (int i = 0; i < elements.size(); i++) {
                System.out.println("H1: " + elements.get(i).getText());
            }
        }
        if(tagName.equals("h4")) {
            for (int i = 0; i < elements.size(); i++) {
                System.out.println("H4: " + elements.get(i).getText());
            }
        }
        else{
            for (int i = 0; i < elements.size(); i++) {
                System.out.println("Tagname " +tagName+ ": " + elements.get(i).getText());
            }
        }


    }

    @AfterTest
    public void close (){

        driver.close();

    }

}

