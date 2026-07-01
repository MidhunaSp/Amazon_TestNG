package com.test;

import org.testng.Assert;
import org.testng.annotations.*;
import com.pom.*;
import com.utils.DriverUtils;

@Listeners(com.utils.MyListener.class)
public class AmazonTest {

    AmazonLoginPage login;
    AmazonSearchPage search;
    AmazonProductPage product;
    AmazonPaymentPage payment;

    @BeforeClass
    public void setup() {
        DriverUtils.getDriver().get("https://www.amazon.in/");
        login = new AmazonLoginPage();
        search = new AmazonSearchPage();
        product = new AmazonProductPage();
        payment = new AmazonPaymentPage();
    }

    @DataProvider(name = "items")
    public Object[][] getItems() {
        return new Object[][]{ {"water bottle"} }; 
    }

    @Test(priority = 1)
    public void step1_Login() {
        login.navigateToLogin();
        login.enterEmail("8190057577");
        Assert.assertTrue(DriverUtils.getDriver().getTitle().contains("Amazon"), "Login page did not load correctly");
    }

    @Test(priority = 2, dataProvider = "items", dependsOnMethods = "step1_Login")
    public void step2_Search(String item) {
        search.searchFor(item);
        Assert.assertTrue(DriverUtils.getDriver().getCurrentUrl().contains("water+bottle"), "Search was not successful");
    }

    @Test(priority = 3, dependsOnMethods = "step2_Search")
    public void step3_Select() {
        search.selectProduct(2);
        Assert.assertTrue(product.isLoaded(), "Product detail page was not reached after selection");
    }

    @Test(priority = 4, dependsOnMethods = "step3_Select")
    public void step4_Cart() {
        product.addToCart();
    }

    @Test(priority = 5, dependsOnMethods = "step4_Cart")
    public void step5_Checkout() {
        product.clickCheckout();
        String currentUrl = DriverUtils.getDriver().getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("checkout") || currentUrl.contains("addresstab"), "Failed to reach Checkout page");
    }

    @AfterClass
    public void tearDown() {
        DriverUtils.quitDriver();
    }
}