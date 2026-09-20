package com.saucedemo.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.saucedemo.base.TestBase;
import com.saucedemo.pages.InventoryPage;
import com.saucedemo.pages.LoginPage;

public class InventoryTest extends TestBase {

    private LoginPage loginPage;
    private InventoryPage inventoryPage;

    @BeforeMethod
    public void loginBeforeTest() {
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        loginPage.login("standard_user", "secret_sauce");
    }

    @Test(priority = 1, description = "TC_INV_001: Verify product catalog displays 6 items")
    public void testProductCount() {
        int count = inventoryPage.getProductCount();
        Assert.assertEquals(count, 6, "Inventory product count is not 6.");
    }

    @Test(priority = 2, description = "TC_CART_001: Verify adding a single item updates badge")
    public void testAddToCartBadgeUpdate() {
        inventoryPage.addBackpackToCart();
        String badgeCount = inventoryPage.getCartBadgeCount();
        Assert.assertEquals(badgeCount, "1", "Cart badge count mismatch after adding item.");
    }

    @Test(priority = 3, description = "TC_INV_002: Verify sorting: Price low to high")
    public void testSortPriceLowToHigh() {
        inventoryPage.selectSortOption("Price (low to high)");
        String firstItemPrice = inventoryPage.getFirstProductPrice();
        Assert.assertEquals(firstItemPrice, "$7.99", "Sorting price low to high failed.");
    }
}