package com.testAutomation.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testAutomation.factory.DriverManager;

public class SingleProductPage extends DriverManager{

	public WebDriver driver;

	public SingleProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@id='add-to-cart-button']")
	WebElement addToCartButton;
	
	@FindBy(xpath = "//div[@id='mir-layout-DELIVERY_BLOCK-slot-PRIMARY_DELIVERY_MESSAGE_LARGE']")
	WebElement locationError;
	
	public void addToCartMethod() {
		List<WebElement> noAddToCart = driver.findElements(By.xpath("//div[@id='mir-layout-DELIVERY_BLOCK-slot-PRIMARY_DELIVERY_MESSAGE_LARGE']"));
		if (!noAddToCart.isEmpty()) {
			locationError.getText();
		} else {
			addToCartButton.click();
		}
	}
}
