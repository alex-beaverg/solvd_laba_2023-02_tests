package com.solvd.tests.web.components.body;

import com.solvd.tests.web.components.header.dropdown.BasketHeader;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class PopUpConfirmation extends AbstractUIObject {

    @FindBy(xpath = "//div[@class='lead jqititle ']")
    private ExtendedWebElement title;

    @FindBy(xpath = "//form[@class='jqiform ']//button[1]")
    private ExtendedWebElement confirmDeleteFromBasketButton;

    public PopUpConfirmation(WebDriver driver) {
        super(driver);
    }

    public boolean isTitleElementPresent() {
        return title.isElementPresent();
    }

    public BasketHeader clickConfirmDeleteFromBasketButton() {
        confirmDeleteFromBasketButton.click();
        return new BasketHeader(driver);
    }
}
