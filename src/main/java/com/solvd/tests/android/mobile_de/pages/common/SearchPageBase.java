package com.solvd.tests.android.mobile_de.pages.common;

import com.solvd.tests.android.mobile_de.components.common.BikeSearchFormBase;
import com.solvd.tests.android.mobile_de.pages.common.common.PageBase;
import org.openqa.selenium.WebDriver;

public abstract class SearchPageBase extends PageBase {

    public SearchPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract BikeSearchFormBase clickSearchBikeIcon();
}
