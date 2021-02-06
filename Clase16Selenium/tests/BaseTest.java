package Clase16Selenium.tests;

import Clase16Selenium.PageObjects.PageShopifyLanding;
import Clase16Selenium.PageObjects.PageShopifyLogin;
import Clase16Selenium.PageObjects.PageShopifyPricing;
import Clase16Selenium.Utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    public WebDriver driver;
    public PageShopifyLanding pageShopifyLanding;
    public PageShopifyLogin pageShopifyLogin;
    public PageShopifyPricing pageShopifyPricing;
    public Utilities utilities;

    public final String TITLE = "Start a Business, Grow Your Business - Shopify 14-Day Free Trial";
    public final String URL = "https://www.shopify.com/";
    public final String LOGINTITLE = "Shopify - Iniciar sesión";
    //public final String ALERT = "Dirección de tienda incorrecta. Una dirección de tienda válida termina en .myshopify.com, .com, u otra extensión de dominio." ;
    public final String PRICINGTITLE = "Shopify Pricing - Setup and Open Your Online Store Today – Free Trial";
    public final String PRICINGURL = "https://www.shopify.com/pricing";


    @BeforeMethod
    public void setup(){

        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        pageShopifyLanding = new PageShopifyLanding(driver);
        pageShopifyLogin = new PageShopifyLogin(driver);
        pageShopifyPricing = new PageShopifyPricing(driver);
        utilities = new Utilities();
    }


    @AfterMethod
    public void close() throws InterruptedException{

        Thread.sleep(500);

        driver.close();

    }

}
