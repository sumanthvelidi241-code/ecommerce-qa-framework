# 🛒 SauceDemo E-Commerce QA Automation Framework

A production-ready test automation framework designed using the **Page Object Model (POM)** pattern in **Java**, **Selenium WebDriver**, and **TestNG**. Built for comprehensive regression testing of the [SauceDemo](https://www.saucedemo.com/) web application.

---

## 📌 Framework Highlights

- **Design Pattern**: Clean Page Object Model (POM) separating UI locators and actions from test assertions.
- **Dynamic Driver Setup**: Automated binary management via `WebDriverManager`.
- **Browser Hardening**: Configured `ChromeOptions` suppressing data-leak alerts, password popups, and infobars.
- **Centralized Execution**: Master XML test runner (`testng.xml`) orchestrating regression suites.
- **Reporting**: Automated execution reports generated via TestNG HTML reporter.

---

## 🛠 Tech Stack

| Tool / Technology | Version | Purpose |
| :--- | :--- | :--- |
| **Java** | 17 (JavaSE-17) | Core Programming Language |
| **Selenium WebDriver** | 4.x | Browser Automation API |
| **TestNG** | 7.x | Test Execution, Lifecycle & Assertions |
| **WebDriverManager** | 5.x | Automated Driver Management |
| **Maven** | 3.x | Build and Dependency Management |

---

## 📂 Project Structure

```text
ecommerce-qa-framework/
├── src/main/java/com/saucedemo/
│   ├── base/
│   │   └── TestBase.java              # Base driver setup, timeouts, & ChromeOptions
│   └── pages/
│       ├── LoginPage.java             # Auth locators and action methods
│       ├── InventoryPage.java         # Product catalog, sorting, and cart badge
│       ├── CartPage.java              # Cart list inspection & checkout entry
│       └── CheckoutPage.java          # Customer info, summary overview, & finish
├── src/test/java/com/saucedemo/
│   └── tests/
│       ├── LoginTest.java             # Valid, locked out, & invalid credentials (3 tests)
│       ├── InventoryTest.java         # Item count, cart badge increment, & sorting (3 tests)
│       └── E2ETest.java               # Complete purchase flow & missing field validation (2 tests)
├── docs/
│   ├── SauceDemo_Test_Cases.md       # Manual test specifications
│   └── SauceDemo_Defect_Reports.md   # Defect tracking and bug reports
├── pom.xml                            # Maven dependencies and build configuration
└── testng.xml                         # Master regression suite configuration