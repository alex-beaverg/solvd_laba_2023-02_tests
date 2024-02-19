package com.solvd.tests.web.domain;

import com.zebrunner.carina.utils.R;

public enum Users {
    VALID(R.TESTDATA.get("web.user.valid.email"), R.TESTDATA.get("web.user.valid.pass")),
    INVALID(R.TESTDATA.get("web.user.invalid.email"), R.TESTDATA.get("web.user.invalid.pass"));

    private final String email;
    private final String pass;

    Users(String username, String pass) {
        this.email = username;
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public String getPass() {
        return pass;
    }
}
