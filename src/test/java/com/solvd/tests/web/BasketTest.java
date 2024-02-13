package com.solvd.tests.web;

import com.solvd.tests.web.components.body.PopUpConfirmation;
import com.solvd.tests.web.components.header.dropdown.BasketHeader;
import com.solvd.tests.web.domain.Basket;
import com.solvd.tests.web.domain.ProductCard;
import com.solvd.tests.web.pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class BasketTest extends BaseTest {
    private Basket basketFromProductsPage = new Basket();
    private Basket realBasket = new Basket();

    @Test(description = "Verify add products to basket", enabled = true)
    public void verifyAddProductsToBasketTest() {
        SoftAssert sa = new SoftAssert();

        ProductsPage productsPage = getAndroidProductsPage();
        int productQuantity = 3;
        BasketHeader basketHeader = addProductsToBasket(productsPage, productQuantity);

        assertBasket(basketHeader, productQuantity);

        sa.assertAll();
        clearBaskets();
    }

    @Test(description = "Verify remove products from basket", enabled = true)
    public void verifyRemoveProductsFromBasket() {
        SoftAssert sa = new SoftAssert();

        ProductsPage productsPage = getAndroidProductsPage();
        int productQuantity = 4;
        int productQuantityToDelete = 2;
        int difference = productQuantity - productQuantityToDelete;
        BasketHeader basketHeader = addProductsToBasket(productsPage, productQuantity);

        PopUpConfirmation popUpConfirmation;
        for (int i = 0; i < productQuantityToDelete; i++) {
            popUpConfirmation = basketHeader.clickDeleteFirstItemFromBasketButton();
            sa.assertTrue(popUpConfirmation.isTitleElementPresent(), "Pop-up element isn't find!");
            basketHeader = popUpConfirmation.clickConfirmDeleteFromBasketButton();
            sa.assertTrue(basketHeader.isTitleElementPresent(), "Basket element isn't find!");
            basketFromProductsPage.removeFirstProduct();
        }

        productsPage.refresh(1);
        basketHeader = productsPage.getMainHeader().getTopMenu().getBasket();

        assertBasket(basketHeader, difference);

        sa.assertAll();
        clearBaskets();
    }

    private BasketHeader addProductsToBasket(ProductsPage productsPage, int quantity) {
        SoftAssert sa = new SoftAssert();

        for (int i = 0; i < quantity; i++) {
            productsPage.clickAddProductToBasketButton(i);
            ProductCard productCard = productsPage.getProductCardByIndex(i);
            basketFromProductsPage.addProduct(productCard);
        }

        basketFromProductsPage.calculateAndSetTotalPrice();

        BasketHeader basketHeader = productsPage.getMainHeader().getTopMenu().getBasket();
        sa.assertTrue(basketHeader.isTitleElementPresent(), "Basket isn't drop down!");
        sa.assertTrue(basketHeader.getTitleText().endsWith("in your basket"), "Basket Title doesn't contain expected text!");
        Assert.assertEquals(basketFromProductsPage.getProducts().size(), quantity, "Basket item element quantity isn't equal expected quantity");

        return basketHeader;
    }

    private void assertBasket(BasketHeader basketHeader, int quantity) {
        SoftAssert sa = new SoftAssert();

        for (int i = 0; i < quantity; i++) {
            ProductCard productCard = basketHeader.getProductCardByIndex(i);
            realBasket.addProduct(productCard);
        }

        realBasket.calculateAndSetTotalPrice();

        sa.assertEquals(basketFromProductsPage, realBasket, "Basket from page isn't equal real basket!");
    }

    private void clearBaskets() {
        basketFromProductsPage = new Basket();
        realBasket = new Basket();
    }
}
