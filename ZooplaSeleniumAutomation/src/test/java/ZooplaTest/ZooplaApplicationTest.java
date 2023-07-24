package ZooplaTest;

import BaseUrl.Reader;
import org.testng.annotations.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.log4j.Logger;

import static BaseUrl.Reader.browser;
import static BaseUrl.Reader.get_properties;



public class ZooplaApplicationTest {
    WebDriver driver;
    WebDriverWait wait;

    private static Logger log = Logger.getLogger(ZooplaApplicationTest.class);
    @Test(priority=1)
    public void DisplayBrowser(){
        get_properties();
        log.info("launching browser");
    }
}



