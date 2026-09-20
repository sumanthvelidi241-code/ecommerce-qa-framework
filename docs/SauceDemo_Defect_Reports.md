# SauceDemo QA Defect Tracking Log

**Application Under Test (AUT):** https://www.saucedemo.com/  
**Defect Tracker:** Atlassian Jira  
**Project Key:** SDQA  

---

### Defect ID: BUG-001
* **Summary:** [Cart Module] "Remove" button fails to remove items from cart for `problem_user` session
* **Issue Type:** Bug
* **Severity:** High
* **Priority:** P2 - High
* **Component:** Shopping Cart (`/cart.html`)
* **Environment:** Windows 11, Chrome (Latest Version)

**Description / Steps to Reproduce:**
1. Navigate to https://www.saucedemo.com/
2. Log in with username: `problem_user` and password: `secret_sauce`
3. Add "Sauce Labs Backpack" to the shopping cart.
4. Click the cart icon in the top navigation bar to open `/cart.html`.
5. Click the "Remove" button next to the item.

**Expected Result:**
* The item row should be removed from the cart view.
* The cart badge count should decrement to 0 or disappear.

**Actual Result:**
* The "Remove" button triggers no action or state update.
* The item remains stuck in the cart view.

---

### Defect ID: BUG-002
* **Summary:** [Catalog Module] Product images fail to render correct assets for `problem_user`
* **Issue Type:** Bug
* **Severity:** Medium
* **Priority:** P3 - Medium
* **Component:** Product Catalog (`/inventory.html`)
* **Environment:** Windows 11, Chrome (Latest Version)

**Description / Steps to Reproduce:**
1. Navigate to https://www.saucedemo.com/
2. Log in with username: `problem_user` and password: `secret_sauce`
3. Inspect the product images across all 6 inventory items.

**Expected Result:**
* Each product card should render its unique product image (Backpack, Bike Light, Bolt T-shirt, etc.).

**Actual Result:**
* All product cards load an identical placeholder image (`/static/media/sl-404.168b1cce.jpg`), breaking visual UI consistency.