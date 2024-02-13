package com.solvd.tests.android.mobile_de.pages.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class VehicleCardPageBase extends AbstractPage {

    public VehicleCardPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract String getVehicleCardModelText();

    public abstract double getVehicleCardPriceValue();

    public abstract double getVehicleCardMileageValue();

    public abstract String getVehicleCardAddressText();

    public abstract ExtendedWebElement getVehicleCardAddress();
}
