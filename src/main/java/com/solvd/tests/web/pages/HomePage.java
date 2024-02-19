package com.solvd.tests.web.pages;

import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
        setPageAbsoluteURL(R.CONFIG.get("EXAMPLE.home_url"));
    }

    @Override
    public void open() {
        super.openURL(Configuration.getRequired("home_url"));
    }
}
