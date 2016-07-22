package com.epam.taf.steps;

import org.openqa.selenium.WebDriver;

public class AbstractSteps {
    protected WebDriver driver;

    public AbstractSteps(WebDriver driver) {
        this.driver = driver;
    }
}
