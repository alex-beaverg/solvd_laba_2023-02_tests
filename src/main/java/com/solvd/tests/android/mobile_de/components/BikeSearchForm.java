package com.solvd.tests.android.mobile_de.components;

import com.solvd.tests.android.mobile_de.components.common.BikeSearchFormBase;
import com.solvd.tests.android.mobile_de.components.common.BikeSearchFormModelPopupBase;
import com.solvd.tests.android.mobile_de.components.common.BikeSearchFormPricePopupBase;
import com.solvd.tests.android.mobile_de.pages.common.SearchResultPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = BikeSearchFormBase.class)
public class BikeSearchForm extends BikeSearchFormBase {

    @FindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id=\"de.mobile.android.app:" +
            "id/criteria_list\"]/android.widget.LinearLayout[1]")
    private ExtendedWebElement modelElement;

    @FindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id=\"de.mobile.android.app:" +
            "id/criteria_list\"]/android.widget.FrameLayout[2]")
    private ExtendedWebElement priceElement;

    @FindBy(xpath = "//android.widget.Button[@resource-id=\"de.mobile.android.app:id/show_results\"]")
    private ExtendedWebElement showResultsButton;

    public BikeSearchForm(WebDriver driver) {
        super(driver);
    }

    @Override
    public BikeSearchFormModelPopupBase clickModelElement() {
        modelElement.click();
        return initPage(driver, BikeSearchFormModelPopupBase.class);
    }

    @Override
    public BikeSearchFormPricePopupBase clickPriceElement() {
        priceElement.click();
        return initPage(driver, BikeSearchFormPricePopupBase.class);
    }

    @Override
    public SearchResultPageBase clickShowResultsButton() {
        showResultsButton.click();
        return initPage(driver, SearchResultPageBase.class);
    }
}
