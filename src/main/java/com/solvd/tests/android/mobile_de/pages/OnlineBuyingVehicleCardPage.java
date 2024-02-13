package com.solvd.tests.android.mobile_de.pages;

import com.solvd.tests.android.mobile_de.pages.common.OnlineBuyingVehicleCardPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = OnlineBuyingVehicleCardPageBase.class)
public class OnlineBuyingVehicleCardPage extends OnlineBuyingVehicleCardPageBase {

    @FindBy(xpath = "//android.widget.TextView[@text=\"Continue to order\"]")
    private ExtendedWebElement continueToOrderButton;

    @FindBy(xpath = "//android.widget.TextView[@text=\"from\"]/preceding-sibling::android.widget.TextView[1]")
    private ExtendedWebElement vehicleCardModel;

    @FindBy(xpath = "//android.widget.TextView[@text=\"from\"]/preceding-sibling::android.widget.TextView[2]")
    private ExtendedWebElement vehicleCardPrice;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Mileage\"]/parent::*/following-sibling::android.widget.TextView[1]")
    private ExtendedWebElement vehicleCardMileage;

    @FindBy(xpath = "//android.widget.TextView[@text=\"First registration\"]/following-sibling::android.widget.TextView[1]")
    private ExtendedWebElement vehicleCardFirstRegistration;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Performance\"]/following-sibling::android.widget.TextView[1]")
    private ExtendedWebElement vehicleCardPerformance;

    public OnlineBuyingVehicleCardPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getVehicleCardModelText() {
        return vehicleCardModel.getText().strip();
    }

    @Override
    public double getVehicleCardPriceValue() {
        return Double.parseDouble(vehicleCardPrice.getText()
                .replace(" €", "")
                .replace(".", "")
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
    public String getVehicleCardFirstRegistrationText() {
        return vehicleCardFirstRegistration.getText().strip();
    }

    @Override
    public String getVehicleCardPerformanceText() {
        return vehicleCardPerformance.getText().strip().replace("\u00a0", " ");
    }

    @Override
    public ExtendedWebElement getVehicleCardPerformance() {
        return vehicleCardPerformance;
    }

    @Override
    public boolean isPageOpened() {
        return continueToOrderButton.isElementPresent();
    }
}
