package practico13Ejercicio2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ShopifyTest {

    private int vble;

    public WebDriver driver;


    public ShopifyTest (){
        vble=0;
    }

    public ShopifyTest (int vbleGlobal){

        vble = vbleGlobal;
    }

    @BeforeMethod

    public void setup(){

        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://es.shopify.com/");
    }

   @Test

    public void testButtons(){

        List <WebElement> btnList = driver.findElements(By.tagName("button")); //driver.findElements(By.xpath("//*[@name= 'button']"));
        //System.out.println ("Se han encontrado: " + btnList.size() + " botones");

        /*for(int i=0; btnList.get(i).getText().isEmpty() == false; i++){
            System.out.println("Botón No.: " + i + " " + btnList.get(i).getText());
        } */

       /*for(WebElement elemento : btnList) {
           if(elemento.getText().isEmpty() == false) {
               System.out.println("Botón->" + elemento.getText());
           }
       }*/

       ArrayList<WebElement> nuevaLista = new ArrayList <WebElement>();

       for(WebElement newElement: btnList){
           if(newElement.getText().isEmpty()==false){
               nuevaLista.add(newElement);
               System.out.println("Nueva Lista: " + newElement.getText());
           }
       }

       System.out.println("Botón No.: " + vble + " " + nuevaLista.get(vble).getText());


    }
}
