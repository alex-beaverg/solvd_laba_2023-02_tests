package com.solvd.tests.android.mobile_de.util;

import com.solvd.tests.android.mobile_de.domain.VehicleCard;
import com.solvd.tests.android.mobile_de.pages.HomePage;
import com.solvd.tests.android.mobile_de.pages.OnlineBuyingPage;
import com.solvd.tests.android.mobile_de.pages.OnlineBuyingVehicleCardPage;
import com.solvd.tests.android.mobile_de.pages.VehicleCardPage;
import com.solvd.tests.android.mobile_de.pages.common.HomePageBase;
import com.solvd.tests.android.mobile_de.pages.common.OnlineBuyingPageBase;
import com.solvd.tests.android.mobile_de.pages.common.OnlineBuyingVehicleCardPageBase;
import com.solvd.tests.android.mobile_de.pages.common.VehicleCardPageBase;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.testng.asserts.SoftAssert;

public class VehicleCardService implements IMobileUtils {

    public VehicleCard createVehicleCardFromHomePage() {
        SoftAssert sa = new SoftAssert();

        HomePageBase homePage = new HomePage(getDriver());
        sa.assertTrue(homePage.isPageOpened(), "Home page wasn't opened!");

        VehicleCard vehicleCard = new VehicleCard();
        vehicleCard.setModel(homePage.getFirstVehicleCardModelText());
        vehicleCard.setPrice(homePage.getFirstVehicleCardPriceValue());
        vehicleCard.setMileage(homePage.getFirstVehicleCardMileageValue());
        vehicleCard.setAddress(homePage.getFirstVehicleCardAddressText());
        vehicleCard.setFirstRegistration("skipped");
        vehicleCard.setPerformance("skipped");

        sa.assertAll();
        return vehicleCard;
    }

    public VehicleCard createVehicleCardFromCardPage() {
        SoftAssert sa = new SoftAssert();

        VehicleCardPageBase cardPage = new VehicleCardPage(getDriver());
        sa.assertTrue(cardPage.isPageOpened(), "Vehicle card page wasn't opened!");

        VehicleCard vehicleCard = new VehicleCard();
        vehicleCard.setModel(cardPage.getVehicleCardModelText());
        vehicleCard.setPrice(cardPage.getVehicleCardPriceValue());
        swipe(cardPage.getVehicleCardAddress(), IMobileUtils.Direction.UP);
        vehicleCard.setMileage(cardPage.getVehicleCardMileageValue());
        vehicleCard.setAddress(cardPage.getVehicleCardAddressText());
        vehicleCard.setFirstRegistration("skipped");
        vehicleCard.setPerformance("skipped");

        sa.assertAll();
        return vehicleCard;
    }

    public VehicleCard createVehicleCardFromOnlineBuyingPage() {
        SoftAssert sa = new SoftAssert();

        OnlineBuyingPageBase onlineBuyingPage = new OnlineBuyingPage(getDriver());
        sa.assertTrue(onlineBuyingPage.isPageOpened(), "Online Buying page wasn't opened!");

        VehicleCard vehicleCard = new VehicleCard();
        vehicleCard.setModel(onlineBuyingPage.getFirstVehicleCardModelText());
        vehicleCard.setPrice(onlineBuyingPage.getFirstVehicleCardPriceValue());
        vehicleCard.setMileage(onlineBuyingPage.getFirstVehicleCardMileageValue());
        vehicleCard.setFirstRegistration(onlineBuyingPage.getFirstVehicleCardFirstRegistrationText());
        vehicleCard.setPerformance(onlineBuyingPage.getFirstVehicleCardPerformanceText());
        vehicleCard.setAddress("skipped");

        sa.assertAll();
        return vehicleCard;
    }

    public VehicleCard createVehicleCardFromOnlineBuyingVehicleCardPage() {
        SoftAssert sa = new SoftAssert();

        OnlineBuyingVehicleCardPageBase onlineBuyingVehicleCardPage = new OnlineBuyingVehicleCardPage(getDriver());
        sa.assertTrue(onlineBuyingVehicleCardPage.isPageOpened(), "Online buying vehicle card page wasn't opened!");

        VehicleCard vehicleCard = new VehicleCard();
        vehicleCard.setModel(onlineBuyingVehicleCardPage.getVehicleCardModelText());
        vehicleCard.setPrice(onlineBuyingVehicleCardPage.getVehicleCardPriceValue());
        swipe(onlineBuyingVehicleCardPage.getVehicleCardPerformance(), Direction.UP);
        vehicleCard.setMileage(onlineBuyingVehicleCardPage.getVehicleCardMileageValue());
        vehicleCard.setFirstRegistration(onlineBuyingVehicleCardPage.getVehicleCardFirstRegistrationText());
        vehicleCard.setPerformance(onlineBuyingVehicleCardPage.getVehicleCardPerformanceText());
        vehicleCard.setAddress("skipped");

        sa.assertAll();
        return vehicleCard;
    }
}
