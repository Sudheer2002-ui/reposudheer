package com.Tastynibbles.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.Tastynibbles.Browser.Browser;

public class CreateAccountObjects extends Browser {
    
    public static By firstName = By.xpath("//input[@name='customer[first_name]']");
    public static By createAccountLink = By.linkText("Create account");
    public static By lastName = By.xpath("//input[@name='customer[last_name]']");
    public static By email = By.xpath("//input[@name='customer[email]']");
    public static By password = By.xpath("//input[@name='customer[password]']");
    public static By createButton = By.xpath("//input[@class='btn btn--full']");
    public static By logoutElement=By.linkText("Log out");
    public static By errorDiv = By.xpath("//div[@class='errors']");
    
    
    // method to find Create account link element and returns it
    public static WebElement createAccount() {
        return driver.findElement(createAccountLink);    
    }
    // method to find FirstName input element and returns it
    public static WebElement firstName() {
        return driver.findElement(firstName);
    }
    //method to find LastName input element and returns it
    public static WebElement lastName() {
        return driver.findElement(lastName);
    }
    //method to find email input element and returns it

    public static WebElement email() {
        return driver.findElement(email);
    }
    //method to find password input element and returns it

    public static WebElement password() {
        return driver.findElement(password);
    }
    //method to find create Button element and returns it

    public static WebElement createButton() {
        return driver.findElement(createButton);
    }
    //returns the text to check assertion
    public static WebElement assertText() {
        return driver.findElement(logoutElement);
    }
    //returns the error container
    public static WebElement errorDiv() {
        return driver.findElement(errorDiv);
    }
}
