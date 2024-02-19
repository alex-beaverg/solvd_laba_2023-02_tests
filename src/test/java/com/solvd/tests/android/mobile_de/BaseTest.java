package com.solvd.tests.android.mobile_de;

import com.solvd.tests.android.mobile_de.pages.common.HomePageBase;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.testng.asserts.SoftAssert;

public class BaseTest implements IAbstractTest, IMobileUtils {

    public HomePageBase getHomePage() {
        SoftAssert sa = new SoftAssert();

        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.clickAcceptPrivacyButton();
        sa.assertTrue(homePage.isPageOpened(), "Home page wasn't opened!");

        sa.assertAll();
        return homePage;
    }
}
