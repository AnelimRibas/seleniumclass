package clase13Selenium.practico13Ejercicio6;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.List;

public class testParametrizables {

    public WebDriver driver;

@BeforeMethod
    public void setup(){

        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.spotify.com/co/");
    }

    @Test
    @Parameters({"tagNameTestng"})
    public void pruebasParametros(@Optional("a") String tagName){

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

        // libreria faker java
        /*Faker fake = new Faker();

        String name = fake.name().username();
        String email= fake.internet().emailAddress();

        System.out.println("Username: " + name);
        System.out.println("email: "+ email );*/


    }


    @AfterMethod
    public void closeDriver(){

    driver.close();

    }
}
