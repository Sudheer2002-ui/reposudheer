package com.Tastynibbles.Locators;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.Tastynibbles.Browser.Browser;
public class CartItemProductsObjects extends Browser {
		public static By price=By.xpath("//span[@class=\"cart__price\"]/span");
		public static By totalPrice=By.xpath("//span[@class=\"csapps-cart-original-total\"]/div");
		
		//method to get price elements of the cart items and returns those
		public static  List<WebElement> prices() {
	        List<WebElement> list = driver.findElements(By.xpath("//span[@class=\"cart__price\"]"));
	        return list;
		}
		//method to return price element
		public static WebElement price() {
			return driver.findElement(price);
		}
		//
		public static WebElement totalPrice() {
			return driver.findElement(totalPrice);
		}
}
