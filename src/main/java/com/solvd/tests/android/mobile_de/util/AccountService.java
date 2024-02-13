package com.solvd.tests.android.mobile_de.util;

import com.solvd.tests.android.mobile_de.domain.Account;
import com.solvd.tests.android.mobile_de.domain.Accounts;
import com.solvd.tests.android.mobile_de.pages.AuthenticationPage;
import com.solvd.tests.android.mobile_de.pages.common.HomePageBase;
import org.openqa.selenium.WebDriver;

public class AccountService {

    public Account createAccount(Accounts account) {
        return new Account(account.getEmail(), account.getPass());
    }

    public HomePageBase login(WebDriver driver, Account account) {
        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
        authenticationPage.typeEmail(account.getEmail());
        authenticationPage.typePass(account.getPass());
        return authenticationPage.clickLoginButton();
    }
}
