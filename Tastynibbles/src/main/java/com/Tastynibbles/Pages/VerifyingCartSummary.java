package com.Tastynibbles.Pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.Tastynibbles.Browser.Browser;
import com.Tastynibbles.CustomizedExceptions.CustomizedException;
import com.Tastynibbles.Locators.CartItemProductsObjects;
import com.Tastynibbles.Locators.ProductSearchObjects;
import com.aventstack.extentreports.Status;

public class VerifyingCartSummary extends Browser{
	
	//method to navigate to cart
	public static void navigateToCart() throws InterruptedException {
		extent.attachReporter(reporter);
		logger1=extent.createTest("Navigating to cart");
		logger1.log(Status.INFO,"Navigating to cart ");
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.visibilityOfElementLocated(ProductSearchObjects.cartDiv));
			driver.navigate().refresh();
			ProductSearchObjects.cart().click();
			logger1.log(Status.PASS,"Navigating is successful");
		}catch(Exception e) {
			System.out.println("Exception in navigating to cart"+e.getMessage());
			logger1.log(Status.FAIL,"Navigating is unsuccessful");
		}
		extent.flush();
	}
	//method to verify prices

	public static void verifyPrices() throws CustomizedException {
	    double priceOfAllItems = 0;
	    extent.attachReporter(reporter);
		logger1=extent.createTest("Vefiying prices of all added items and total price");
		logger1.log(Status.INFO,"Vefiying prices of all added items and total price ");
	    try {
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.visibilityOfElementLocated(ProductSearchObjects.cartDiv));
	        List<WebElement> list = CartItemProductsObjects.prices();
	        ArrayList<String> prices = new ArrayList<>();
	        for (WebElement element : list) {
	            String[] splitPrices = element.getText().replace("₹", "").trim().split("\\s+"); 
	            for (String price : splitPrices) {
	                prices.add(price);
	            }
	        }
	        for (int i = 1; i < prices.size(); i += 2) {
	        	priceOfAllItems += Double.parseDouble(prices.get(i));
	        }
	        System.out.println(priceOfAllItems+"  prices");
	        WebElement totalElement = CartItemProductsObjects.totalPrice();
	        String totalText = totalElement.getText().trim();
	        totalText = totalText.replaceAll("[^0-9]", "").trim();
	        if (totalText.length() > 2) {
	            totalText = totalText.substring(0, totalText.length() - 2);
	        }
	        double totalPrice = Double.parseDouble(totalText);
	        Assert.assertEquals(totalPrice, priceOfAllItems);
			logger1.log(Status.PASS,"Verification of prices is successful");

	    } catch (Exception e) {
			logger1.log(Status.FAIL,"Verification is unsuccessful");
	        throw new CustomizedException("Error in verifying price: " + e.getMessage());
	    }
		extent.flush();
	}


	
}
	

