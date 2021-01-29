package Clase15Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class FrameTelefonica {

    public WebDriver driver;
    public WebDriverWait wait;

    public FrameTelefonica(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    public List locateTabs(String dataName){

        List<WebElement> tabsList = driver.findElements(By.className(dataName));

        return tabsList;
    }

    public void clickTab(List<WebElement> tabsList){

        for(WebElement tab: tabsList){
            System.out.println("--> tab " + tab.getText());
            if (tab.getText().equals("NYSE")){
                System.out.println("Texto Tab" + tab.getText());
                wait.until(ExpectedConditions.elementToBeClickable(By.className("Tab")));
                tab.click();
            }
        }
    }

public WebElement ActiveTab( ){

    WebElement activeTab = driver.findElement(By.className("Tab_Active"));
    System.out.println("Tab activa" + activeTab.getText());

    return activeTab;
}




}
