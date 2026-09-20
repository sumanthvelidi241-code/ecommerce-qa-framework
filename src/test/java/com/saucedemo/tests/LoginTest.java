package com.saucedemo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.saucedemo.base.TestBase;
import com.saucedemo.pages.LoginPage;

public class LoginTest extends TestBase {

    @Test(priority = 1, description = "TC_AUTH_001: Verify successful login with valid credentials")
    public void testValidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("inventory.html"), 
                "User was not redirected to inventory page upon valid login.");
    }

    @Test(priority = 2, description = "TC_AUTH_002: Verify error message for locked out user")
    public void testLockedOutUser() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("locked_out_user", "secret_sauce");

        String actualError = loginPage.getErrorMessageText();
        String expectedError = "Epic sadface: Sorry, this user has been locked out.";
        Assert.assertEquals(actualError, expectedError, 
                "Locked-out error message mismatch.");
    }

    @Test(priority = 3, description = "TC_AUTH_005: Verify error message with invalid credentials")
    public void testInvalidCredentials() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("invalid_user", "wrong_password");

        String actualError = loginPage.getErrorMessageText();
        String expectedError = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(actualError, expectedError, 
                "Invalid credentials error message mismatch.");
    }
}