package examenSelenium;

import clase13Selenium.practico13.DocusignFactoryTest;
import org.testng.annotations.Factory;

public class FactoryTest {

    @Factory

    public Object[] factoryNetflix(){
        return new Object[]{
                new prueba_netflix(),
                new prueba_netflix(),

        };
    }

}
