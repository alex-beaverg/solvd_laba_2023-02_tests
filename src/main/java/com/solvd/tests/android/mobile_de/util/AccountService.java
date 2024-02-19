package com.solvd.tests.android.mobile_de.util;

import com.solvd.tests.android.mobile_de.domain.Account;
import com.solvd.tests.android.mobile_de.domain.Accounts;
import com.solvd.tests.android.mobile_de.pages.AuthenticationPage;
import com.solvd.tests.android.mobile_de.pages.common.HomePageBase;
import com.zebrunner.carina.utils.R;
import org.openqa.selenium.WebDriver;

public class AccountService {

    public Account createAccount(Accounts account) {
        if (account.equals(Accounts.VALID_ACCOUNT)) {
            return new Account(
                    R.TESTDATA.get("android.mobile_de.account.valid.email"),
                    R.TESTDATA.get("android.mobile_de.account.valid.pass"));
        } else {
            return new Account(
                    R.TESTDATA.get("android.mobile_de.account.invalid.email"),
                    R.TESTDATA.get("android.mobile_de.account.invalid.pass"));
        }
    }

    public HomePageBase login(WebDriver driver, Account account) {
        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
        authenticationPage.typeEmail(account.getEmail());
        authenticationPage.typePass(account.getPass());
        return authenticationPage.clickLoginButton();
    }
}
