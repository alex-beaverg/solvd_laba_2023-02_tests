package com.solvd.tests.web;

import com.solvd.tests.web.domain.Users;
import com.solvd.tests.web.components.header.dropdown.LoginHeader;
import com.solvd.tests.web.pages.HomePage;
import com.solvd.tests.web.pages.MyAccountPage;
import com.solvd.tests.web.web_util.LoginService;
import com.zebrunner.carina.utils.config.Configuration;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginAndLogoutTest extends BaseTest {
    private final LoginService LOGIN_SERVICE = new LoginService();

    @Test(description = "Verify valid login", enabled = true)
    public void verifyValidLoginTest() {
        SoftAssert sa = new SoftAssert();
        getLoginHeader();

        MyAccountPage myAccountPage = LOGIN_SERVICE.login(LOGIN_SERVICE.createUser(Users.VALID), getDriver());
        sa.assertTrue(myAccountPage.isPageOpened());

        sa.assertAll();
    }

    @Test(description = "Verify invalid login", enabled = true)
    public void verifyInvalidLoginTest() {
        SoftAssert sa = new SoftAssert();
        LoginHeader loginHeader = getLoginHeader();

        MyAccountPage myAccountPage = LOGIN_SERVICE.login(LOGIN_SERVICE.createUser(Users.INVALID), getDriver());
        sa.assertTrue(loginHeader.isErrorElementPresent());
        sa.assertFalse(myAccountPage.isPageOpened(1));

        sa.assertAll();
    }

    @Test(description = "Verify logout", enabled = true)
    public void verifyLogoutTest() {
        SoftAssert sa = new SoftAssert();

        getLoginHeader();
        MyAccountPage myAccountPage = LOGIN_SERVICE.login(LOGIN_SERVICE.createUser(Users.VALID), getDriver());
        HomePage homePage = myAccountPage.clickLogOutButton();
        sa.assertTrue(homePage.isPageOpened(), "Home Page isn't open!");

        sa.assertAll();
    }

    private LoginHeader getLoginHeader() {
        SoftAssert sa = new SoftAssert();
        HomePage homePage = getHomePage();

        LoginHeader loginHeader = homePage.getMainHeader().getTopMenu().getLoginHeader();
        sa.assertTrue(loginHeader.isTitleElementPresent(), "Login Header isn't drop down!");
        sa.assertTrue(loginHeader.getTitleText().startsWith("Please log in"), "Login Header Title doesn't contain expected text!");

        return loginHeader;
    }
}
