package com.solvd.tests.android.mobile_de.pages.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class OnlineBuyingVehicleCardPageBase extends AbstractPage {

    public OnlineBuyingVehicleCardPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract String getVehicleCardModelText();

    public abstract double getVehicleCardPriceValue();

    public abstract double getVehicleCardMileageValue();

    public abstract String getVehicleCardFirstRegistrationText();

    public abstract String getVehicleCardPerformanceText();

    public abstract ExtendedWebElement getVehicleCardPerformance();
}
