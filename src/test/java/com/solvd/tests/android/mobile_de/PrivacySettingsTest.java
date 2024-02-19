package com.solvd.tests.android.mobile_de;

import com.solvd.tests.android.mobile_de.components.common.MainMenuBase;
import com.solvd.tests.android.mobile_de.pages.common.HelpAndSettingsPageBase;
import com.solvd.tests.android.mobile_de.pages.common.HomePageBase;
import com.solvd.tests.android.mobile_de.pages.common.PrivacySettingsPageBase;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PrivacySettingsTest extends BaseTest {

    @Test(description = "Test method for practicing finding locators")
    public void findAndUncheckFourCheckboxesTest() {
        SoftAssert sa = new SoftAssert();

        HomePageBase homePage = getHomePage();
        MainMenuBase mainMenu = homePage.clickMainMenuButton();
        HelpAndSettingsPageBase helpAndSettingsPage = mainMenu.clickHelpAndSettingsMenuItem();
        PrivacySettingsPageBase privacySettingsPage = helpAndSettingsPage.clickPrivacySettingsLink();
        sa.assertTrue(privacySettingsPage.isPageOpened());

        privacySettingsPage.uncheckStoreInfoCheckbox();
        sa.assertFalse(privacySettingsPage.getStoreInfoCheckbox().isChecked(), "Checkbox was checked!");

        swipe(privacySettingsPage.getUseLimitedConsentCheckbox());
        privacySettingsPage.uncheckUseLimitedLICheckbox();
        sa.assertFalse(privacySettingsPage.getUseLimitedLICheckbox().isChecked(), "Checkbox was check!");
        privacySettingsPage.uncheckUseLimitedConsentCheckbox();
        sa.assertFalse(privacySettingsPage.getUseLimitedConsentCheckbox().isChecked(), "Checkbox was check!");

        swipe(privacySettingsPage.getCreateProfilesCheckbox());
        privacySettingsPage.uncheckCreateProfilesCheckbox();
        sa.assertFalse(privacySettingsPage.getCreateProfilesCheckbox().isChecked(), "Checkbox was check!");

        sa.assertAll();
    }
}
