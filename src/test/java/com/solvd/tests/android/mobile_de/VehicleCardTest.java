package com.solvd.tests.android.mobile_de;

import com.solvd.tests.android.mobile_de.components.common.MainMenuBase;
import com.solvd.tests.android.mobile_de.domain.VehicleCard;
import com.solvd.tests.android.mobile_de.pages.common.HomePageBase;
import com.solvd.tests.android.mobile_de.pages.common.OnlineBuyingPageBase;
import com.solvd.tests.android.mobile_de.pages.common.OnlineBuyingVehicleCardPageBase;
import com.solvd.tests.android.mobile_de.pages.common.VehicleCardPageBase;
import com.solvd.tests.android.mobile_de.util.VehicleCardService;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

// (to execute these tests you may need check capabilities.app in _config.properties file)
public class VehicleCardTest extends BaseTest {

    @Test(description = "Verifying first vehicle card from home page test", enabled = true)
    public void verifyFirstHomePageVehicleCard() {
        SoftAssert sa = new SoftAssert();

        HomePageBase homePage = getHomePage();

        VehicleCardService vehicleCardService = new VehicleCardService();
        VehicleCard vehicleCardFromHomePage = vehicleCardService.createVehicleCardFromHomePage();

        VehicleCardPageBase vehicleCardPage = homePage.clickFirstVehicleCard();
        sa.assertTrue(vehicleCardPage.isPageOpened(), "Vehicle card page wasn't opened!");

        VehicleCard vehicleCardFromCardPage = vehicleCardService.createVehicleCardFromCardPage();

        sa.assertTrue(vehicleCardFromHomePage.equals(vehicleCardFromCardPage),
                "Vehicle from Home page isn't equal vehicle from Card page!");

        sa.assertAll();
    }

    @Test(description = "Verifying first vehicle card from online buying page test", enabled = true)
    public void verifyFirstOnlineBuyingPageVehicleCard() {
        SoftAssert sa = new SoftAssert();

        HomePageBase homePage = getHomePage();
        MainMenuBase mainMenu = homePage.clickMainMenuButton();
        OnlineBuyingPageBase onlineBuyingPage = mainMenu.clickOnlineBuyingMenuItem();
        onlineBuyingPage.closeSearchSavePopup();
        sa.assertTrue(onlineBuyingPage.isPageOpened(), "Online Buying page wasn't opened!");

        VehicleCardService vehicleCardService = new VehicleCardService();
        VehicleCard vehicleCardFromOnlineBuyingPage = vehicleCardService.createVehicleCardFromOnlineBuyingPage();

        OnlineBuyingVehicleCardPageBase onlineBuyingVehicleCardPage = onlineBuyingPage.clickFirstVehicleCard();
        sa.assertTrue(onlineBuyingVehicleCardPage.isPageOpened(), "Online buying vehicle card page wasn't opened!");

        VehicleCard vehicleCardFromOnlineBuyingCardPage = vehicleCardService.createVehicleCardFromOnlineBuyingVehicleCardPage();

        sa.assertTrue(vehicleCardFromOnlineBuyingPage.equals(vehicleCardFromOnlineBuyingCardPage),
                "Vehicle from Online buying page isn't equal vehicle from Online buying Card page!");

        sa.assertAll();
    }
}
