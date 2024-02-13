package com.solvd.tests.web.components.header;

import com.solvd.tests.web.components.header.elements.MainMenu;
import com.solvd.tests.web.components.header.elements.TopMenu;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class MainHeader extends AbstractUIObject {

    @FindBy(xpath = ".//nav[@class='top-menu']")
    private TopMenu topMenu;

    @FindBy(xpath = ".//nav[@class='main-menu']")
    private MainMenu mainMenu;

    public MainHeader(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public TopMenu getTopMenu() {
        return topMenu;
    }

    public MainMenu getMainMenu() {
        return mainMenu;
    }
}
