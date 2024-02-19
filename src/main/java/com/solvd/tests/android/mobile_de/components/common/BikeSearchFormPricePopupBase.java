package com.solvd.tests.android.mobile_de.components.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class BikeSearchFormPricePopupBase extends AbstractPage {

    public BikeSearchFormPricePopupBase(WebDriver driver) {
        super(driver);
    }

    public abstract void typePriceFrom(String priceFrom);

    public abstract void typePriceTo(String priceTo);

    public abstract BikeSearchFormBase clickOkButton();
}
