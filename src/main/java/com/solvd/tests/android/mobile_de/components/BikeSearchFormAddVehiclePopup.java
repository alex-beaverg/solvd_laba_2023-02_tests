package com.solvd.tests.android.mobile_de.components;

import com.solvd.tests.android.mobile_de.components.common.BikeSearchFormAddVehiclePopupBase;
import com.solvd.tests.android.mobile_de.components.common.BikeSearchFormModelPopupBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = BikeSearchFormAddVehiclePopupBase.class)
public class BikeSearchFormAddVehiclePopup extends BikeSearchFormAddVehiclePopupBase {

    @FindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"de.mobile.android.app:id/name\" and @text=\"%s\"]")
    private ExtendedWebElement vehicleItem;

    public BikeSearchFormAddVehiclePopup(WebDriver driver) {
        super(driver);
    }

    @Override
    public BikeSearchFormModelPopupBase clickVehicleItem(String vehicle) {
        vehicleItem.format(vehicle).click();
        return initPage(driver, BikeSearchFormModelPopupBase.class);
    }

    @Override
    public ExtendedWebElement getVehicleItem(String vehicle) {
        return vehicleItem.format(vehicle);
    }
}
