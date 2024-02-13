package com.solvd.tests.web.web_util;

import com.solvd.tests.web.domain.User;
import com.solvd.tests.web.domain.Users;
import com.solvd.tests.web.components.header.dropdown.LoginHeader;
import com.solvd.tests.web.pages.MyAccountPage;
import org.openqa.selenium.WebDriver;

public class LoginService {

    public User createUser(Users user) {
        return new User(user.getEmail(), user.getPass());
    }

    public MyAccountPage login(User user, WebDriver driver) {
        LoginHeader loginHeader = new LoginHeader(driver);
        loginHeader.typeEmail(user);
        loginHeader.typePass(user);
        return loginHeader.clickLoginButton();
    }
}
