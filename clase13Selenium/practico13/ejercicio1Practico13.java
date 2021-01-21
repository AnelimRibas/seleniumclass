package clase13Selenium.practico13;

import org.openqa.selenium.WebDriver;

public class ejercicio1Practico13 {

    /*Crear una clase llamada DocusignFactory y una clase llamada DocusignFactoryTest.
    DocusignFactoryTest debe acceder al sitio “https://go.docusign.com/o/trial/” y debe tener un
    método de test que valide que el título de Docusign sea “DocuSign Free Trial”
    DocusignFactory debe invocar 3 veces a la clase DocusignFactoryTest creando nuevas
    instancias de la misma.*/

    WebDriver driver;

    public ejercicio1Practico13(WebDriver globalDriver){

        driver = globalDriver;
    }

    public String getTitle()
    {
        return driver.getTitle();
    }




}
