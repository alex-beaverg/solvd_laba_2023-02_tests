package com.solvd.tests.web.components.footer;

import com.solvd.tests.web.components.footer.elements.AssistanceMenu;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Footer extends AbstractUIObject {

    @FindBy(xpath = ".//div[./h4[text() = 'ASSISTANCE']]/ul")
    private AssistanceMenu assistanceMenu;

    public Footer(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public AssistanceMenu getAssistanceMenu() {
        return assistanceMenu;
    }
}
