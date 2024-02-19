package com.solvd.tests.android.mobile_de.pages;

import com.solvd.tests.android.mobile_de.pages.common.OnlineBuyingPageBase;
import com.solvd.tests.android.mobile_de.pages.common.OnlineBuyingVehicleCardPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = OnlineBuyingPageBase.class)
public class OnlineBuyingPage extends OnlineBuyingPageBase {

    @FindBy(xpath = "//android.widget.Button[@resource-id=\"de.mobile.android.app:id/chip_dutchman_item\" " +
            "and @text=\"Online-Buying\"]")
    private ExtendedWebElement onlineBuyingFilter;

    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]")
    private ExtendedWebElement closeSearchSavePopup;

    @FindBy(xpath = "(//android.widget.LinearLayout[@resource-id=\"de.mobile.android.app:" +
            "id/item_container\"])[1]/android.widget.LinearLayout[1]")
    private ExtendedWebElement firstVehicleCard;

    @FindBy(xpath = "(//android.widget.LinearLayout[@resource-id=\"de.mobile.android.app:" +
            "id/ad_headline_and_price\"])[1]/android.widget.TextView[1]")
    private ExtendedWebElement firstVehicleCardModel;

    @FindBy(xpath = "(//android.widget.LinearLayout[@resource-id=\"de.mobile.android.app:" +
            "id/ad_headline_and_price\"])[1]/android.widget.LinearLayout[2]/android.widget.TextView")
    private ExtendedWebElement firstVehicleCardPrice;

    @FindBy(xpath = "(//android.widget.TextView[@resource-id=\"de.mobile.android.app:id/highlights\"])[1]" +
            "/preceding-sibling::android.widget.TextView")
    private ExtendedWebElement firstVehicleCardThreeElements;

    public OnlineBuyingPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public OnlineBuyingPageBase closeSearchSavePopup() {
        closeSearchSavePopup.click();
        return initPage(driver, OnlineBuyingPageBase.class);
    }

    @Override
    public OnlineBuyingVehicleCardPageBase clickFirstVehicleCard() {
        firstVehicleCard.click();
        return initPage(driver, OnlineBuyingVehicleCardPageBase.class);
    }

    @Override
    public String getFirstVehicleCardModelText() {
        return firstVehicleCardModel.getText().replace("\u00a0\u00a0New\u00a0\u00a0", "").strip();
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
        return Double.parseDouble(firstVehicleCardThreeElements.getText()
                .replace("Accident-free\u00a0• ", "")
                .split("\u00a0• ")[1]
                .replace("\u00a0km", "")
                .replace(",", "")
        );
    }

    @Override
    public String getFirstVehicleCardFirstRegistrationText() {
        return firstVehicleCardThreeElements.getText()
                .replace("Accident-free\u00a0• ", "")
                .split("\u00a0• ")[0]
                .replace("FR ", "");
    }

    @Override
    public String getFirstVehicleCardPerformanceText() {
        return firstVehicleCardThreeElements.getText()
                .replace("Accident-free\u00a0• ", "")
                .split("\u00a0• ")[2]
                .replace("\u00a0", " ");
    }

    @Override
    public boolean isPageOpened() {
        return this.isElementWithTextPresent(onlineBuyingFilter, "Online-Buying");
    }
}
