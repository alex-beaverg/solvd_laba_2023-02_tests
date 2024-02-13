package com.solvd.tests.android.mobile_de.components;

import com.solvd.tests.android.mobile_de.components.common.MainMenuBase;
import com.solvd.tests.android.mobile_de.pages.common.*;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = MainMenuBase.class)
public class MainMenu extends MainMenuBase {

    @FindBy(id = "drawer_header_name")
    private ExtendedWebElement accountName;

    @FindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"de.mobile.android.app:" +
            "id/design_menu_item_text\" and @text=\"Search\"]")
    private ExtendedWebElement searchMenuItem;

    @FindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"de.mobile.android.app:" +
            "id/design_menu_item_text\" and @text=\"Online Buying\"]")
    private ExtendedWebElement onlineBuyingMenuItem;

    @FindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"de.mobile.android.app:" +
            "id/design_menu_item_text\" and @text=\"Car Park\"]")
    private ExtendedWebElement carParkMenuItem;

    @FindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"de.mobile.android.app:" +
            "id/design_menu_item_text\" and @text=\"Help & Settings\"]")
    private ExtendedWebElement helpAndSettingsMenuItem;

    @FindBy(id = "btn_navigation_login")
    private ExtendedWebElement loginButton;

    public MainMenu(WebDriver driver) {
        super(driver);
    }

    @Override
    public SearchPageBase clickSearchMenuItem() {
        searchMenuItem.click();
        return initPage(driver, SearchPageBase.class);
    }

    @Override
    public OnlineBuyingPageBase clickOnlineBuyingMenuItem() {
        onlineBuyingMenuItem.click();
        return initPage(driver, OnlineBuyingPageBase.class);
    }

    @Override
    public CarParkPageBase clickCarParkMenuItem() {
        carParkMenuItem.click();
        return initPage(driver, CarParkPageBase.class);
    }

    @Override
    public AuthenticationPageBase clickLoginButton() {
        loginButton.click();
        return initPage(driver, AuthenticationPageBase.class);
    }

    @Override
    public HelpAndSettingsPageBase clickHelpAndSettingsMenuItem() {
        helpAndSettingsMenuItem.click();
        return initPage(driver, HelpAndSettingsPageBase.class);
    }

    @Override
    public String getAccountNameTextIfElementPresent() {
        Assert.assertTrue(accountName.isElementPresent(), "Account Name element wasn't found!");
        return accountName.getText();
    }
}
