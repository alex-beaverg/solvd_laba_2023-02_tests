package com.solvd.tests.android.mobile_de.pages.common;

import com.solvd.tests.android.mobile_de.pages.common.common.PageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;

public abstract class HelpAndSettingsPageBase extends PageBase {

    public HelpAndSettingsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract HelpAndSettingsPageBase clickLogoutButton();

    public abstract boolean isLogoutDone();

    public abstract ExtendedWebElement getLoginTextView();

    public abstract ExtendedWebElement getLogoutButton();
}
