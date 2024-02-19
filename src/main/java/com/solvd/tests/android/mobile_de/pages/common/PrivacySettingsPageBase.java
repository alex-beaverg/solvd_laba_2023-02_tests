package com.solvd.tests.android.mobile_de.pages.common;

import com.solvd.tests.android.mobile_de.pages.common.common.PageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;

public abstract class PrivacySettingsPageBase extends PageBase {

    public PrivacySettingsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract ExtendedWebElement getStoreInfoCheckbox();

    public abstract ExtendedWebElement getUseLimitedLICheckbox();

    public abstract ExtendedWebElement getUseLimitedConsentCheckbox();

    public abstract ExtendedWebElement getCreateProfilesCheckbox();

    public abstract void uncheckStoreInfoCheckbox();

    public abstract void uncheckUseLimitedLICheckbox();

    public abstract void uncheckUseLimitedConsentCheckbox();

    public abstract void uncheckCreateProfilesCheckbox();
}
