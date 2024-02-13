package com.solvd.tests.android.mobile_de.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class AuthenticationPageBase extends AbstractPage {

    public AuthenticationPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void typeEmail(String email);

    public abstract void typePass(String pass);

    public abstract HomePageBase clickLoginButton();

    public abstract boolean isLoginButtonActive();

    public abstract boolean isLoginFailedMessagePresent();
}
