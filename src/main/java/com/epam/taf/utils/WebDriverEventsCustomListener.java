package com.epam.taf.utils;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;


public class WebDriverEventsCustomListener implements WebDriverEventListener{

    private Logger logger;

    public WebDriverEventsCustomListener(Logger logger) {
        this.logger = logger;
    }



    public void beforeNavigateTo(String url, WebDriver driver) {
        logger.debug(">>>>>>>>>>>>>>>>> Attempt to navigate to url: " + url + ". <<<<<<<<<<<<<<<<<");
    }

    public void afterNavigateTo(String url, WebDriver driver) {
        logger.debug("Navigation to: " + url + " was successful.");
    }

    public void beforeNavigateBack(WebDriver driver) {
        logger.debug("Attempt to navigate back.");
    }

    public void afterNavigateBack(WebDriver driver) {
        logger.debug("Navigation back was successful.");
    }

    public void beforeNavigateForward(WebDriver driver) {
        logger.debug("Attempt to navigate forward.");
    }

    public void afterNavigateForward(WebDriver driver) {
        logger.debug("Navigation forward was successful.");
    }

    public void beforeNavigateRefresh(WebDriver webDriver) {

    }

    public void afterNavigateRefresh(WebDriver webDriver) {

    }

    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        logger.info("<<<<<<<<< Attempt to find element by " + by + ".>>>>>>>>>>>>>>>");
    }

    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        logger.info("<<<<<<<< Find element by " + by + " was performed.>>>>>>>>>>>>>>>");
    }

    public void beforeClickOn(WebElement element, WebDriver driver) {
        logger.debug("<<<<<<<<<<<<< Attempt to click on element [" + element.toString().split("->")[0] + "].>>>>>>>>>>>>>>>>>>>");
    }

    public void afterClickOn(WebElement element, WebDriver driver) {
        logger.debug("<<<<<<<<<<<<<<<<<<<<<< Click on element [" + element + "] was performed. >>>>>>>>>>>>>>>");
    }

    public void beforeChangeValueOf(WebElement element, WebDriver driver) {
        logger.debug("Attempt to change value of element [" + element + "].");
    }

    public void afterChangeValueOf(WebElement element, WebDriver driver) {
        logger.debug("Change value of element [" + element + "] was performed.");
    }

    public void beforeScript(String script, WebDriver driver) {
        logger.debug("Attempt to execute script [" + script + "].");
    }

    public void afterScript(String script, WebDriver driver) {
        logger.debug("Script execution was performed.");
    }

    public void onException(Throwable throwable, WebDriver driver) {
        logger.debug(throwable.getMessage());
    }
}


