package com.saucedemo.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class InventoryPage {

    private WebDriver driver;

    // Locators
    private By pageTitle         = By.className("title");
    private By inventoryItems    = By.className("inventory_item");
    private By sortDropdown      = By.className("product_sort_container");
    private By cartBadge         = By.className("shopping_cart_badge");
    private By addToCartBackpack = By.id("add-to-cart-sauce-labs-backpack");
    private By removeBackpack    = By.id("remove-sauce-labs-backpack");
    private By itemPrices        = By.className("inventory_item_price");

    // Constructor
    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    // Page Actions
    public String getPageTitleText() {
        return driver.findElement(pageTitle).getText();
    }

    public int getProductCount() {
        List<WebElement> items = driver.findElements(inventoryItems);
        return items.size();
    }

    public void addBackpackToCart() {
        driver.findElement(addToCartBackpack).click();
    }

    public void removeBackpackFromCart() {
        driver.findElement(removeBackpack).click();
    }

    public String getCartBadgeCount() {
        return driver.findElement(cartBadge).getText();
    }

    public void selectSortOption(String visibleText) {
        Select select = new Select(driver.findElement(sortDropdown));
        select.selectByVisibleText(visibleText);
    }

    public String getFirstProductPrice() {
        List<WebElement> prices = driver.findElements(itemPrices);
        return prices.get(0).getText();
    }
}