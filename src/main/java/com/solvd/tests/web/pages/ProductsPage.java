package com.solvd.tests.web.pages;

import com.solvd.tests.web.domain.ProductCard;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ProductsPage extends BasePage {

    @FindBy(xpath = "//select[@id='sort']")
    private ExtendedWebElement selectSortElement;

    @FindBy(xpath = "//div[@class='products-list']//h5/a")
    private List<ExtendedWebElement> productNameElements;

    @FindBy(xpath = "//div[@class='price']//div[1]")
    private List<ExtendedWebElement> productPriceElements;

    @FindBy(xpath = "//div[@class='products-list']//footer//button")
    private List<ExtendedWebElement> addProductToBasketButtonElements;

    public ProductsPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(selectSortElement);
    }

    public List<String> getProductNameElementTexts() {
        List<String> names = new ArrayList<>();
        for (ExtendedWebElement element : productNameElements) {
            names.add(element.getText());
        }
        return names;
    }

    public String getProductName(int index) {
        return getProductNameElementTexts().get(index);
    }

    public ProductPage clickProductElement(int index) {
        productNameElements.get(index).click();
        return new ProductPage(driver);
    }

    public List<Double> getProductPriceElementValues() {
        List<Double> prices = new ArrayList<>();
        for (ExtendedWebElement element : productPriceElements) {
            prices.add(Double.valueOf(element.getText().replace('€', ' ')));
        }
        return prices;
    }

    public Double getProductPrice(int index) {
        return getProductPriceElementValues().get(index);
    }

    public ProductsPage clickAddProductToBasketButton(int index) {
        productNameElements.get(index).hover();
        addProductToBasketButtonElements.get(index).click();
        return this;
    }

    public ProductCard getProductCardByIndex(int index) {
        return new ProductCard(getProductName(index), getProductPrice(index));
    }
}
