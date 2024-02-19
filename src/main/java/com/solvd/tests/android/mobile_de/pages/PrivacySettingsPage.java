package com.solvd.tests.android.mobile_de.pages;

import com.solvd.tests.android.mobile_de.pages.common.PrivacySettingsPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = PrivacySettingsPageBase.class)
public class PrivacySettingsPage extends PrivacySettingsPageBase {

    @FindBy(xpath = "//android.view.ViewGroup[@resource-id=\"de.mobile.android.app:id/toolbar\"]//android.widget.TextView")
    private ExtendedWebElement title;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"de.mobile.android.app:id/provider_consent_text\" " +
            "and contains(@text, \"access information\")]/following-sibling::android.widget.LinearLayout//android.widget.Switch")
    private ExtendedWebElement storeInfoCheckbox;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"de.mobile.android.app:id/provider_consent_text\" " +
            "and contains(@text, \"select advertising\")]/following-sibling::android.widget.LinearLayout//android.widget.Switch[1]")
    private ExtendedWebElement useLimitedLICheckbox;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"de.mobile.android.app:id/provider_consent_text\" " +
            "and contains(@text, \"select advertising\")]/following-sibling::android.widget.LinearLayout//android.widget.Switch[2]")
    private ExtendedWebElement useLimitedConsentCheckbox;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"de.mobile.android.app:id/provider_consent_text\" " +
            "and contains(@text, \"profiles for personalised\")]/following-sibling::android.widget.LinearLayout//android.widget.Switch")
    private ExtendedWebElement createProfilesCheckBox;

    public PrivacySettingsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ExtendedWebElement getStoreInfoCheckbox() {
        return storeInfoCheckbox;
    }

    @Override
    public ExtendedWebElement getUseLimitedLICheckbox() {
        return useLimitedLICheckbox;
    }

    @Override
    public ExtendedWebElement getUseLimitedConsentCheckbox() {
        return useLimitedConsentCheckbox;
    }

    @Override
    public ExtendedWebElement getCreateProfilesCheckbox() {
        return createProfilesCheckBox;
    }

    @Override
    public void uncheckStoreInfoCheckbox() {
        storeInfoCheckbox.uncheck();
    }

    @Override
    public void uncheckUseLimitedLICheckbox() {
        useLimitedLICheckbox.uncheck();
    }

    @Override
    public void uncheckUseLimitedConsentCheckbox() {
        useLimitedConsentCheckbox.uncheck();
    }

    @Override
    public void uncheckCreateProfilesCheckbox() {
        createProfilesCheckBox.uncheck();
    }

    @Override
    public boolean isPageOpened() {
        return this.isElementWithTextPresent(title, "Privacy Settings");
    }
}
