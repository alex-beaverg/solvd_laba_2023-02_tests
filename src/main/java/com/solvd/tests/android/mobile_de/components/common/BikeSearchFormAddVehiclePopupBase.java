package com.solvd.tests.android.mobile_de.components.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class BikeSearchFormAddVehiclePopupBase extends AbstractPage {

    public BikeSearchFormAddVehiclePopupBase(WebDriver driver) {
        super(driver);
    }

    public abstract BikeSearchFormModelPopupBase clickVehicleItem(String vehicle);

    public abstract ExtendedWebElement getVehicleItem(String vehicle);
}
