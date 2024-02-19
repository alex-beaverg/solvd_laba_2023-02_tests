package com.solvd.tests.android.mobile_de.domain;

public class Account {
    private final String email;
    private final String pass;

    public Account(String email, String pass) {
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
