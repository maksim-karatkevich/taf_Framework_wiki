package com.epam.taf.utils;

import com.epam.taf.driver.FactoryDriver;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import java.io.File;
import java.io.IOException;


public class ScreenshotExecutor extends TestListenerAdapter{

    public static final String PNG = ".png";
    private Logger log = LogManager.getRootLogger();
    private static int pngCount = 0;


    @Override
    public void onTestFailure(ITestResult testResult) {
        log.error(testResult.getName() + " screenshot saved: " + takeScreenshot());
    }

    public String takeScreenshot()  {
        String path;
        try {
            File source = ((TakesScreenshot)FactoryDriver.getInstance()).getScreenshotAs(OutputType.FILE);
            path = "./target/screenshots/"+ "errorImg" + pngCount + PNG;
            pngCount++;
            FileUtils.copyFile(source, new File(path));
        }
        catch(IOException e) {
            log.error("failed to capture screenshot");
            path = "Failed to capture screenshot: " + e.getMessage();
        }
        return path;
    }
}
