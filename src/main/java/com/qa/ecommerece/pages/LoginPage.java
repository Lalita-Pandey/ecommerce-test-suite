package com.qa.ecommerece.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    @FindBy(css = "input[data-qa='login-email']")
    WebElement emailField;

    @FindBy(css = "input[data-qa='login-password']")
    WebElement passwordField;

    @FindBy(css = "button[data-qa='login-button']")
    WebElement loginButton;

    @FindBy(css = "a[href='/logout']")
    WebElement logoutLink;

    @FindBy(css = "p[style='color: red;']")
    WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterEmail(String email) {
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickLogin() {
        loginButton.click();
    }

    public boolean  isErrorMessageDisplayed(){
        return errorMessage.isDisplayed();

    }


    public boolean isLoggedIn() {
        return logoutLink.isDisplayed();
    }

    public void clickLogout() {
        logoutLink.click();
    }
}
