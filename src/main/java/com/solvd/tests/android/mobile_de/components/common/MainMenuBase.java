package com.solvd.tests.android.mobile_de.components.common;

import com.solvd.tests.android.mobile_de.pages.common.*;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class MainMenuBase extends AbstractPage {

    public MainMenuBase(WebDriver driver) {
        super(driver);
    }

    public abstract SearchPageBase clickSearchMenuItem();

    public abstract OnlineBuyingPageBase clickOnlineBuyingMenuItem();

    public abstract CarParkPageBase clickCarParkMenuItem();

    public abstract AuthenticationPageBase clickLoginButton();

    public abstract HelpAndSettingsPageBase clickHelpAndSettingsMenuItem();

    public abstract String getAccountNameTextIfElementPresent();
}
