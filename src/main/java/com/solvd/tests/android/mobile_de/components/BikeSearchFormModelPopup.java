package com.solvd.tests.android.mobile_de.components;

import com.solvd.tests.android.mobile_de.components.common.BikeSearchFormAddVehiclePopupBase;
import com.solvd.tests.android.mobile_de.components.common.BikeSearchFormBase;
import com.solvd.tests.android.mobile_de.components.common.BikeSearchFormModelPopupBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = BikeSearchFormModelPopupBase.class)
public class BikeSearchFormModelPopup extends BikeSearchFormModelPopupBase {

    @FindBy(xpath = "//android.widget.Button[@resource-id=\"de.mobile.android.app:id/add_new_make_model\"]")
    private ExtendedWebElement addVehicleLink;

    @FindBy(xpath = "//android.widget.Button[@resource-id=\"de.mobile.android.app:id/ok\"]")
    private ExtendedWebElement okButton;

    public BikeSearchFormModelPopup(WebDriver driver) {
        super(driver);
    }

    @Override
    public BikeSearchFormAddVehiclePopupBase clickAddVehicleLink() {
        addVehicleLink.click();
        return initPage(driver, BikeSearchFormAddVehiclePopupBase.class);
    }

    @Override
    public BikeSearchFormBase clickOkButton() {
        okButton.click();
        return initPage(driver, BikeSearchFormBase.class);
    }
}
