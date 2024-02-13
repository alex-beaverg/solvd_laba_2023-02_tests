package com.solvd.tests.android.mobile_de;

import com.solvd.tests.android.mobile_de.components.common.MainMenuBase;
import com.solvd.tests.android.mobile_de.domain.VehicleCard;
import com.solvd.tests.android.mobile_de.pages.common.CarParkPageBase;
import com.solvd.tests.android.mobile_de.pages.common.HomePageBase;
import com.solvd.tests.android.mobile_de.pages.common.VehicleCardPageBase;
import com.solvd.tests.android.mobile_de.util.VehicleCardService;
import com.zebrunner.carina.utils.R;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

// (to execute these tests you may need check capabilities.app in _config.properties file)
public class CarParkTest extends BaseTest {

    @Test(description = "Adding and removing cars to car park test", enabled = true)
    public void verifyAddCarsToCarParkAndRemoveCarsTest() {
        SoftAssert sa = new SoftAssert();
        int carQuantity = Integer.parseInt(R.TESTDATA.get("android.mobile_de.car_park.quantity"));

        HomePageBase homePage = getHomePage();

        homePage = homePage.clickAddCarToCarPark(carQuantity);

        MainMenuBase mainMenu = homePage.clickMainMenuButton();
        CarParkPageBase carParkPage = mainMenu.clickCarParkMenuItem();
        sa.assertTrue(carParkPage.isPageOpened(carQuantity), "Car park page wasn't opened!");

        for (int i = 1; i <= carQuantity; i++) {
            carParkPage = carParkPage.deleteFirstCard();
            sa.assertTrue(carParkPage.isPageOpened(carQuantity - i),
                    "Quantity of cars on car park page isn't equal expected quantity!");
        }

        sa.assertAll();
    }

    @Test(description = "Adding car to car park test", enabled = true)
    public void verifyAddCarToCarParkTest() {
        SoftAssert sa = new SoftAssert();
        int carQuantity = 1;

        HomePageBase homePage = getHomePage();

        homePage = homePage.clickAddCarToCarPark(carQuantity);

        VehicleCardService vehicleCardService = new VehicleCardService();
        VehicleCard vehicleCardFromHomePage = vehicleCardService.createVehicleCardFromHomePage(homePage);

        MainMenuBase mainMenu = homePage.clickMainMenuButton();
        CarParkPageBase carParkPage = mainMenu.clickCarParkMenuItem();
        sa.assertTrue(carParkPage.isPageOpened(carQuantity), "Car park page wasn't opened!");

        VehicleCardPageBase vehicleCardPage = carParkPage.clickFirstCard();
        sa.assertTrue(vehicleCardPage.isPageOpened(), "Vehicle card page wasn't opened!");

        VehicleCard vehicleCardFromVehicleCardPage = vehicleCardService.createVehicleCardFromCardPage(vehicleCardPage);

        sa.assertTrue(vehicleCardFromHomePage.equals(vehicleCardFromVehicleCardPage),
                "Vehicle from Home page isn't equal vehicle from Car park page!");

        sa.assertAll();
    }
}
