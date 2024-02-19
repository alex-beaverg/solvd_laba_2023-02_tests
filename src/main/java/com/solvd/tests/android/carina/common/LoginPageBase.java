package com.solvd.tests.android.carina.common;

import com.solvd.tests.android.carina.domain.Sex;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class LoginPageBase extends AbstractPage {

    public LoginPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void typeName(String name);

    public abstract void typePassport(String password);

    public abstract void selectSex(Sex sex);

    public abstract void switchPrivacyPolicy(boolean privacyPolicy);

    public abstract CarinaDescriptionPageBase clickSignUpButton();

    public abstract boolean isSignUpButtonActive();
}
