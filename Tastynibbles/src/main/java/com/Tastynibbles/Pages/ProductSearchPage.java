package com.Tastynibbles.Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.Tastynibbles.Browser.Browser;
import com.Tastynibbles.CustomizedExceptions.CustomizedException;
import com.Tastynibbles.Locators.ProductSearchObjects;
import com.aventstack.extentreports.Status;

public class ProductSearchPage extends Browser{
	
		//method to enter the product name in the search box
		public static void searchProduct(String product) throws CustomizedException {
			extent.attachReporter(reporter);
			logger1=extent.createTest("Searching for a product ");
			logger1.log(Status.INFO,"Searcing for a product ");
			try {
				wait=new WebDriverWait(driver,Duration.ofSeconds(10));
				wait.until(ExpectedConditions.visibilityOfElementLocated(ProductSearchObjects.searchBox));
				ProductSearchObjects.searchElement().sendKeys(product,Keys.ENTER);
				logger1.log(Status.PASS,"Searching for a product is successful");
			}catch(Exception e) {
				logger1.log(Status.FAIL,"Searching for a product is unsuccessful");
				throw new CustomizedException("Error in searching product:"+e.getMessage());
			}
			extent.flush();
		}
		//method to select the product from results (used auto suggest concept)
		public static void selectProduct(String item) throws CustomizedException {
			extent.attachReporter(reporter);
			logger1=extent.createTest("Selecting product ");
			logger1.log(Status.INFO,"Selecting product ");
			try {
				wait=new WebDriverWait(driver,Duration.ofSeconds(10));
				wait.until(ExpectedConditions.visibilityOfElementLocated(ProductSearchObjects.resultContainer));
		            List<WebElement> list = ProductSearchObjects.resultItems();
		            System.out.println(list.size());
		            for (int i = 0; i < list.size(); i++) {
		                if(list.get(i).getText().contains(item)) {
		                	list.get(i).click();
		                	break;
		                }
		            }
					logger1.log(Status.PASS,"Selecting  product is successful");
				}catch(Exception e) {
					logger1.log(Status.FAIL,"Selecting product is unsuccessful");
					throw new CustomizedException("Error in selecting product"+e.getMessage());
			}extent.flush();
			
	     }
		//method to add item from the results to the cart
		public static void addItemToCart() throws CustomizedException {
			extent.attachReporter(reporter);
			logger1=extent.createTest("Adding product to cart ");
			logger1.log(Status.INFO,"Adding product to cart ");
			try {
				wait=new WebDriverWait(driver,Duration.ofSeconds(10));
				wait.until(ExpectedConditions.visibilityOfElementLocated(ProductSearchObjects.addToCartButton));
		        ProductSearchObjects.addToCart().click();
				logger1.log(Status.PASS,"Adding product to cart is successful");
			}catch(Exception e) {
				logger1.log(Status.FAIL,"Adding product to cart is unsuccessful");
				throw new CustomizedException("Error in adding Item to cart"+e.getMessage());
			}extent.flush();
			
		}
		//method to verify the added item in the cart 
		public static void verifyCart(String item) throws CustomizedException {
		    extent.attachReporter(reporter);
		    logger1 = extent.createTest("Verifying item in cart");
		    logger1.log(Status.INFO, "Verifying item in cart");
		    try {
		        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		        wait.until(ExpectedConditions.visibilityOfElementLocated(ProductSearchObjects.cartDiv));
		        List<WebElement> list = ProductSearchObjects.cartItems();
		        if (list.isEmpty()) { 
		            logger1.log(Status.FAIL, "Cart is empty, item not found");
		            throw new CustomizedException("Cart is empty, item verification failed");
		        }
		        boolean itemFound = false;
		        for (WebElement element : list) {
		            if (element.getText().equals(item)) {
		                Assert.assertEquals(element.getText(), item);
		                System.out.println(element.getText());
		                itemFound = true;
		                break;
		            }
		        }
		        if (!itemFound) { 
		            logger1.log(Status.FAIL, "Item not found in the cart");
		            throw new CustomizedException("Item '" + item + "' not found in cart");
		        }
		        logger1.log(Status.PASS, "Verifying item in cart is successful");
		    } catch (Exception e) {
		        logger1.log(Status.FAIL, "Verifying item in cart is unsuccessful");
		        throw new CustomizedException("Error in verifying cart: " + e.getMessage());
		    } finally {
		        extent.flush();
		    }
		}
}
