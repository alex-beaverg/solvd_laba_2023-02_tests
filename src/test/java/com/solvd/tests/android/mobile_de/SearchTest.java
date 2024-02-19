package com.solvd.tests.android.mobile_de;

import com.solvd.tests.android.mobile_de.components.common.*;
import com.solvd.tests.android.mobile_de.domain.Search;
import com.solvd.tests.android.mobile_de.domain.Searches;
import com.solvd.tests.android.mobile_de.pages.common.HomePageBase;
import com.solvd.tests.android.mobile_de.pages.common.SearchPageBase;
import com.solvd.tests.android.mobile_de.pages.common.SearchResultPageBase;
import com.solvd.tests.android.mobile_de.util.SearchService;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

// (to execute these tests you may need check capabilities.app in _config.properties file)
public class SearchTest extends BaseTest {

    @Test(description = "Search bikes test", enabled = true)
    public void verifySearchBikesTest() {
        SoftAssert sa = new SoftAssert();

        SearchService searchService = new SearchService();
        Search search = searchService.createSearch(Searches.BIKE_SEARCH);

        HomePageBase homePage = getHomePage();

        MainMenuBase mainMenu = homePage.clickMainMenuButton();
        SearchPageBase searchPage = mainMenu.clickSearchMenuItem();
        sa.assertTrue(searchPage.isPageOpened(), "Search page wasn't opened!");

        BikeSearchFormBase bikeSearchForm = searchPage.clickSearchBikeIcon();

        // Adding bike model:
        BikeSearchFormModelPopupBase modelPopup = bikeSearchForm.clickModelElement();
        BikeSearchFormAddVehiclePopupBase addVehiclePopup = modelPopup.clickAddVehicleLink();
        swipe(addVehiclePopup.getVehicleItem(search.getVehicle()), Direction.UP);
        modelPopup = addVehiclePopup.clickVehicleItem(search.getVehicle());
        bikeSearchForm = modelPopup.clickOkButton();

        // Adding price borders:
        BikeSearchFormPricePopupBase pricePopup = bikeSearchForm.clickPriceElement();
        pricePopup.typePriceFrom(String.valueOf(search.getPriceFrom()));
        pricePopup.typePriceTo(String.valueOf(search.getPriceTo()));
        bikeSearchForm = pricePopup.clickOkButton();

        // Assert result filters:
        SearchResultPageBase searchResultPage = bikeSearchForm.clickShowResultsButton();
        searchResultPage = searchResultPage.closeSearchSavePopup();
        sa.assertTrue(searchResultPage.isVehicleFilterPresent(search.getVehicle()), "Vehicle filter wasn't found!");
        sa.assertTrue(searchResultPage.isPriceFromFilterPresent(String.valueOf(search.getPriceFrom())),
                "Price from filter wasn't found!");
        sa.assertTrue(searchResultPage.isPriceToFilterPresent(String.valueOf(search.getPriceTo())),
                "Price to filter wasn't found!");
        sa.assertTrue(searchResultPage.isResultMoreThanZero(), "Result can't be equal zero!");

        sa.assertAll();
    }
}
