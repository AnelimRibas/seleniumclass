package examenSelenium;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

    @DataProvider(name="SearchProvider")
    public static Object[][] getDataFromDataprovider(){
        return new Object[][] {
                { "test@test1.com"},
                { "test@test2.com" },
                { "test@test3.com" }
        };
    }

}
