package com.saucedemo.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {

    private WebDriver driver;

    // Locators
    private By cartItemRows   = By.className("cart_item");
    private By checkoutButton = By.id("checkout");
    private By removeBackpack = By.id("remove-sauce-labs-backpack");
    private By itemName       = By.className("inventory_item_name");

    // Constructor
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    // Page Actions
    public int getCartItemCount() {
        List<WebElement> items = driver.findElements(cartItemRows);
        return items.size();
    }

    public String getFirstItemName() {
        return driver.findElement(itemName).getText();
    }

    public void clickCheckout() {
        driver.findElement(checkoutButton).click();
    }

    public void removeBackpack() {
        driver.findElement(removeBackpack).click();
    }
}