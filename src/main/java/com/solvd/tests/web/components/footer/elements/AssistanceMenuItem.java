package com.solvd.tests.web.components.footer.elements;

import com.solvd.tests.web.pages.SomeInfoPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AssistanceMenuItem extends AbstractUIObject {

    @FindBy(xpath = ".//a")
    private ExtendedWebElement item;

    public AssistanceMenuItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public SomeInfoPage clickItem() {
        item.click();
        return new SomeInfoPage(driver);
    }
}
