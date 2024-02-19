package com.solvd.tests.android.carina.util;

import com.solvd.tests.android.carina.common.CarinaDescriptionPageBase;
import com.solvd.tests.android.carina.domain.User;
import com.solvd.tests.android.carina.domain.Users;
import com.solvd.tests.android.carina.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class LoginService {

    public User createUser(Users user) {
        return new User(user.getName(), user.getPassword(), user.getSex(), user.getPrivacyPolicy());
    }

    public CarinaDescriptionPageBase signUp(WebDriver driver, User user) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeName(user.getName());
        loginPage.typePassport(user.getPassword());
        loginPage.selectSex(user.getSex());
        loginPage.switchPrivacyPolicy(user.getPrivacyPolicy());
        return loginPage.clickSignUpButton();
    }
}
