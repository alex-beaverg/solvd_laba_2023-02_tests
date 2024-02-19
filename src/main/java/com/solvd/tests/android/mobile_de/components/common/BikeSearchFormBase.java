package com.solvd.tests.android.mobile_de.components.common;

import com.solvd.tests.android.mobile_de.pages.common.SearchResultPageBase;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class BikeSearchFormBase extends AbstractPage {

    public BikeSearchFormBase(WebDriver driver) {
        super(driver);
    }

    public abstract BikeSearchFormModelPopupBase clickModelElement();

    public abstract BikeSearchFormPricePopupBase clickPriceElement();

    public abstract SearchResultPageBase clickShowResultsButton();
}
