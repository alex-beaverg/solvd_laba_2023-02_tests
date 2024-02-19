package com.solvd.tests.android.mobile_de.components.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class BikeSearchFormModelPopupBase extends AbstractPage {

    public BikeSearchFormModelPopupBase(WebDriver driver) {
        super(driver);
    }

    public abstract BikeSearchFormAddVehiclePopupBase clickAddVehicleLink();

    public abstract BikeSearchFormBase clickOkButton();
}
