package com.solvd.tests.android.carina;

import com.solvd.tests.android.carina.common.CarinaDescriptionPageBase;
import com.solvd.tests.android.carina.common.LoginPageBase;
import com.solvd.tests.android.carina.common.WelcomePageBase;
import com.solvd.tests.android.carina.domain.User;
import com.solvd.tests.android.carina.domain.Users;
import com.solvd.tests.android.carina.util.LoginService;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest implements IAbstractTest, IMobileUtils {

    // My implementation of Android Carina (carina-demo) Login Test with domain objects:
    // (to execute this test you may need check capabilities.app in _config.properties file)
    @Test(description = "Android Carina application sign up test", enabled = false)
    public void carinaAppSignUpTest() {
        WelcomePageBase welcomePage = initPage(getDriver(), WelcomePageBase.class);
        Assert.assertTrue(welcomePage.isPageOpened(), "Welcome page wasn't opened!");

        LoginPageBase loginPage = welcomePage.clickNextButton();
        Assert.assertTrue(loginPage.isPageOpened(), "Login page wasn't open!");

        LoginService loginService = new LoginService();
        User user = loginService.createUser(Users.NEW_USER);
        CarinaDescriptionPageBase carinaDescriptionPage = loginService.signUp(getDriver(), user);
        Assert.assertTrue(carinaDescriptionPage.isPageOpened(), "Carina description page wasn't open!");
    }
}
