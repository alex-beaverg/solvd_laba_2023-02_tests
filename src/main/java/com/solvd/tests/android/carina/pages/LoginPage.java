package com.solvd.tests.android.carina.pages;

import com.solvd.tests.android.carina.common.CarinaDescriptionPageBase;
import com.solvd.tests.android.carina.common.LoginPageBase;
import com.solvd.tests.android.carina.domain.Sex;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase {

    @FindBy(xpath = "//android.widget.TextView[@text=\"CARINA\"]")
    private ExtendedWebElement title;

    @FindBy(id = "name")
    private ExtendedWebElement nameInput;

    @FindBy(id = "password")
    private ExtendedWebElement passwordInput;

    @FindBy(id = "radio_male")
    private ExtendedWebElement maleRadioButton;

    @FindBy(id = "radio_female")
    private ExtendedWebElement femaleRadioButton;

    @FindBy(id = "checkbox")
    private ExtendedWebElement privacyPolicySwitch;

    @FindBy(id = "login_button")
    private ExtendedWebElement signUpButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void typeName(String name) {
        nameInput.type(name);
    }

    @Override
    public void typePassport(String password) {
        passwordInput.type(password);
    }

    @Override
    public void selectSex(Sex sex) {
        if (sex.equals(Sex.MALE)) {
            maleRadioButton.click();
        } else if (sex.equals(Sex.FEMALE)) {
            femaleRadioButton.click();
        }
    }

    @Override
    public void switchPrivacyPolicy(boolean privacyPolicy) {
        if (privacyPolicy) {
            privacyPolicySwitch.click();
        }
    }

    @Override
    public CarinaDescriptionPageBase clickSignUpButton() {
        if (isSignUpButtonActive()) {
            signUpButton.click();
        }
        return initPage(getDriver(), CarinaDescriptionPageBase.class);
    }

    @Override
    public boolean isSignUpButtonActive() {
        return Boolean.parseBoolean(signUpButton.getAttribute("enabled"));
    }

    @Override
    public boolean isPageOpened() {
        return title.isElementPresent();
    }
}
