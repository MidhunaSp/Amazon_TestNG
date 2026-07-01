package com.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AmazonPaymentPage extends BasePage {
    @FindBy(name = "addCreditCardNumber")
    WebElement cardInput;

    public void enterPaymentDetails(String number) {
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'apx-secure-iframe')]")));
        typeText(cardInput, number);
        driver.switchTo().defaultContent();
    }
}