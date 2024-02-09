package com.solvd.tests.web.components.header.dropdown;

import com.solvd.tests.web.pages.ProductsPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class MobilePhonesHeader extends AbstractUIObject {

    @FindBy(xpath = "//div[@id='catMainDropPanel']//h4")
    private ExtendedWebElement title;

    @FindBy(css = "a[href*='android-os']")
    private ExtendedWebElement androidButton;

    public MobilePhonesHeader(WebDriver driver) {
        super(driver);
    }

    public boolean isTitleElementPresent() {
        return title.isElementPresent();
    }

    public String getTitleText() {
        return title.getText();
    }

    public ProductsPage clickAndroidButton() {
        androidButton.click();
        return new ProductsPage(driver);
    }
}
