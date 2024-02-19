package com.solvd.tests.android.carina.domain;

public class User {
    private final String name;
    private final String password;
    private final Sex sex;
    private final boolean privacyPolicy;

    public User(String name, String password, Sex sex, boolean privacyPolicy) {
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
