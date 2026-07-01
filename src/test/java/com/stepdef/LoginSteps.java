package com.stepdef;

import com.pom.AmazonLoginPage;
import com.pom.AmazonPaymentPage;
import com.pom.AmazonProductPage;
import com.pom.AmazonSearchPage;
import com.utils.DriverUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	
	AmazonLoginPage login = new AmazonLoginPage();
    AmazonSearchPage search = new AmazonSearchPage();
    AmazonProductPage product = new AmazonProductPage();
    AmazonPaymentPage payment = new AmazonPaymentPage();
    
	@Given("enter the url")
	public void enter_the_url() {
	    // Write code here that turns the phrase above into concrete actions
		DriverUtils.getDriver().get("https://www.amazon.in/");
	   
	}

	@When("enter valid username {string}  and password {string}")
	public void enter_valid_username_and_password(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@Then("click on Login button")
	public void click_on_login_button() {
	    // Write code here that turns the phrase above into concrete actions
	    
	}



}
