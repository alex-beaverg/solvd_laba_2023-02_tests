package com.solvd.tests.android.mobile_de.pages;

import com.solvd.tests.android.mobile_de.pages.common.CarParkPageBase;
import com.solvd.tests.android.mobile_de.pages.common.VehicleCardPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CarParkPageBase.class)
public class CarParkPage extends CarParkPageBase {

    @FindBy(xpath = "//android.view.ViewGroup[@resource-id=\"de.mobile.android.app:id/toolbar\"]/android.widget.TextView[1]")
    private ExtendedWebElement title;

    @FindBy(xpath = "(//android.widget.ImageView[@resource-id=\"de.mobile.android.app:id/button_popup_menu\"])[1]")
    private ExtendedWebElement firstCardOptionsIcon;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"de.mobile.android.app:id/title\" and @text=\"Delete\"]")
    private ExtendedWebElement deleteCardButton;

    @FindBy(xpath = "(//android.view.ViewGroup[@resource-id=\"de.mobile.android.app:id/card_content\"])[1]")
    private ExtendedWebElement firstCard;

    public CarParkPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened(int quantity) {
        return this.isElementWithTextPresent(title, String.format("Car Park (%d)", quantity));
    }

    @Override
    public void clickFirstCardOptionsButton() {
        firstCardOptionsIcon.click();
    }

    @Override
    public CarParkPageBase clickDeleteCardButton() {
        deleteCardButton.click();
        return initPage(driver, CarParkPageBase.class);
    }

    @Override
    public CarParkPageBase deleteFirstCard() {
        clickFirstCardOptionsButton();
        return clickDeleteCardButton();
    }

    @Override
    public VehicleCardPageBase clickFirstCard() {
        firstCard.click();
        return initPage(driver, VehicleCardPageBase.class);
    }
}
