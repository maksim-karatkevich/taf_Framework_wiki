package com.epam.taf.steps;

import com.epam.taf.pages.HomePage;
import com.epam.taf.property.PropertyProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class HomePageSteps extends AbstractSteps {
    private static String URL;
    private static final Logger log = LogManager.getRootLogger();

    public HomePageSteps(WebDriver driver) {
        super(driver);
    }

    public HomePageSteps openHomePage() {
        URL = PropertyProvider.getProperty("url");
        log.info("opening " + URL);
        driver.navigate().to(URL);
        return this;
    }

    public HomePageSteps chooseLanguageOnDropdownMenu(String language) {
        log.info("choose language - " + language);
        HomePage homePage = new HomePage(driver);
        homePage.chooseLanguage(language);

        return this;
    }

    public ResultPageSteps makeSearchRequest(String request) {
        log.info("make search request " + request);
        HomePage homePage = new HomePage(driver);
        homePage.enterRequest(request);
        homePage.clickSearchBtn();
        return new ResultPageSteps(driver);
    }

    public boolean findRusLangOnBlock() {
        log.info("searching russian language in 100 000+ block");
        HomePage homePage = new HomePage(driver);
        List<WebElement> list = homePage.getLanguages();
        for (WebElement element : list) {
            if(element.getAttribute("lang").equals("ru")){
                return false;
            }
        }
        return true;
    }

}
