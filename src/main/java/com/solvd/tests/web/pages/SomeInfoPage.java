package com.solvd.tests.web.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SomeInfoPage extends BasePage {

    @FindBy(xpath = "//main[@id='mainContent']//h1")
    private ExtendedWebElement title;

    public SomeInfoPage(WebDriver driver) {
        super(driver);
    }

    public boolean isTitleElementPresent() {
        return title.isElementPresent(1);
    }
}
