package com.Tastynibbles.Pages;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Tastynibbles.Browser.Browser;
import com.Tastynibbles.Locators.HomePageObjects;
import com.aventstack.extentreports.Status;

public class Homepage extends Browser {
	//method to click on popup's close button and also to click on account Link
	public static void clickOnAccount() {
		extent.attachReporter(reporter);
		logger1=extent.createTest("Click on Account link");
		logger1.log(Status.INFO, "Clicking on Account link");
		try {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
			wait.until(ExpectedConditions.visibilityOfElementLocated(HomePageObjects.closeButton));
			HomePageObjects.closeButton().click();
			HomePageObjects.accountLink().click();
			logger1.log(Status.PASS,"Clicking on account link is successfull.");
		}catch(Exception e) {
			System.out.println("Error in clickOnAccount "+e.getMessage());
			logger1.log(Status.FAIL,"Clicking on account link is unsuccessfull.");
		}
		extent.flush();
	}
}
