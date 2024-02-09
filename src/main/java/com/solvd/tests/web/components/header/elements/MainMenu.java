package com.solvd.tests.web.components.header.elements;

import com.solvd.tests.web.components.header.dropdown.MobilePhonesHeader;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class MainMenu extends AbstractUIObject {

    @FindBy(xpath = ".//button[@data-drop='catMainDropPanel']")
    private ExtendedWebElement mobilePhonesButton;

    public MainMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public MobilePhonesHeader getMobilePhonesHeader() {
        mobilePhonesButton.click();
        return new MobilePhonesHeader(driver);
    }
}
