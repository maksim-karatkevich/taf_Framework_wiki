package com.epam.taf.driver;


import com.epam.taf.utils.WebDriverEventsCustomListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.net.MalformedURLException;
import java.net.URL;


public class FactoryDriver {
    private static final Logger log = LogManager.getRootLogger();
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private FactoryDriver() {
    }

    private static WebDriver getActualDriver() {
        WebDriver driver;
        driver = createRemoteDriver();
//        driver = createFirefoxDriver();
        return driver;
    }

    /**
     * old driver factory version
     *
     *
     */
//        switch (type) {
//            case CHROME:
//                System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\chromedriver.exe");
//                driver = createChromeDriver();
//                log.info("chrome driver created");
//                break;
//            case FIREFOX:
//                log.info("unblockable firefox driver created");
//                return new UnblockableFirefoxDriver();
//            case REMOTE_DRIVER:
//                driver = createRemoteDriver();
//                break;
//            default:
//                driver = new UnblockableFirefoxDriver();
//                log.info("default: firefox driver created");
//        }
    private static WebDriver createRemoteDriver() {
        DesiredCapabilities dr = DesiredCapabilities.firefox();
        dr.setPlatform(Platform.LINUX);
        String temp = getTypeOfBrowser();
        if (temp == null) {
            temp = "firefox";
        }
        dr.setBrowserName(temp.toLowerCase());

        log.info("Capabilities configured");
        try {
            return new UnblockableRemoteDriver(new URL("http://192.168.99.100:4444/wd/hub"), dr);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static synchronized WebDriver getInstance() {
        if (driver.get() == null) {
            driver.set(getActualDriver());
        }
        return new EventFiringWebDriver(driver.get()).register(new WebDriverEventsCustomListener(log));
    }

    public static void closeDriver() {
        driver.get().quit();
        driver.remove();
        log.info("driver has been closed");
    }

    private static WebDriver createFirefoxDriver() {
        return new FirefoxDriver();
    }
//
//    private static WebDriver createChromeDriver() {
//        return new ChromeDriver();
//    }

    public static String getTypeOfBrowser() {
        return System.getProperty("browser");
    }
}
