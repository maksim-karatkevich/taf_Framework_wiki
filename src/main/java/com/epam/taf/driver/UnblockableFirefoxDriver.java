package com.epam.taf.driver;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.Set;

/**
  Created by Maksim_Karatkevich on 8/12/2016.
 */
public class UnblockableFirefoxDriver implements WebDriver, TakesScreenshot, JavascriptExecutor{
    FirefoxDriver driver = new FirefoxDriver();


    public void get(String s) {
        driver.get(s);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public List<WebElement> findElements(By by) {
        return driver.findElements(by);
    }

    public WebElement findElement(By by) {
        WebElement element = driver.findElement(by);
        highlightElementMilliseconds(this, element, 100);
        return driver.findElement(by);
    }

    public String getPageSource() {
        return driver.getPageSource();
    }

    public void close() {
        driver.close();
    }

    public void quit() {
        driver.quit();
    }

    public Set<String> getWindowHandles() {
        return driver.getWindowHandles();
    }

    public String getWindowHandle() {
        return driver.getWindowHandle();
    }

    public WebDriver.TargetLocator switchTo() {
        return driver.switchTo();
    }

    public WebDriver.Navigation navigate() {
        return driver.navigate();
    }

    public WebDriver.Options manage() {
        return driver.manage();
    }

    public void highlightElementMilliseconds(WebDriver driver, WebElement element, int milliseconds) {
        String bg = element.getCssValue("backgroundColor");
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].style.backgroundColor = '" + "yellow" + "'", element);
        sleep(milliseconds); // just for demo
        js.executeScript("arguments[0].style.backgroundColor = '" + bg + "'", element);
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Object executeScript(String s, Object... objects) {
        return driver.executeScript(s, objects);
    }

    public Object executeAsyncScript(String s, Object... objects) {
        return executeAsyncScript(s, objects);
    }

    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        return driver.getScreenshotAs(outputType);
    }
}
