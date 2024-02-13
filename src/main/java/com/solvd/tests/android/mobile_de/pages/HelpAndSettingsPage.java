package com.solvd.tests.android.mobile_de.pages;

import com.solvd.tests.android.mobile_de.pages.common.HelpAndSettingsPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HelpAndSettingsPageBase.class)
public class HelpAndSettingsPage extends HelpAndSettingsPageBase {

    @FindBy(xpath = "//android.widget.TextView[@text=\"Help & Settings\"]")
    private ExtendedWebElement title;

    @FindBy(id = "log_in")
    private ExtendedWebElement loginTextView;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Log Out\"]")
    private ExtendedWebElement logoutButton;

    public HelpAndSettingsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public HelpAndSettingsPageBase clickLogoutButton() {
        logoutButton.click();
        return this;
    }

    @Override
    public boolean isLogoutDone() {
        return loginTextView.isElementPresent();
    }

    @Override
    public boolean isPageOpened() {
        return this.isElementWithTextPresent(title, "Help & Settings");
    }

    @Override
    public ExtendedWebElement getLogoutButton() {
        return logoutButton;
    }

    @Override
    public ExtendedWebElement getLoginTextView() {
        return loginTextView;
    }
}
