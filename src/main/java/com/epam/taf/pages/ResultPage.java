package com.epam.taf.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ResultPage extends AbstractPage {


    public ResultPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "firstHeading")
    private WebElement articleTitle;

    @FindBy(className = "mw-search-nonefound")
    private WebElement searchNotFound;

    public String getTitle() {
        return articleTitle.getText();
    }

    public String getNotFoundMessage(){
        return searchNotFound.getText();
    }

}
