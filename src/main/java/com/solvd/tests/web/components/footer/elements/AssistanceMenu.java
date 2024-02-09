package com.solvd.tests.web.components.footer.elements;

import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AssistanceMenu extends AbstractUIObject {

    @FindBy(xpath = ".//li")
    private List<AssistanceMenuItem> items;

    public AssistanceMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public List<AssistanceMenuItem> getItems() {
        return items;
    }
}
