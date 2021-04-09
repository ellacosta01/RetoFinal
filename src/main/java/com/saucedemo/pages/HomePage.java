package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;
    String homePageUrl = "https://www.saucedemo.com/";

    @FindBy(id = "user-name")
    WebElement TXT_USERNAME;

    @FindBy(id = "password")
    WebElement TXT_PASSWORD;

    @FindBy(id = "login-button")
    WebElement BTN_LOGIN;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateToHomePage() {
        driver.get(homePageUrl);
    }

    public void writeUsername(String username) {
        TXT_USERNAME.sendKeys(username);
    }

    public void writePassword(String password) {
        TXT_PASSWORD.sendKeys(password);
    }

    public void clickOnLogin() {
        BTN_LOGIN.click();
    }

}
