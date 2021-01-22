package clase13Selenium.practico13;

import org.testng.annotations.Factory;

public class DocusignFactory {

    @Factory

    public Object[] factoryDocusign(){
        return new Object[]{
                new DocusignFactoryTest(),
                new DocusignFactoryTest(),
                new DocusignFactoryTest(),
        };
    }


}
