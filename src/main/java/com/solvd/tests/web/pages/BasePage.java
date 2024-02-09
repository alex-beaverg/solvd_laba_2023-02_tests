package com.solvd.tests.web.pages;

import com.solvd.tests.web.components.footer.Footer;
import com.solvd.tests.web.components.header.MainHeader;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class BasePage extends AbstractPage {

    @FindBy(xpath = "//a[@class='button db ghost']")
    private ExtendedWebElement acceptCookiesButton;

    @FindBy(xpath = "//header[@class='main-header']")
    private MainHeader mainHeader;

    @FindBy(xpath = "//div[@class='footer-logo']")
    private ExtendedWebElement footerLogoElement;

    @FindBy(xpath = "//footer[@class='main-footer']")
    private Footer mainFooter;

    @FindBy(xpath = "//div[@class='footer-txt']")
    private ExtendedWebElement txtFooter;

    public BasePage(WebDriver driver) {
        super(driver);
    }

    public boolean isAcceptCookiesButtonPresent() {
        return acceptCookiesButton.isElementPresent();
    }

    public BasePage clickAcceptCookiesButton() {
        acceptCookiesButton.click();
        return this;
    }

    public MainHeader getMainHeader() {
        return mainHeader;
    }

    public boolean isFooterLogoElementVisibleInViewport() {
        return (Boolean)((JavascriptExecutor)getDriver()).executeScript(
                "let elem = arguments[0];" +
                      "let box = elem.getBoundingClientRect();" +
                      "let cx = box.left + box.width / 2;" +
                      "let cy = box.top + box.height / 2;" +
                      "let e = document.elementFromPoint(cx, cy);" +
                      "for( ; e; e = e.parentElement)" +
                          "{" +
                              "if(e === elem) return true;" +
                          "}" +
                      "return false;"
                , footerLogoElement.getElement());
    }

    public Footer getMainFooter() {
        return mainFooter;
    }

    public ExtendedWebElement getTxtFooter() {
        return txtFooter;
    }
}
