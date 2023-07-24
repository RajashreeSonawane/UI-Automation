package GetBrowser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.apache.log4j.Logger;

public class UrlDriver {
    static Logger log = Logger.getLogger(UrlDriver.class);
    WebDriver driver;
    String browser;

    public UrlDriver(String browser) {
        this.browser = browser;
    }

    public WebDriver setDriver() {
        if (browser.equalsIgnoreCase("firefox")) {
            log.info("Executing on FireFox");
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("chrome")) {
            log.info("Executing on CHROME");
            // ChromeOptions options = new ChromeOptions();
            //options.addArguments("headless");
            //driver = new ChromeDriver(options);
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("ie")) {
            log.info("Executing on IE");
            //EdgeOptions options = new EdgeOptions();
            //options.setHeadless(true);
            //driver = new EdgeDriver(options);
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        return driver;
    }
}
