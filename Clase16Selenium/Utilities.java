package Clase16Selenium;

import org.openqa.selenium.WebElement;

import java.util.List;

public class Utilities {

    public boolean searchText(List<WebElement> listElement, String text){

        for(WebElement values:listElement) {
            if (values.getText().equals(text)) {
                return true;
            } else {
                return false;
            }
        }

        System.out.println("Entró a utilities " + text);
        return true;
    }

    public boolean searchPartialText(List<WebElement> listElement, String text){

        for(WebElement values:listElement) {
            if (values.getText().contains(text)) {
                return true;
            } else {
                return false;
            }
        }

        System.out.println("Entró a utilities " + text);
        return true;
    }

}
