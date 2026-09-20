# SauceDemo E-Commerce QA Test Matrix

**Application Under Test (AUT):** https://www.saucedemo.com/  
**Methodologies:** STLC, Black-Box Test Design (Boundary Value Analysis, Equivalence Class Partitioning)  
**Total Test Cases:** 22  

---

## 1. Authentication Module

| Test Case ID | Test Scenario | Pre-conditions | Test Steps | Test Data | Expected Result | Priority | Type |
|---|---|---|---|---|---|---|---|
| **TC_AUTH_001** | Verify successful login with valid credentials | User is on login page | 1. Enter valid username<br>2. Enter valid password<br>3. Click Login button | `standard_user`<br>`secret_sauce` | User redirected to `/inventory.html`; "Products" header visible | P1 - High | Smoke / Sanity |
| **TC_AUTH_002** | Verify login rejection for locked-out user | User is on login page | 1. Enter locked username<br>2. Enter valid password<br>3. Click Login button | `locked_out_user`<br>`secret_sauce` | Error banner displayed: *"Epic sadface: Sorry, this user has been locked out."* | P1 - High | Negative |
| **TC_AUTH_003** | Verify validation when username is empty | User is on login page | 1. Leave username field blank<br>2. Enter valid password<br>3. Click Login button | Username: Blank<br>Password: `secret_sauce` | Error banner displayed: *"Epic sadface: Username is required"* | P2 - Medium | Negative (BVA) |
| **TC_AUTH_004** | Verify validation when password is empty | User is on login page | 1. Enter valid username<br>2. Leave password field blank<br>3. Click Login button | Username: `standard_user`<br>Password: Blank | Error banner displayed: *"Epic sadface: Password is required"* | P2 - Medium | Negative (BVA) |
| **TC_AUTH_005** | Verify login rejection with invalid credentials | User is on login page | 1. Enter invalid username<br>2. Enter invalid password<br>3. Click Login button | `invalid_user`<br>`invalid_pass` | Error banner displayed: *"Epic sadface: Username and password do not match any user in this service"* | P1 - High | Negative (ECP) |
| **TC_AUTH_006** | Verify user logout clears active session | User is logged in | 1. Click hamburger menu button<br>2. Click Logout option | Active session | User redirected to root login page; session invalidated | P2 - Medium | Functional |
| **TC_AUTH_007** | Verify direct inventory access without login is prevented | User is not logged in | 1. Directly navigate to `https://www.saucedemo.com/inventory.html` | No session | Redirection back to login page with error: *"Epic sadface: You can only access '/inventory.html' when you are logged in."* | P1 - High | Security |

---

## 2. Inventory & Catalog Module

| Test Case ID | Test Scenario | Pre-conditions | Test Steps | Test Data | Expected Result | Priority | Type |
|---|---|---|---|---|---|---|---|
| **TC_INV_001** | Verify default product inventory display | User logged in as `standard_user` | 1. Navigate to Inventory page<br>2. Count displayed inventory item containers | N/A | Exactly 6 products are displayed with title, description, price, and Add to cart button | P1 - High | Sanity |
| **TC_INV_002** | Verify sorting: Price (low to high) | User on Inventory page | 1. Open sort dropdown<br>2. Select "Price (low to high)" | Value: `lohi` | First item is Sauce Labs Onesie ($7.99); last item is Sauce Labs Fleece Jacket ($49.99) | P2 - Medium | Functional |
| **TC_INV_003** | Verify sorting: Price (high to low) | User on Inventory page | 1. Open sort dropdown<br>2. Select "Price (high to low)" | Value: `hilo` | First item is Sauce Labs Fleece Jacket ($49.99); last item is Sauce Labs Onesie ($7.99) | P2 - Medium | Functional |
| **TC_INV_004** | Verify sorting: Name (A to Z) and Name (Z to A) | User on Inventory page | 1. Toggle filter to "Name (Z to A)"<br>2. Toggle back to "Name (A to Z)" | Values: `za`, `az` | Catalog updates alphabetically in descending and ascending order | P3 - Low | Functional |
| **TC_INV_005** | Verify product title link redirects to detail view | User on Inventory page | 1. Click on "Sauce Labs Backpack" title | Item: Backpack | Redirects to `/inventory-item.html?id=4` displaying matched title, image, and $29.99 price | P2 - Medium | Functional |

---

## 3. Shopping Cart Module

| Test Case ID | Test Scenario | Pre-conditions | Test Steps | Test Data | Expected Result | Priority | Type |
|---|---|---|---|---|---|---|---|
| **TC_CART_001** | Verify adding a single item updates the cart badge | User on Inventory page | 1. Click "Add to cart" on Sauce Labs Backpack | Backpack | Cart badge appears showing count `1`; button switches to "Remove" | P1 - High | Functional |
| **TC_CART_002** | Verify adding multiple items increments cart badge count | User on Inventory page | 1. Add Backpack<br>2. Add Bike Light<br>3. Add Bolt T-Shirt | 3 items | Cart badge counter dynamically increments to `3` | P1 - High | Functional |
| **TC_CART_003** | Verify removing an item directly from inventory catalog | 1 item in cart | 1. Click "Remove" button on the previously added item | Backpack | Cart badge decrements/disappears; button text reverts to "Add to cart" | P2 - Medium | Functional |
| **TC_CART_004** | Verify cart items persist upon navigating to cart view | 2 items added | 1. Click the shopping cart icon | Backpack, Bike Light | Navigates to `/cart.html`; lists both items with correct prices and quantity = 1 | P1 - High | Regression |
| **TC_CART_005** | Verify item removal from inside the cart view | 2 items in cart | 1. Navigate to `/cart.html`<br>2. Click "Remove" next to Backpack | Cart view | Backpack row is removed from DOM; cart badge count updates from 2 to 1 | P2 - Medium | Functional |

---

## 4. Checkout Flow Module

| Test Case ID | Test Scenario | Pre-conditions | Test Steps | Test Data | Expected Result | Priority | Type |
|---|---|---|---|---|---|---|---|
| **TC_CHK_001** | Verify navigation from Cart to Checkout Step 1 | At least 1 item in cart | 1. On `/cart.html`, click "Checkout" button | N/A | Redirects to `/checkout-step-one.html` displaying user information inputs | P1 - High | Smoke |
| **TC_CHK_002** | Verify validation on empty First Name during checkout | User on Checkout Step 1 | 1. Leave First Name blank<br>2. Enter Last Name and Postal Code<br>3. Click "Continue" | First: Blank<br>Last: `Doe`<br>Zip: `560001` | Error displayed: *"Error: First Name is required"* | P2 - Medium | Negative (ECP) |
| **TC_CHK_003** | Verify validation on empty Postal Code during checkout | User on Checkout Step 1 | 1. Enter First Name and Last Name<br>2. Leave Postal Code blank<br>3. Click "Continue" | First: `John`<br>Last: `Doe`<br>Zip: Blank | Error displayed: *"Error: Postal Code is required"* | P2 - Medium | Negative (ECP) |
| **TC_CHK_004** | Verify tax and item total calculation on Overview page | Completed Step 1 with valid data | 1. Submit valid info on Step 1<br>2. On Step 2, inspect item total, tax, and total | Item: $29.99 | Tax displays correctly ($2.40); Total matches Item Total + Tax ($32.39) | P1 - High | Functional |
| **TC_CHK_005** | Verify successful end-to-end checkout completion | User on Checkout Step 2 | 1. Click "Finish" button | N/A | Redirects to `/checkout-complete.html`; displays *"Thank you for your order!"* header | P1 - High | E2E Happy Path |