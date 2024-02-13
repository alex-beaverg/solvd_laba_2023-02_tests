package com.solvd.tests.web.components.header.dropdown;

import com.solvd.tests.web.domain.User;
import com.solvd.tests.web.pages.MyAccountPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginHeader extends AbstractUIObject {

    @FindBy(xpath = "//div[@id='loginDropPanel']//h4")
    private ExtendedWebElement title;

    @FindBy(xpath = "//p[@class='error-txt']")
    private ExtendedWebElement error;

    @FindBy(xpath = "//input[@id='loginEmail']")
    private ExtendedWebElement emailInput;

    @FindBy(xpath = "//input[@id='loginPass']")
    private ExtendedWebElement passInput;

    @FindBy(css = "a[href*='login']")
    private ExtendedWebElement loginButton;

    public LoginHeader(WebDriver driver) {
        super(driver);
    }

    public LoginHeader typeEmail(User user) {
        emailInput.type(user.getEmail());
        return this;
    }

    public LoginHeader typePass(User user) {
        passInput.type(user.getPass());
        return this;
    }

    public MyAccountPage clickLoginButton() {
        loginButton.click();
        return new MyAccountPage(driver);
    }

    public boolean isTitleElementPresent() {
        return title.isElementPresent();
    }

    public boolean isErrorElementPresent() {
        return error.isElementPresent();
    }

    public String getTitleText() {
        return title.getText();
    }
}
