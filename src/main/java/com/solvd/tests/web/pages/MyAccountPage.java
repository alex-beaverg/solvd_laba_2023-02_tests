package com.solvd.tests.web.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

    @FindBy(css = "a[href*='logout']")
    private ExtendedWebElement logoutButton;

    public MyAccountPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(logoutButton);
    }

    public HomePage clickLogOutButton() {
        logoutButton.click();
        return new HomePage(driver);
    }
}
