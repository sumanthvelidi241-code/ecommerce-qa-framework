package com.saucedemo.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.saucedemo.base.TestBase;
import com.saucedemo.pages.CartPage;
import com.saucedemo.pages.CheckoutPage;
import com.saucedemo.pages.InventoryPage;
import com.saucedemo.pages.LoginPage;

public class E2ETest extends TestBase {

    private LoginPage loginPage;
    private InventoryPage inventoryPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;

    @BeforeMethod
    public void setupTest() {
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        
        loginPage.login("standard_user", "secret_sauce");
    }

    @Test(priority = 1, description = "TC_CHK_005: End-to-End happy path purchase flow")
    public void testCompleteCheckoutFlow() {
        // 1. Add item to cart and open cart
        inventoryPage.addBackpackToCart();
        driver.get(BASE_URL + "cart.html");

        // 2. Proceed to checkout
        cartPage.clickCheckout();

        // 3. Enter information and continue
        checkoutPage.enterInformation("Sumanth", "QA", "560001");
        checkoutPage.clickContinue();

        // 4. Validate order summary breakdown and finish
        Assert.assertTrue(checkoutPage.getItemTotalText().contains("$29.99"), "Item total mismatch.");
        checkoutPage.clickFinish();

        // 5. Assert successful order confirmation
        String confirmation = checkoutPage.getOrderCompleteMessage();
        Assert.assertEquals(confirmation, "Thank you for your order!", "Checkout complete header mismatch.");
    }

    @Test(priority = 2, description = "TC_CHK_002: Verify validation error when First Name is missing")
    public void testCheckoutMissingFirstName() {
        inventoryPage.addBackpackToCart();
        driver.get(BASE_URL + "cart.html");
        cartPage.clickCheckout();

        checkoutPage.enterInformation("", "QA", "560001");
        checkoutPage.clickContinue();

        String error = checkoutPage.getErrorMessageText();
        Assert.assertEquals(error, "Error: First Name is required", "First name validation error mismatch.");
    }
}