package com.solvd.tests.web.pages;

import com.solvd.tests.web.domain.ProductCard;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {

    @FindBy(xpath = "//h1[@class='product-name']")
    private ExtendedWebElement productNameElement;

    @FindBy(xpath = "//div[@class='price-wrap']//div[@class='price']")
    private ExtendedWebElement productPriceElement;

    public ProductPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(productNameElement);
    }

    public String getProductNameElementText() {
        return productNameElement.getText();
    }

    public Double getProductPriceElementText() {
        return Double.valueOf(productPriceElement.getText().replace('€', ' '));
    }

    public ProductCard getProductCard() {
        return new ProductCard(getProductNameElementText(), getProductPriceElementText());
    }
}
