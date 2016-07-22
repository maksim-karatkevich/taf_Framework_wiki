package com.epam.taf.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.*;
import java.util.List;

public class HomePage extends AbstractPage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "searchInput")
    private WebElement searchInputField;
    @FindBy(id = "searchLanguage")
    private WebElement dropdownLanguageMenu;
    @FindBy(xpath = "//fieldset/button")
    private WebElement searchButton;
    @FindBy(id = "jsLangLabel")
    private WebElement languageLabel;
    @FindBy(xpath = "//h2[@class = 'bookshelf-container'][2]/following-sibling::div[1]//a")
    private List<WebElement> listOfLanguages;

    public void chooseLanguage(String language) {
        Select select = new Select(dropdownLanguageMenu);
        select.selectByValue(language);

    }

    public List getLanguages(){
        return listOfLanguages;
    }

    public String getLanguageLabel() {
        return languageLabel.getText();
    }

    public void enterRequest(String request) {
        searchInputField.sendKeys(request);
    }

    public void clickSearchBtn() {
        searchButton.click();
    }
}
