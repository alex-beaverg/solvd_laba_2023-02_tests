package com.solvd.tests.android.mobile_de.pages;

import com.solvd.tests.android.mobile_de.pages.common.VehicleCardPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = VehicleCardPageBase.class)
public class VehicleCardPage extends VehicleCardPageBase {

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"de.mobile.android.app:id/model_title\"]")
    private ExtendedWebElement modelTitle;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"de.mobile.android.app:id/make_title\"]")
    private ExtendedWebElement vehicleCardModel;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"de.mobile.android.app:id/price_v1\"]")
    private ExtendedWebElement vehicleCardPrice;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Mileage\"]/following-sibling::android.widget.TextView")
    private ExtendedWebElement vehicleCardMileage;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"de.mobile.android.app:id/tv_dealer_address\"]")
    private ExtendedWebElement vehicleCardAddress;

    public VehicleCardPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getVehicleCardModelText() {
        return vehicleCardModel.getText();
    }

    @Override
    public double getVehicleCardPriceValue() {
        return Double.parseDouble(vehicleCardPrice.getText()
                .replace("€", "")
                .replace(",", "")
                .replace("\u00a0\u00B2", "")
        );
    }

    @Override
    public double getVehicleCardMileageValue() {

        return Double.parseDouble(vehicleCardMileage.getText()
                .replace("\u00a0km", "")
                .replace(",", "")
        );
    }

    @Override
    public String getVehicleCardAddressText() {
        return vehicleCardAddress.getText()
                .substring(vehicleCardAddress.getText().indexOf("DE-"))
                .replace("\u00a0", " ");
    }

    @Override
    public ExtendedWebElement getVehicleCardAddress() {
        return vehicleCardAddress;
    }

    @Override
    public boolean isPageOpened() {
        return modelTitle.isElementPresent();
    }
}
