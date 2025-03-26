package com.Tastynibbles.Pages;

import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.Tastynibbles.Browser.Browser;
import com.Tastynibbles.Locators.CreateAccountObjects;
import com.Tastynibbles.Locators.HomePageObjects;
import com.Tastynibbles.ScreenShot.ScreenShot;
import com.aventstack.extentreports.Status;

import org.testng.Assert;

public class CreateAccount extends Browser {
	//method to click on the create account link
    public static void clickOnCreateAccount() {
		logger1=extent.createTest("Click on create account");
		logger1.log(Status.INFO, "Clicking create account");
        try {
            CreateAccountObjects.createAccount().click();
			logger1.log(Status.PASS,"Clicking on account is successfull.");
        } catch (Exception e) {
			logger1.log(Status.FAIL,"Clicking on account is unsuccessfull.");
            System.out.println("Exception in clickOnCreateAccount: " + e.getMessage());
        }
    }
    //method to enter FirstName
    public static void enterFirstName(String firstName) {
		logger1=extent.createTest("Entering the Firstname");
		logger1.log(Status.INFO,"Entering the Firstname");
        try {
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(CreateAccountObjects.firstName));
            CreateAccountObjects.firstName().sendKeys(firstName);
			logger1.log(Status.PASS,"Entering Firstname is successfull.");
        } catch (Exception e) {
			logger1.log(Status.FAIL,"Entering Firstname is successfull.");
        }
    }
    //method to enter LastName
    public static void enterLastName(String lastName) {
		logger1=extent.createTest("Entering the Lastname");
		logger1.log(Status.INFO,"Entering the Lastname");
        try {
            CreateAccountObjects.lastName().sendKeys(lastName);
			logger1.log(Status.PASS,"Entering Lastname is successfull.");

        } catch (Exception e) {
            System.out.println("Exception in enterLastName: " + e.getMessage());
			logger1.log(Status.FAIL,"Entering Lastname is Unsuccessfull.");
        }
    }
    //method to enter Email
    public static void enterEmail(String email) {
		logger1=extent.createTest("Entering the email");
		logger1.log(Status.INFO,"Entering the email");
        try {
            CreateAccountObjects.email().sendKeys(email);
			logger1.log(Status.PASS,"Entering email is successfull.");

        } catch (Exception e) {
            System.out.println("Exception in enterEmail: " + e.getMessage());
			logger1.log(Status.FAIL,"Entering email is Unsuccessfull.");
        }
    }
    //method to enter password
    public static void enterPassword(String password) {
		logger1=extent.createTest("Entering the password");
		logger1.log(Status.INFO,"Entering the password");
        try {
            CreateAccountObjects.password().sendKeys(password);
			logger1.log(Status.PASS,"Entering password is successfull.");
        } catch (Exception e) {
            System.out.println("Exception in enterPassword: " + e.getMessage());
			logger1.log(Status.FAIL,"Entering password is Unsuccessfull.");
        }
    }
    //method to click on create button
    public static void clickCreate() throws Exception {
		logger1=extent.createTest("ScreenShot of clicking create button");
    	logger1.log(Status.INFO, "ScreenShot");
		logger1.addScreenCaptureFromPath(ScreenShot.screenShot("Clicking create button"));
        try {
            CreateAccountObjects.createButton().click();
        } catch (Exception e) {
            System.out.println("Exception in clickCreate: " + e.getMessage());
        }
    }
    //method to verify error message
    public static void verifyErrorMsg() throws Exception {
		logger1=extent.createTest("Verifying error message");
    	logger1.log(Status.INFO, "Verifying error message");
		
        try {
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement errorDiv = wait.until(ExpectedConditions.visibilityOfElementLocated(CreateAccountObjects.errorDiv));
            Assert.assertTrue(errorDiv.isDisplayed());
        	logger1.log(Status.PASS, " successfully Verified error message");

        } catch (Exception e) {
            System.out.println("Exception in verifyErrorMsg: " + e.getMessage());
            Assert.fail();
        	logger1.log(Status.FAIL, " Unsuccessful in  Veriying error message");
        }
    }
    //method to verify whether the user is registered successfully or not
    public static void verifySuccessfullRegistrationMsg() throws Exception {
		logger1=extent.createTest("ScreenShot of verifying successful registration");
    	logger1.log(Status.INFO, "ScreenShot");
		logger1.addScreenCaptureFromPath(ScreenShot.screenShot("Verifying Successful registration"));
        try {
            HomePageObjects.accountLink().click();
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(CreateAccountObjects.logoutElement));
            Assert.assertEquals(CreateAccountObjects.assertText().getText(), "Log out");
        } catch (Exception e) {
            System.out.println("Exception in verifySuccessfullRegistrationMsg: " + e.getMessage());
            Assert.fail();
        }
    }
    //method to close the browser
    public static void closeBrowser() {
        try {
            Browser.closeBrowser();
        } catch (Exception e) {
            System.out.println("Exception in closeBrowser: " + e.getMessage());
        }
    }
}
