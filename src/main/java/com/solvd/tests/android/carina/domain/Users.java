package com.solvd.tests.android.carina.domain;

import com.zebrunner.carina.utils.R;

public enum Users {
    NEW_USER(
            R.TESTDATA.get("android.carina.user.name"),
            R.TESTDATA.get("android.carina.user.pass"),
            Sex.valueOf(R.TESTDATA.get("android.carina.user.sex")),
            Boolean.parseBoolean(R.TESTDATA.get("android.carina.user.privacy"))
    );

    private final String name;
    private final String password;
    private final Sex sex;
    private final boolean privacyPolicy;

    Users(String name, String password, Sex sex, boolean privacyPolicy) {
        this.name = name;
        this.password = password;
        this.sex = sex;
        this.privacyPolicy = privacyPolicy;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public Sex getSex() {
        return sex;
    }

    public boolean getPrivacyPolicy() {
        return privacyPolicy;
    }
}
