package com.epam.taf.driver;


import com.epam.taf.property.PropertyProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class FactoryDriver {
    private static final Logger log = LogManager.getRootLogger();
    private static WebDriver driver;

    private FactoryDriver() {
    }

    private static WebDriver getActualDriver() {
        BrowserType type = BrowserType.valueOf(PropertyProvider.getProperty("browser"));
        switch (type) {
            case CHROME:
                driver = createChromeDriver();
                log.info("chrome driver created");
                break;
            case FIREFOX:
                driver = createFirefoxDriver();
                log.info("firefox driver created");
                break;
            default:
                driver = createFirefoxDriver();
                log.info(" default: firefox driver created");

        }
        return driver;
    }

    public static WebDriver getInstance() {
        if (driver == null) {
            getActualDriver();
        }
        return driver;
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
        log.info("driver has been closed");
    }

    private static WebDriver createFirefoxDriver() {
        return new FirefoxDriver();
    }

    private static WebDriver createChromeDriver() {
        return new ChromeDriver();
    }
}
