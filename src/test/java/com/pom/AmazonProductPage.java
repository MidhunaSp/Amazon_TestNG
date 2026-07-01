package com.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AmazonProductPage extends BasePage {

	@FindBy(id = "productTitle")
	WebElement title;

	@FindBy(id = "add-to-cart-button")
	WebElement cartBtn;

	@FindBy(name = "proceedToRetailCheckout")
	WebElement checkoutBtn;

	public boolean isLoaded() {
		return wait.until(ExpectedConditions.visibilityOf(title)).isDisplayed();
	}

	public void addToCart() {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    try {
	        try {
	            js.executeScript("document.getElementById('attach-close_sideSheet-link').click();");
	        } catch (Exception e) {}

	        js.executeScript("arguments[0].scrollIntoView(true);",  cartBtn);
	        js.executeScript("arguments[0].click();", cartBtn);

	        Thread.sleep(3000); 

	    } catch (Exception e) {
	        throw new RuntimeException("Cart insertion failed: " + e.getMessage());
	    }
	}
	public void clickCheckout() {
		clickElement(checkoutBtn);
	}
}