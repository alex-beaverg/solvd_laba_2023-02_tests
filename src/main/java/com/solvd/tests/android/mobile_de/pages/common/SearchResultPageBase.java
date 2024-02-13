package com.solvd.tests.android.mobile_de.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class SearchResultPageBase extends AbstractPage {

    public SearchResultPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract SearchResultPageBase closeSearchSavePopup();

    public abstract boolean isVehicleFilterPresent(String vehicle);

    public abstract boolean isPriceFromFilterPresent(String price);

    public abstract boolean isPriceToFilterPresent(String price);

    public abstract boolean isResultMoreThanZero();
}
