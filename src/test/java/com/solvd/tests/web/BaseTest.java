package com.solvd.tests.web;

import com.solvd.tests.web.components.header.dropdown.MobilePhonesHeader;
import com.solvd.tests.web.pages.HomePage;
import com.solvd.tests.web.pages.ProductsPage;
import com.zebrunner.carina.core.AbstractTest;
import org.testng.asserts.SoftAssert;

public class BaseTest extends AbstractTest {

    public HomePage getHomePage() {
        SoftAssert sa = new SoftAssert();

        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        sa.assertTrue(homePage.isPageOpened(), "Home Page isn't open!");

        if (homePage.isAcceptCookiesButtonPresent()) {
            homePage.clickAcceptCookiesButton();
        }
        return homePage;
    }

    public ProductsPage getAndroidProductsPage() {
        SoftAssert sa = new SoftAssert();
        HomePage homePage = getHomePage();

        MobilePhonesHeader mobilePhonesHeader = homePage.getMainHeader().getMainMenu().getMobilePhonesHeader();
        sa.assertTrue(mobilePhonesHeader.isTitleElementPresent(), "Mobile phones Header isn't drop down!");
        sa.assertEquals(mobilePhonesHeader.getTitleText(), "Mobile Phones", "Mobile phones Header Title doesn't contain expected text!");

        ProductsPage productsPage = mobilePhonesHeader.clickAndroidButton();
        sa.assertTrue(productsPage.isPageOpened());

        return productsPage;
    }
}
