package com.solvd.tests.android.mobile_de.components;

import com.solvd.tests.android.mobile_de.components.common.BikeSearchFormBase;
import com.solvd.tests.android.mobile_de.components.common.BikeSearchFormPricePopupBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = BikeSearchFormPricePopupBase.class)
public class BikeSearchFormPricePopup extends BikeSearchFormPricePopupBase {

    @FindBy(xpath = "//android.widget.EditText[@resource-id=\"de.mobile.android.app:id/fromInput\"]")
    private ExtendedWebElement priceFromInput;

    @FindBy(xpath = "//android.widget.EditText[@resource-id=\"de.mobile.android.app:id/toInput\"]")
    private ExtendedWebElement priceToInput;

    @FindBy(xpath = "//android.widget.Button[@resource-id=\"de.mobile.android.app:id/ok\"]")
    private ExtendedWebElement okButton;

    public BikeSearchFormPricePopup(WebDriver driver) {
        super(driver);
    }

    @Override
    public void typePriceFrom(String priceFrom) {
        priceFromInput.type(priceFrom);
    }

    @Override
    public void typePriceTo(String priceTo) {
        priceToInput.type(priceTo);
    }

    @Override
    public BikeSearchFormBase clickOkButton() {
        okButton.click();
        return initPage(driver, BikeSearchFormBase.class);
    }


}
