package com.Tastynibbles.StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.Tastynibbles.Browser.Browser;
import com.Tastynibbles.Pages.CreateAccount;
import com.Tastynibbles.Pages.Homepage;
public class Registration {
	@Given("User opens the Browser")
	public void user_opens_the_browser() throws Exception {
	    Browser.openBrowser();
	}
	@And("User navigate to the {string} web page")
	public void user_navigate_to_the_web_page(String string) throws Exception {
	   Browser.navigateToUrl(string);
	}

	@When("User clicks on Account link")
	public void user_clicks_on_account_link() {
	    Homepage.clickOnAccount();
	}
	@When("user clicks on Create account link")
	public void user_clicks_on_create_account_link() {
	   CreateAccount.clickOnCreateAccount();
	}

	@When("User enters {string} in FirstName")
	public void user_enters_in_first_name(String string) {
	   CreateAccount.enterFirstName(string);
	}

	@And("User enters  {string} in LastName")
	public void user_enters_in_last_name(String string) {
		   CreateAccount.enterLastName(string);
	}

	@And("User enters {string} in email")
	public void user_enters_in_email(String string) {
		   CreateAccount.enterEmail(string);
	}

	@And("User enters  {string} in password")
	public void user_enters_in_password(String string) {
		   CreateAccount.enterPassword(string);
	}

	@And("User clicks on Create button")
	public void user_clicks_on_create_button() throws Exception {
	    CreateAccount.clickCreate();
	}

	@Then("User verifies the error message")
	public void user_verifies_the_error_message() throws Exception {
	   CreateAccount.verifyErrorMsg();
	}

	@Then("User verifies  registered successfully")
	public void user_verifies_registered_successfully() throws Exception {
	   CreateAccount.verifySuccessfullRegistrationMsg();
	}
	
	@And("User closes the Browser")
	public void user_closes_the_browser() {
		 CreateAccount.closeBrowser();
	}
}
