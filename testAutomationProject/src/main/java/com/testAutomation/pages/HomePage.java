package com.testAutomation.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage {

	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@id='nav-link-accountList']")
	WebElement signIn;

	@FindBy(xpath = "//input[@id='twotabsearchtextbox']")
	WebElement searchboxElement;
	
	@FindBy(xpath = "//select[@id='searchDropdownBox']")
	WebElement searchCategories;
	
	@FindBy(xpath ="//*[text()='Try different image']")
	WebElement passTest;
	
	@FindBy(xpath = "//a[@id='nav-cart']")
	WebElement cartPage;

	public void clickOnSignIn() {
		signIn.click();
	}

	public void productSearch(String name) {
		searchboxElement.sendKeys(name);
		searchboxElement.sendKeys(Keys.ENTER);
	}
	
	public void passTestCharacters() {
		passTest.click();
	}
	
	public void goToCartPage() {
		cartPage.click();
	}
	
	public void filterCategory(String category) {
		Select categorySelect = new Select(searchCategories);
		categorySelect.selectByVisibleText(category);
	}
}
