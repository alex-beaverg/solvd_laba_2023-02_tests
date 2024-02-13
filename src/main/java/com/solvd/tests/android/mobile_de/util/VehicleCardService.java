package com.solvd.tests.android.mobile_de.util;

import com.solvd.tests.android.mobile_de.domain.VehicleCard;
import com.solvd.tests.android.mobile_de.pages.common.HomePageBase;
import com.solvd.tests.android.mobile_de.pages.common.OnlineBuyingPageBase;
import com.solvd.tests.android.mobile_de.pages.common.OnlineBuyingVehicleCardPageBase;
import com.solvd.tests.android.mobile_de.pages.common.VehicleCardPageBase;
import com.zebrunner.carina.utils.mobile.IMobileUtils;

public class VehicleCardService implements IMobileUtils {

    public VehicleCard createVehicleCardFromHomePage(HomePageBase homePage) {
        VehicleCard vehicleCard = new VehicleCard();
        vehicleCard.setModel(homePage.getFirstVehicleCardModelText());
        vehicleCard.setPrice(homePage.getFirstVehicleCardPriceValue());
        vehicleCard.setMileage(homePage.getFirstVehicleCardMileageValue());
        vehicleCard.setAddress(homePage.getFirstVehicleCardAddressText());
        vehicleCard.setFirstRegistration("skipped");
        vehicleCard.setPerformance("skipped");
        return vehicleCard;
    }

    public VehicleCard createVehicleCardFromCardPage(VehicleCardPageBase cardPage) {
        VehicleCard vehicleCard = new VehicleCard();
        vehicleCard.setModel(cardPage.getVehicleCardModelText());
        vehicleCard.setPrice(cardPage.getVehicleCardPriceValue());
        swipe(cardPage.getVehicleCardAddress(), IMobileUtils.Direction.UP);
        vehicleCard.setMileage(cardPage.getVehicleCardMileageValue());
        vehicleCard.setAddress(cardPage.getVehicleCardAddressText());
        vehicleCard.setFirstRegistration("skipped");
        vehicleCard.setPerformance("skipped");
        return vehicleCard;
    }

    public VehicleCard createVehicleCardFromOnlineBuyingPage(OnlineBuyingPageBase onlineBuyingPage) {
        VehicleCard vehicleCard = new VehicleCard();
        vehicleCard.setModel(onlineBuyingPage.getFirstVehicleCardModelText());
        vehicleCard.setPrice(onlineBuyingPage.getFirstVehicleCardPriceValue());
        vehicleCard.setMileage(onlineBuyingPage.getFirstVehicleCardMileageValue());
        vehicleCard.setFirstRegistration(onlineBuyingPage.getFirstVehicleCardFirstRegistrationText());
        vehicleCard.setPerformance(onlineBuyingPage.getFirstVehicleCardPerformanceText());
        vehicleCard.setAddress("skipped");
        return vehicleCard;
    }

    public VehicleCard createVehicleCardFromOnlineBuyingVehicleCardPage(OnlineBuyingVehicleCardPageBase onlineBuyingVehicleCardPage) {
        VehicleCard vehicleCard = new VehicleCard();
        vehicleCard.setModel(onlineBuyingVehicleCardPage.getVehicleCardModelText());
        vehicleCard.setPrice(onlineBuyingVehicleCardPage.getVehicleCardPriceValue());
        swipe(onlineBuyingVehicleCardPage.getVehicleCardPerformance(), Direction.UP);
        vehicleCard.setMileage(onlineBuyingVehicleCardPage.getVehicleCardMileageValue());
        vehicleCard.setFirstRegistration(onlineBuyingVehicleCardPage.getVehicleCardFirstRegistrationText());
        vehicleCard.setPerformance(onlineBuyingVehicleCardPage.getVehicleCardPerformanceText());
        vehicleCard.setAddress("skipped");
        return vehicleCard;
    }
}
