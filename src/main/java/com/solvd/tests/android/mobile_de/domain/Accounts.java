package com.solvd.tests.android.mobile_de.domain;

import com.zebrunner.carina.utils.R;

public enum Accounts {
    VALID_ACCOUNT(
            R.TESTDATA.get("android.mobile_de.account.valid.email"),
            R.TESTDATA.get("android.mobile_de.account.valid.pass")
    ),
    INVALID_ACCOUNT(
            R.TESTDATA.get("android.mobile_de.account.invalid.email"),
            R.TESTDATA.get("android.mobile_de.account.invalid.pass")
    );

    private final String email;
    private final String pass;

    Accounts(String email, String pass) {
        this.email = email;
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public String getPass() {
        return pass;
    }
}
