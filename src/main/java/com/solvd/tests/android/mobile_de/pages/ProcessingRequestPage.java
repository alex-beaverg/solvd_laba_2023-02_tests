package com.solvd.tests.android.mobile_de.pages;

import com.solvd.tests.android.mobile_de.pages.common.ProcessingRequestPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProcessingRequestPageBase.class)
public class ProcessingRequestPage extends ProcessingRequestPageBase {

    @FindBy(xpath = "//android.view.View[contains(@text, \"Processing your request\")]")
    private ExtendedWebElement message;

    public ProcessingRequestPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened(long timeout) {
        return message.isElementPresent(timeout);
    }
}
