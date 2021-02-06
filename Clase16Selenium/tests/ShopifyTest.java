package Clase16Selenium.tests;


import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ShopifyTest extends BaseTest{



    @Test
    public void StartLoginPageShopify(){

        Assert.assertEquals(pageShopifyLanding.getTitle(),TITLE);
        Assert.assertEquals(pageShopifyLanding.getCurrentUrl(), URL);

        pageShopifyLogin = pageShopifyLanding.goToLogin();

        Assert.assertEquals(pageShopifyLogin.getTitle(),LOGINTITLE);
       // Assert.assertEquals(alertMessage.getText(),ALERT);

        List<WebElement> arrayAlertMessage = pageShopifyLogin.clicNextAndMessage();

        boolean alert = utilities.searchPartialText(arrayAlertMessage, "Dirección de tienda incorrecta.");
        /*boolean alert = false;

        for(WebElement value: arrayAlertMessage){
            if(value.getText().contains("Dirección de tienda incorrecta.")){
                alert = true;
            }
        }*/
        Assert.assertTrue(alert);

    }

    @Test

    public void pricingPage(){

        pageShopifyPricing = pageShopifyLanding.goToPricing();

        Assert.assertEquals(pageShopifyPricing.getTitle(),PRICINGTITLE);
        Assert.assertEquals(pageShopifyPricing.getCurrentUrl(),PRICINGURL);

        List<WebElement> ElemH1 = pageShopifyPricing.searchListH1();

        boolean validatedata = utilities.searchText(ElemH1, "Set up your store, pick a plan later");
        //System.out.println("Imprimiendo el retorno de Utilities " + validatedata);

        /*boolean validatedata = false;
        for(WebElement values:ElemH1){
            if(values.getText().equals("Set up your store, pick a plan later")) {
                System.out.println("H1 valores -->" + values.getText());
                validatedata = true;
            }
        }*/

        Assert.assertTrue(validatedata);
    }



}
