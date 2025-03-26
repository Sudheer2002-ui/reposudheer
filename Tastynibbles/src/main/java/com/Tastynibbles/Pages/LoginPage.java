package com.Tastynibbles.Pages;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.Tastynibbles.Browser.Browser;
import com.Tastynibbles.Locators.LoginPageObjects;
import com.Tastynibbles.ScreenShot.ScreenShot;
import com.aventstack.extentreports.Status;

public class LoginPage extends Browser {
    //method to enter email
    public static void enterEmail(String email) {
    	extent.attachReporter(reporter);
		logger1=extent.createTest("Entering the login email");
		logger1.log(Status.INFO,"Entering the email");
        try {
        	wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        	wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPageObjects.email));
            LoginPageObjects.email().sendKeys(email);
			logger1.log(Status.PASS,"Entering email is successfull.");
        } catch (Exception e) {
            System.out.println("Error while entering email: " + e.getMessage());
			logger1.log(Status.FAIL,"Entering email is Unsuccessfull.");
        }
    }
    //method to enter password
    public static void enterPassword(String password) {
    	extent.attachReporter(reporter);
		logger1=extent.createTest("Entering the login password");
		logger1.log(Status.INFO,"Entering the password");
        try {
            LoginPageObjects.password().sendKeys(password);
			logger1.log(Status.PASS,"Entering password is successfull.");
        } catch (Exception e) {
            System.out.println("Error while entering password: " + e.getMessage());
			logger1.log(Status.FAIL,"Entering password is Unsuccessfull.");
        }
    }
    //method to click on sign in button
    public static void clickSignIn() throws Exception {
    	extent.attachReporter(reporter);
		logger1=extent.createTest("ScreenShot of clicking signin button");
    	logger1.log(Status.INFO, "ScreenShot");
		logger1.addScreenCaptureFromPath(ScreenShot.screenShot("Clicking SignIn button"));
        try {
            LoginPageObjects.signInButton().click();
        } catch (Exception e) {
            System.out.println("Error while clicking Sign In button: " + e.getMessage());
        }
    }
    //method to verify the error message coming or not after clicking sign in button for invalid credentials
    public static void verifyErrorMsg(String msg) throws Exception {
    	extent.attachReporter(reporter);
		logger1=extent.createTest("ScreenShot of verifying login page error message");
    	logger1.log(Status.INFO, "ScreenShot");
		logger1.addScreenCaptureFromPath(ScreenShot.screenShot("Verifying error message"));
    	try {
    		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
    		wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPageObjects.errorMsg));
    		Assert.assertEquals(LoginPageObjects.error().getText(), msg);
    	}catch(Exception e) {
    		System.out.println(e.getMessage());
    	}
    }
    //method to verify successful login after clicking sign in button for valid credentials

    public static void verifySuccessfulLogin(String str) throws Exception {
    	extent.attachReporter(reporter);
		logger1=extent.createTest("verifying succesful login ");
		logger1.log(Status.INFO,"verifying succesful login ");
    	try {
    		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
    		wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPageObjects.myAccountElement));
    		Assert.assertEquals(LoginPageObjects.myAccount().getText(), str);
			logger1.log(Status.PASS,"login successfull.");
    	}catch(Exception e) {
    		System.out.println(e.getMessage());
			logger1.log(Status.FAIL,"Login failed");
    	}
    }
    
}
