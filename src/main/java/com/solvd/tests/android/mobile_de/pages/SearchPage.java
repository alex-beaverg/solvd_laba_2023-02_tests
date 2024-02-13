package com.solvd.tests.android.mobile_de.pages;

import com.solvd.tests.android.mobile_de.components.common.BikeSearchFormBase;
import com.solvd.tests.android.mobile_de.pages.common.SearchPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SearchPageBase.class)
public class SearchPage extends SearchPageBase {

    @FindBy(xpath = "//android.widget.TextView[@text=\"Search\"]")
    private ExtendedWebElement title;

    @FindBy(xpath = "//android.widget.ImageView[@resource-id=\"de.mobile.android.app:id/qs_tab_motorbike\"]")
    private ExtendedWebElement bikeIcon;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public BikeSearchFormBase clickSearchBikeIcon() {
        bikeIcon.click();
        return initPage(driver, BikeSearchFormBase.class);
    }

    @Override
    public boolean isPageOpened() {
        return this.isElementWithTextPresent(title, "Search");
    }
}
