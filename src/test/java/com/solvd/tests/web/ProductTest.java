package com.solvd.tests.web;

import com.solvd.tests.web.domain.ProductCard;
import com.solvd.tests.web.pages.ProductPage;
import com.solvd.tests.web.pages.ProductsPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ProductTest extends BaseTest {

    @Test(description = "Verify product card", enabled = true)
    public void verifyProductCardTest() {
        SoftAssert sa = new SoftAssert();

        ProductsPage productsPage = getAndroidProductsPage();
        int productIndex = 0;

        ProductCard cardFromProductsPage = productsPage.getProductCardByIndex(productIndex);

        ProductPage productPage = productsPage.clickProductElement(productIndex);
        sa.assertTrue(productPage.isPageOpened(), "Product Page isn't open!");

        ProductCard cardFromProductPage = productPage.getProductCard();
        sa.assertEquals(cardFromProductsPage, cardFromProductPage, "Product on Products page isn't equal product on Product page!");

        sa.assertAll();
    }
}
