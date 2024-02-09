package com.solvd.tests.web;

import com.solvd.tests.web.components.footer.elements.AssistanceMenuItem;
import com.solvd.tests.web.pages.HomePage;
import com.solvd.tests.web.pages.SomeInfoPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class ScrollTest extends BaseTest {

    @Test(description = "Verify scroll pages", enabled = true)
    public void verifyScrollPagesTest() {
        SoftAssert sa = new SoftAssert();
        HomePage homePage = getHomePage();

        List<AssistanceMenuItem> items = homePage.getMainFooter().getAssistanceMenu().getItems();

        for (int i = 0; i < items.size(); i++) {
            SomeInfoPage someInfoPage = items.get(i).clickItem();
            sa.assertTrue(someInfoPage.isTitleElementPresent(), "Page isn't open!");

            someInfoPage.getTxtFooter().scrollTo();

            sa.assertTrue(homePage.isFooterLogoElementVisibleInViewport(), "Element isn't visible in viewport!");
        }

        sa.assertAll();
    }
}
