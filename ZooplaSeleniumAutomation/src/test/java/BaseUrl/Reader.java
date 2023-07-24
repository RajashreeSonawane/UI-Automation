package BaseUrl;

import GetBrowser.UrlDriver;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class Reader {
    static WebDriver driver;
    static WebDriverWait wait;
    private static Logger log = Logger.getLogger(Reader.class);

    public static Properties get_properties() {
        FileReader reader = null;
        Properties url = new Properties();
        try {
            reader = new FileReader("src\\test\\java\\config\\Zoopla.properties");
            url.load(reader);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return url;
    }

    @Parameters("browser")
    @BeforeTest
    public static void browser(String browser) {
        PropertyConfigurator.configure("src\\main\\resources\\log4j2.properties");
        UrlDriver urlDriver = new UrlDriver(browser);
        driver = urlDriver.setDriver();
        driver.manage().window().maximize();
        driver.get(get_properties().getProperty("url"));
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        log.info("Open the Zoopla software Testing Url");
    }
}
