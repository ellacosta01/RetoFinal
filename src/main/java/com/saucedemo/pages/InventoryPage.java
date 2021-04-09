package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class InventoryPage {

    WebDriver driver;

    @FindAll(@FindBy(xpath = "//button[text()='Add to cart']"))
    List<WebElement> LIST_BUTTONS_ADD_TO_CART;

    @FindBy(id = "shopping_cart_container")
    WebElement ICON_SHOPPING_CART;

    public InventoryPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public int getNumberOfAddToCartButtons(){
        return LIST_BUTTONS_ADD_TO_CART.size();
    }

    public boolean shoppingCartIconIsDisplayed(){
        return ICON_SHOPPING_CART.isDisplayed();
    }

}
