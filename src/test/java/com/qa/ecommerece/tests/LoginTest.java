package com.qa.ecommerece.tests;

import com.qa.ecommerece.pages.HomePage;
import com.qa.ecommerece.pages.LoginPage;
import com.qa.ecommerece.utils.BaseClass;
import com.qa.ecommerece.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseClass {

    @Test
    public void validLoginTest() {
        HomePage homePage = new HomePage(driver);
        homePage.clickSignupLogin();

        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterEmail(ConfigReader.get("email"));
        loginPage.enterPassword(ConfigReader.get("password"));

        loginPage.clickLogin();

        Assert.assertTrue(loginPage.isLoggedIn(),
                "Login successful nahi hua!");
    }
}
