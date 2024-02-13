package com.solvd.tests.android.mobile_de;

import com.solvd.tests.android.mobile_de.domain.Account;
import com.solvd.tests.android.mobile_de.domain.Accounts;
import com.solvd.tests.android.mobile_de.pages.common.*;
import com.solvd.tests.android.mobile_de.components.common.MainMenuBase;
import com.solvd.tests.android.mobile_de.util.AccountService;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

// (to execute these tests you may need check capabilities.app in _config.properties file)
public class LoginTest extends BaseTest {

    private HomePageBase loginActions(Accounts account) {
        SoftAssert sa = new SoftAssert();

        HomePageBase homePage = getHomePage();

        MainMenuBase mainMenu = homePage.clickMainMenuButton();
        AuthenticationPageBase authenticationPage = mainMenu.clickLoginButton();
        sa.assertTrue(authenticationPage.isPageOpened(), "Authentication page wasn't opened!");

        AccountService accountService = new AccountService();
        Account user = accountService.createAccount(account);
        homePage = accountService.login(getDriver(), user);

        return homePage;
    }

    @Test(description = "Valid login test", enabled = true)
    public void verifyValidLoginTest() {
        SoftAssert sa = new SoftAssert();

        HomePageBase homePage = loginActions(Accounts.VALID_ACCOUNT);
        ProcessingRequestPageBase processingRequestPage = initPage(getDriver(), ProcessingRequestPageBase.class);

        if (processingRequestPage.isPageOpened(1)) {
            skipExecution("Request is processing. This test was skipped");
        } else {
            sa.assertTrue(homePage.isPageOpened(), "Login wasn't done!");

            MainMenuBase mainMenu = homePage.clickMainMenuButton();
            sa.assertEquals(mainMenu.getAccountNameTextIfElementPresent(), "Logged in as Alex",
                    "Account Name doesn't equal expected name!");

            sa.assertAll();
        }
    }

    @Test(description = "Invalid login test", enabled = true)
    public void verifyInvalidLoginTest() {
        SoftAssert sa = new SoftAssert();

        loginActions(Accounts.INVALID_ACCOUNT);
        ProcessingRequestPageBase processingRequestPage = initPage(getDriver(), ProcessingRequestPageBase.class);

        if (processingRequestPage.isPageOpened(1)) {
            skipExecution("Request is processing. This test was skipped");
        } else {
            AuthenticationPageBase authenticationPage = initPage(getDriver(), AuthenticationPageBase.class);
            sa.assertTrue(authenticationPage.isLoginFailedMessagePresent(), "Login failed message wasn't presented!");

            sa.assertAll();
        }
    }

    @Test(description = "Logout after valid login test", enabled = true)
    public void verifyLogoutTest() {
        SoftAssert sa = new SoftAssert();

        HomePageBase homePage = loginActions(Accounts.VALID_ACCOUNT);
        ProcessingRequestPageBase processingRequestPage = initPage(getDriver(), ProcessingRequestPageBase.class);

        if (processingRequestPage.isPageOpened(1)) {
            skipExecution("Request is processing. This test was skipped");
        } else {
            MainMenuBase mainMenu = homePage.clickMainMenuButton();
            HelpAndSettingsPageBase helpAndSettingsPage = mainMenu.clickHelpAndSettingsMenuItem();
            sa.assertTrue(helpAndSettingsPage.isPageOpened(), "Help and Settings page wasn't opened!");

            swipe(helpAndSettingsPage.getLogoutButton(), Direction.UP);
            helpAndSettingsPage = helpAndSettingsPage.clickLogoutButton();
            swipe(helpAndSettingsPage.getLoginTextView(), Direction.DOWN);
            sa.assertTrue(helpAndSettingsPage.isLogoutDone(), "Logout wasn't done!");

            sa.assertAll();
        }
    }
}
