package com.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AmazonLoginPage extends BasePage {
    
    @FindBy(id = "nav-link-accountList")
    WebElement signInMenu;

    @FindBy(id = "continue")
    WebElement continueBtn;

    public void navigateToLogin() {
        clickElement(signInMenu);
    }

    public void enterEmail(String email) {
        WebElement emailField;
        try {
            emailField = wait.until(d -> driver.findElement(By.id("ap_email")));
        } catch (Exception e) {
            emailField = wait.until(d -> driver.findElement(By.id("ap_email_login")));
        }
        
        typeText(emailField, email);
        clickElement(continueBtn);
    }
}