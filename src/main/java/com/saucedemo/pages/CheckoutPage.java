package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

    private WebDriver driver;

    // Step One Locators (Information)
    private By firstNameField = By.id("first-name");
    private By lastNameField  = By.id("last-name");
    private By postalCodeField= By.id("postal-code");
    private By continueButton = By.id("continue");
    private By errorMessage   = By.cssSelector("[data-test='error']");

    // Step Two Locators (Overview & Complete)
    private By finishButton    = By.id("finish");
    private By completeHeader  = By.className("complete-header");
    private By itemTotalLabel  = By.className("summary_subtotal_label");
    private By taxLabel        = By.className("summary_tax_label");
    private By totalLabel      = By.className("summary_total_label");

    // Constructor
    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    // Step One Actions
    public void enterInformation(String firstName, String lastName, String postalCode) {
        driver.findElement(firstNameField).clear();
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).clear();
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(postalCodeField).clear();
        driver.findElement(postalCodeField).sendKeys(postalCode);
    }

    public void clickContinue() {
        driver.findElement(continueButton).click();
    }

    public String getErrorMessageText() {
        return driver.findElement(errorMessage).getText();
    }

    // Step Two Actions
    public void clickFinish() {
        driver.findElement(finishButton).click();
    }

    public String getOrderCompleteMessage() {
        return driver.findElement(completeHeader).getText();
    }

    public String getItemTotalText() {
        return driver.findElement(itemTotalLabel).getText();
    }

    public String getTaxText() {
        return driver.findElement(taxLabel).getText();
    }

    public String getTotalText() {
        return driver.findElement(totalLabel).getText();
    }
}