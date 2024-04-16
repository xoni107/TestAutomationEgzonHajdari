package com.testAutomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SignInPage {
	
	public WebDriver driver;
	
	public SignInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='ap_email']")
	WebElement username;
	
	@FindBy(xpath = "//input[@id='continue']")
	WebElement conituneButton;
	
	@FindBy(xpath="//input[@id='ap_password']")
	WebElement password;
	
	@FindBy(xpath="//input[@id='signInSubmit']")
	WebElement signInButton;
	
	@FindBy(xpath="(//span[@class='a-list-item'])[1]")
	WebElement warningAlertElement;
	
	@FindBy(xpath="//span[@class='a-list-item']")
	WebElement warningAlertElement2;
	
	public void usernameField(String Username) {
		username.sendKeys(Username);
	}
	
	public void passwordField(String Password) {
		password.sendKeys(Password);
	}
	
	public void clickConituneButton() {
		conituneButton.click();
	}
	
	public void clickOnSignIn() {
		signInButton.click();
	}
	
	public String checkEmail(String emailMessage) {
		String message = warningAlertElement.getText();
		System.out.println(message);
		Assert.assertEquals(message, emailMessage);
		return message;
	}

	public String verifyWarningAlert(String expectedMessage) {
		String alertMessage2 = warningAlertElement2.getText();
		System.out.println(alertMessage2);
		Assert.assertEquals(alertMessage2, expectedMessage);
		return alertMessage2;
	}
}
