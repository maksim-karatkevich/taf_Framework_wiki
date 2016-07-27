package com.epam.taf.steps;

import com.epam.taf.utils.WebDriverEventsCustomListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class AbstractSteps {
    protected WebDriver driver;

    public AbstractSteps(WebDriver driver) {
        this.driver = driver;
    }
}
