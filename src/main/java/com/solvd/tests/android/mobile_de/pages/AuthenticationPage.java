package com.solvd.tests.android.mobile_de.pages;

import com.solvd.tests.android.mobile_de.pages.common.AuthenticationPageBase;
import com.solvd.tests.android.mobile_de.pages.common.HomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = AuthenticationPageBase.class)
public class AuthenticationPage extends AuthenticationPageBase {
    private final String loginFailedMessageXpath = "//android.widget.TextView[contains(@text, \"The credentials\")]";

    @FindBy(xpath = "//android.view.View[@text=\"E-Mail address\"]/following-sibling::android.widget.EditText")
    private ExtendedWebElement emailInput;

    @FindBy(xpath = "//android.view.View[@text=\"Password\"]/following-sibling::android.view.View/android.widget.EditText")
    private ExtendedWebElement passInput;

    @FindBy(xpath = "(//android.widget.Button[@text=\"Login\"])[2]")
    private ExtendedWebElement loginButton;

    @FindBy(xpath = loginFailedMessageXpath)
    private ExtendedWebElement loginFailedMessage;

    public AuthenticationPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void typeEmail(String email) {
        emailInput.type(email);
    }

    @Override
    public void typePass(String pass) {
        passInput.type(pass);
    }

    @Override
    public HomePageBase clickLoginButton() {
        Assert.assertTrue(this.isLoginButtonActive(), "Login button isn't active!");
        loginButton.click();
        return initPage(driver, HomePageBase.class);
    }

    @Override
    public boolean isPageOpened() {
        return loginButton.isElementPresent();
    }

    @Override
    public boolean isLoginButtonActive() {
        return Boolean.parseBoolean(loginButton.getAttribute("enabled"));
    }

    @Override
    public boolean isLoginFailedMessagePresent() {
        return loginFailedMessage.isElementPresent();
    }
}
