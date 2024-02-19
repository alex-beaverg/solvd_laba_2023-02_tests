package com.solvd.tests.android.mobile_de.pages;

import com.solvd.tests.android.mobile_de.pages.common.SearchResultPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.text.DecimalFormat;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SearchResultPageBase.class)
public class SearchResultPage extends SearchResultPageBase {

    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"de.mobile.android.app:id/fscv_id\"]" +
            "/android.widget.LinearLayout")
    private ExtendedWebElement closeSearchSavePopup;

    @FindBy(xpath = "//android.widget.Button[@text=\"%s\"]")
    private ExtendedWebElement vehicleFilter;

    @FindBy(xpath = "//android.widget.Button[@text=\"from €%s\"]")
    private ExtendedWebElement priceFromFilter;

    @FindBy(xpath = "//android.widget.Button[@text=\"to €%s\"]")
    private ExtendedWebElement priceToFilter;

    @FindBy(xpath = "//android.view.ViewGroup[@resource-id=\"de.mobile.android.app:id/toolbar\"]//android.widget.TextView")
    private ExtendedWebElement searchResultQuantity;

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public SearchResultPageBase closeSearchSavePopup() {
        closeSearchSavePopup.click();
        return initPage(driver, SearchResultPageBase.class);
    }

    @Override
    public boolean isVehicleFilterPresent(String vehicle) {
        return vehicleFilter.format(vehicle).isElementPresent();
    }

    @Override
    public boolean isPriceFromFilterPresent(String price) {
        return priceFromFilter
                .format(new DecimalFormat("###,###").format(Double.parseDouble(price)).replace("\u00a0", ","))
                .isElementPresent();
    }

    @Override
    public boolean isPriceToFilterPresent(String price) {
        return priceToFilter
                .format(new DecimalFormat("###,###").format(Double.parseDouble(price)).replace("\u00a0", ","))
                .isElementPresent();
    }

    @Override
    public boolean isResultMoreThanZero() {
        return Integer.parseInt(searchResultQuantity.getText().split(" ")[0]) > 0;
    }
}
