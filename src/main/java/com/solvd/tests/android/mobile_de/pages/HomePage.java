package com.solvd.tests.android.mobile_de.pages;

import com.solvd.tests.android.mobile_de.pages.common.HomePageBase;
import com.solvd.tests.android.mobile_de.pages.common.VehicleCardPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {
    private final String titleXpath = "//android.widget.TextView[@text=\"Home\"]";

    @FindBy(xpath = titleXpath)
    private ExtendedWebElement title;

    @FindBy(id = "consent_accept_button")
    private ExtendedWebElement acceptPrivacyButton;

    @FindBy(xpath = "(//android.view.ViewGroup[@resource-id=\"de.mobile.android.app:id/hf_listing\"])[1]")
    private ExtendedWebElement firstVehicleCard;

    @FindBy(xpath = "(//android.widget.TextView[@resource-id=\"de.mobile.android.app:id/hf_listing_makemodel\"])[1]")
    private ExtendedWebElement firstVehicleCardModel;

    @FindBy(xpath = "(//android.widget.TextView[@resource-id=\"de.mobile.android.app:id/hf_price\"])[1]")
    private ExtendedWebElement firstVehicleCardPrice;

    @FindBy(xpath = "(//android.widget.TextView[@resource-id=\"de.mobile.android.app:id/hf_mileage\"])[1]")
    private ExtendedWebElement firstVehicleCardMileage;

    @FindBy(xpath = "(//android.widget.TextView[@resource-id=\"de.mobile.android.app:id/hf_listing_location\"])[1]")
    private ExtendedWebElement firstVehicleCardAddress;

    @FindBy(xpath = "(//android.widget.ImageView[@resource-id=\"de.mobile.android.app:id/hf_img_parking\"])[%d]")
    private ExtendedWebElement addCarToCarParkIcon;

    @FindBy(xpath = "//android.widget.Button[@resource-id=\"android:id/button2\"]")
    private ExtendedWebElement cancelNotificationsButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void clickAcceptPrivacyButton() {
        acceptPrivacyButton.click();
    }

    @Override
    public VehicleCardPageBase clickFirstVehicleCard() {
        firstVehicleCard.click();
        return initPage(driver, VehicleCardPageBase.class);
    }

    @Override
    public boolean isPageOpened() {
        return this.isElementWithTextPresent(title, "Home");
    }

    @Override
    public String getFirstVehicleCardModelText() {
        return firstVehicleCardModel.getText();
    }

    @Override
    public double getFirstVehicleCardPriceValue() {
        return Double.parseDouble(firstVehicleCardPrice.getText()
                .replace("€", "")
                .replace(",", "")
                .replace("\u00a0\u00B2", "")
        );
    }

    @Override
    public double getFirstVehicleCardMileageValue() {
        return Double.parseDouble(firstVehicleCardMileage.getText()
                .replace("\u00a0km", "")
                .replace(",", "")
        );
    }

    @Override
    public String getFirstVehicleCardAddressText() {
        return firstVehicleCardAddress.getText();
    }

    @Override
    public HomePageBase clickAddCarToCarPark(int quantity) {
        for (int i = 1; i <= quantity; i++) {
            addCarToCarParkIcon.format(i).click();
            clickCancelNotificationsButton();
        }
        return initPage(driver, HomePageBase.class);
    }

    @Override
    public void clickCancelNotificationsButton() {
        if (cancelNotificationsButton.isElementPresent(3)) {
            cancelNotificationsButton.click();
        }
    }
}
