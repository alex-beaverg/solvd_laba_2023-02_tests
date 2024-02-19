package com.solvd.tests.android.mobile_de.pages.common.common;

import com.solvd.tests.android.mobile_de.components.common.MainMenuBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class PageBase extends AbstractPage {

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Open navigation bar\"]")
    private ExtendedWebElement mainMenuButton;

    public PageBase(WebDriver driver) {
        super(driver);
    }

    public MainMenuBase clickMainMenuButton() {
        mainMenuButton.click();
        return initPage(driver, MainMenuBase.class);
    }
}
