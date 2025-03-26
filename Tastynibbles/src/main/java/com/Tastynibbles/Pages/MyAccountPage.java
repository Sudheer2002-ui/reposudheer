package com.Tastynibbles.Pages;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.Tastynibbles.Browser.Browser;
import com.Tastynibbles.Locators.LoginAndLogoutObjects;
import com.aventstack.extentreports.Status;

public class MyAccountPage extends Browser {
	//method to logout from the application
    public static void logoutFromApp() {
    	extent.attachReporter(reporter);
		logger1=extent.createTest("clicking logout button ");
		logger1.log(Status.INFO,"clicking logout button ");
        try {
            LoginAndLogoutObjects.logout().click();
			logger1.log(Status.PASS,"clicking on logout button is successful");
        } catch (Exception e) {
            System.out.println("Error while clicking logout: " +e.getMessage());
			logger1.log(Status.FAIL,"clicking on logout button is Unsuccessful");
        }
        extent.flush();
    }
    //method to verify successful logout
    public static void verifyLogout(String url) {
    	extent.attachReporter(reporter);
		logger1=extent.createTest("verifying succesful login ");
		logger1.log(Status.INFO,"verifying succesful login ");
        try {
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(LoginAndLogoutObjects.vefiryDiv));
            Assert.assertEquals(LoginAndLogoutObjects.homePageUrl(), url);
			logger1.log(Status.PASS,"logout successfull.");
        } catch (Exception e) {
            System.out.println("Error while verifying logout: " +e.getMessage());
			logger1.log(Status.FAIL,"Logout failed");
        }
        extent.flush();
    }
}
