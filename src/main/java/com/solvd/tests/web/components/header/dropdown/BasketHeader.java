package com.solvd.tests.web.components.header.dropdown;

import com.solvd.tests.web.components.body.PopUpConfirmation;
import com.solvd.tests.web.domain.ProductCard;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class BasketHeader extends AbstractUIObject {

    @FindBy(xpath = "//div[@id='ItemsInBasket']")
    private ExtendedWebElement title;

    @FindBy(xpath = "//div[@class='single-item']//header//div")
    private List<ExtendedWebElement> basketItemNameElements;

    @FindBy(xpath = "//div[@class='single-item']//div[@class='price']")
    private List<ExtendedWebElement> basketItemPriceElements;

    @FindBy(xpath = "//div[@class='basket-products-list']//footer//div//div//div[2]")
    private ExtendedWebElement basketTotalPriceElement;

    @FindBy(xpath = "//div[@class='single-item']//header//button[@data-id]")
    private ExtendedWebElement deleteFirstItemFromBasketButton;

    public BasketHeader(WebDriver driver) {
        super(driver);
    }

    public boolean isTitleElementPresent() {
        return title.isElementPresent(1);
    }

    public String getTitleText() {
        return title.getText();
    }

    public List<String> getBasketItemNameElementTexts() {
        List<String> names = new ArrayList<>();
        for (ExtendedWebElement element : basketItemNameElements) {
            names.add(element.getText());
        }
        return names;
    }

    public String getBasketItemName(int index) {
        return getBasketItemNameElementTexts().get(index);
    }

    public List<Double> getBasketItemPriceElementValues() {
        List<Double> prices = new ArrayList<>();
        for (ExtendedWebElement element : basketItemPriceElements) {
            prices.add(Double.valueOf(element.getText().replace('€', ' ')));
        }
        return prices;
    }

    public Double getBasketItemPrice(int index) {
        return getBasketItemPriceElementValues().get(index);
    }

    public PopUpConfirmation clickDeleteFirstItemFromBasketButton() {
        deleteFirstItemFromBasketButton.click();
        return new PopUpConfirmation(driver);
    }

    public ProductCard getProductCardByIndex(int index) {
        return new ProductCard(getBasketItemName(index), getBasketItemPrice(index));
    }
}
