package clase13Selenium.practico13Ejercicio2;

import org.testng.annotations.Factory;

public class ShopifyFactory {

    @Factory

    public Object[] instances (){
        return new Object[]{
                new ShopifyTest(2),
                new ShopifyTest(0),
                new ShopifyTest(1)
        };
    }

}
