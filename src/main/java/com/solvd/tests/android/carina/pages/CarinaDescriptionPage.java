package com.solvd.tests.android.carina.pages;

import com.solvd.tests.android.carina.common.CarinaDescriptionPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CarinaDescriptionPageBase.class)
public class CarinaDescriptionPage extends CarinaDescriptionPageBase {

    @FindBy(id = "content_frame")
    private ExtendedWebElement webViewContent;

    public CarinaDescriptionPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return webViewContent.isElementPresent();
    }
}
