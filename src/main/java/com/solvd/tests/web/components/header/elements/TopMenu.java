package com.solvd.tests.web.components.header.elements;

import com.solvd.tests.web.components.header.dropdown.BasketHeader;
import com.solvd.tests.web.components.header.dropdown.LoginHeader;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class TopMenu extends AbstractUIObject {

    @FindBy(xpath = ".//button[@data-drop='loginDropPanel']")
    private ExtendedWebElement loginButton;

    @FindBy(xpath = ".//button[@data-drop='basketDropPanel']")
    private ExtendedWebElement basketButton;

    public TopMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public LoginHeader getLoginHeader() {
        loginButton.click();
        return new LoginHeader(driver);
    }

    public BasketHeader getBasket() {
        BasketHeader basket = new BasketHeader(driver);
        if (!basket.isTitleElementPresent()) {
            basketButton.click();
        }
        return basket;
    }
}
