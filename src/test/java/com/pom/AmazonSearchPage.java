package com.pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.Set;

public class AmazonSearchPage extends BasePage {
	@FindBy(id = "twotabsearchtextbox")
	WebElement searchBox;

	@FindBy(xpath = "//div[@data-component-type='s-search-result']//a[@class='a-link-normal s-no-outline']")
	java.util.List<WebElement> results;

	public void searchFor(String product) {
		typeText(searchBox, product);
		searchBox.submit();
	}

	public void selectProduct(int index) {
		String parent = driver.getWindowHandle();
		
		wait.until(ExpectedConditions.visibilityOfAllElements(results));
		WebElement target = results.get(index);
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", target);
		clickElement(target);
		
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));

		Set<String> handles = driver.getWindowHandles();
		for (String h : handles) {
			if (!h.equals(parent)) {
				driver.switchTo().window(h);
				break;
			}
		}
		
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(org.openqa.selenium.By.id("productTitle")));
	}
}