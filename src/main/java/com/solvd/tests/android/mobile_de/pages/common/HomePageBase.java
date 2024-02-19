package com.solvd.tests.android.mobile_de.pages.common;

import com.solvd.tests.android.mobile_de.pages.common.common.PageBase;
import org.openqa.selenium.WebDriver;

public abstract class HomePageBase extends PageBase {

    public HomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void clickAcceptPrivacyButton();

    public abstract VehicleCardPageBase clickFirstVehicleCard();

    public abstract String getFirstVehicleCardModelText();

    public abstract double getFirstVehicleCardPriceValue();

    public abstract double getFirstVehicleCardMileageValue();

    public abstract String getFirstVehicleCardAddressText();

    public abstract HomePageBase clickAddCarToCarPark(int quantity);

    public abstract void clickCancelNotificationsButton();
}
