package com.Tastynibbles.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.Tastynibbles.Browser.Browser;

public class HomePageObjects extends Browser {
    public static By closeButton = By.xpath("//span[@class='engt_modal_close-btn']");
    public static By accountLink = By.linkText("ACCOUNT");
    //method to find popup's close button and returns it
    public static WebElement closeButton() {
        return driver.findElement(closeButton);
    }
    //method to find Account link element and returns it
    public static WebElement accountLink() {
        return driver.findElement(accountLink);
    }
}
