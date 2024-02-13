package com.solvd.tests.android.mobile_de.util;

import com.solvd.tests.android.mobile_de.domain.Search;
import com.solvd.tests.android.mobile_de.domain.Searches;

public class SearchService {

    public Search createSearch(Searches search) {
        return new Search(
                search.getModel(),
                search.getPriceFrom(),
                search.getPriceTo());
    }
}
