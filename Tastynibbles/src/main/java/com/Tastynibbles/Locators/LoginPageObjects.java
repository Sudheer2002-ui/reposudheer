package com.Tastynibbles.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.Tastynibbles.Browser.Browser;

public class LoginPageObjects extends Browser{
		public static By email=By.xpath("//input[@name=\"customer[email]\"]");
		public static By password =By.xpath("//input[@name=\"customer[password]\"]");
		public static By signInButoon=By.xpath("//button[@class=\"btn btn--full\"]");
		public static By errorMsg=By.xpath("//div[@class=\"errors\"]/ul/li");
		public static By myAccountElement=By.xpath("//h1[@class=\"section-header__title\"]");
		//method to find login's page email input element and returns it
		public static WebElement email() {
			return driver.findElement(email);
		}
		//method to find login's page password input element and returns it
		public static WebElement password() {
			return driver.findElement(password);
		}
		//method to find login's page signIn button element and returns it
		public static WebElement signInButton() {
			return driver.findElement(signInButoon);
		}
		//method to find login'page error listItem element and returns it
		public static WebElement error() {
			return driver.findElement(errorMsg);
		}
		
		//method to find login's page "My account" heading element and returns it
		public static WebElement myAccount() {
			return driver.findElement(myAccountElement);
		}

}
