package com.solvd.tests.android.mobile_de.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class OnlineBuyingPageBase extends AbstractPage {

    public OnlineBuyingPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract OnlineBuyingPageBase closeSearchSavePopup();

    public abstract OnlineBuyingVehicleCardPageBase clickFirstVehicleCard();

    public abstract String getFirstVehicleCardModelText();

    public abstract double getFirstVehicleCardPriceValue();

    public abstract double getFirstVehicleCardMileageValue();

    public abstract String getFirstVehicleCardFirstRegistrationText();

    public abstract String getFirstVehicleCardPerformanceText();
}
