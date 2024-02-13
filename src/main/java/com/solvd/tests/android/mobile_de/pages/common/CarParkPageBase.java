package com.solvd.tests.android.mobile_de.pages.common;

import com.solvd.tests.android.mobile_de.pages.common.common.PageBase;
import org.openqa.selenium.WebDriver;

public abstract class CarParkPageBase extends PageBase {

    public CarParkPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isPageOpened(int quantity);

    public abstract void clickFirstCardOptionsButton();

    public abstract CarParkPageBase clickDeleteCardButton();

    public abstract CarParkPageBase deleteFirstCard();

    public abstract VehicleCardPageBase clickFirstCard();
}
