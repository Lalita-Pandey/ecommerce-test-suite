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
                "Login Failed");
    }

    @Test
    public void logoutTest(){
        HomePage homePage = new HomePage(driver);
        homePage.clickSignupLogin();

        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterEmail(ConfigReader.get("email"));
        loginPage.enterPassword(ConfigReader.get("password"));

        loginPage.clickLogin();

        loginPage.clickLogout();

        Assert.assertTrue(driver.getCurrentUrl().contains("login"),
                "logout failed");

    }

    @Test
    public void invalidLoginTest() {

    HomePage homePage = new HomePage(driver);
    homePage.clickSignupLogin();

        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterEmail("xyz@gmail.com");
        loginPage.enterPassword("Abcd@1234");

        loginPage.clickLogin();

    Assert.assertTrue(loginPage.isErrorMessageDisplayed(),
            "Login Failed");


    }

    @Test
    public void isEmailEmpty() {
        HomePage homePage = new HomePage(driver);
        homePage.clickSignupLogin();

        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterEmail("");
        loginPage.enterPassword("Abcd@1234");

        loginPage.clickLogin();

        driver.getCurrentUrl();

        Assert.assertTrue(driver.getCurrentUrl().contains("login"),
                "Assertion Failed: User should remain on login page when email is empty but navigated away");



    }

    @Test
    public void isPasswordEmpty() {
        HomePage homePage = new HomePage(driver);
        homePage.clickSignupLogin();

        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterEmail(ConfigReader.get("email"));
        loginPage.enterPassword("");

        loginPage.clickLogin();

        driver.getCurrentUrl();

        Assert.assertTrue(driver.getCurrentUrl().contains("login"),
                "Assertion Failed: User should remain on login page when password is empty but navigated away");



    }

}
