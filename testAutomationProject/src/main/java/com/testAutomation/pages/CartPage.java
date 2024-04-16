package com.testAutomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

	public WebDriver driver;

	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[@id='sc-buy-box-ptc-button']")
	WebElement proceedToCheckout;
	
	@FindBy(xpath = "//span[@id='sc-subtotal-amount-activecart']")
	WebElement subtotalPrice;
	
	@FindBy(xpath = "//span[@id='sc-subtotal-label-activecart']")
	WebElement totalItemsToCart;
	
	public void clickOnProceedToCheckout() {
		proceedToCheckout.click();
	}
	
	public void totalPrice() {
		String priceString = subtotalPrice.getText();
		System.out.println("Total price = "+priceString.trim());
		
	}
	
	public void totalItemsOnCart() {
		String itemString = totalItemsToCart.getText();
		String[] parts = itemString.split("\\("); // Splitting by the opening parenthesis
		if (parts.length > 1) { // Ensuring that there is a '(' in the string
		    String subString = parts[1]; // Taking the part after the '('
		    String finalString = subString.split("\\)")[0]; // Splitting by the closing parenthesis
		    System.out.println("Total items on cart = " + finalString);
		} else {
		    System.out.println("Error: Opening parenthesis not found in the string.");
		}
	}
}
