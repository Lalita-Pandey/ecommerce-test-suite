package com.qa.ecommerece.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;

    @FindBy(css = "a[href='/login']")
    WebElement signupLoginButton;

    @FindBy(css = "a[href='/products']")
    WebElement productsButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickSignupLogin() {
        signupLoginButton.click();
    }

    public void clickProducts() {
        productsButton.click();
    }
}
