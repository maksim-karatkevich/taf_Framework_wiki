package com.epam.taf.steps;

import com.epam.taf.pages.ResultPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;




public class ResultPageSteps extends AbstractSteps{
    private static final Logger log = LogManager.getLogger();

    public ResultPageSteps(WebDriver driver) {
        super(driver);
    }

    public String getArticleTitle() {
        log.info("get article title");
        ResultPage resultPage = new ResultPage(driver);
        return resultPage.getTitle();
    }

    public String getNotFoundMassage(){
        log.info("get not found message");
        ResultPage resultPage = new ResultPage(driver);
        String result = resultPage.getNotFoundMessage();
        return result;
    }
}
