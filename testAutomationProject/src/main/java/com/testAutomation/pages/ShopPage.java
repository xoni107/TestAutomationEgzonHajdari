package com.testAutomation.pages;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShopPage {

	public WebDriver driver;
	SingleProductPage singleProductPage;
	
	public ShopPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		singleProductPage = new SingleProductPage(driver);
	}

	

	@FindBy(xpath = "//a[contains(@class, 'sf-collapsible-left-nav-expand-all')]")
	WebElement expandAll;

	@FindBy(xpath = "//*[text()='HP']")
	WebElement filterByBrand;

	@FindBy(xpath = "//*[text()='14 to 14.9 Inches']")
	WebElement filterBySize;

	@FindBy(xpath = "//span[@data-component-type='s-product-image']")
	private List<WebElement> productsToCart;

	@FindBy(xpath = "//input[@id='add-to-cart-button']")
	WebElement addToCart;

	public void filterBrand() throws InterruptedException {
		JavascriptExecutor ex = (JavascriptExecutor) driver;
		ex.executeScript("arguments[0].click()", filterByBrand);
		Thread.sleep(2000);
//		filterByBrand.click();
	}

	public void filterBySize() throws InterruptedException {
		JavascriptExecutor ex = (JavascriptExecutor) driver;
		ex.executeScript("arguments[0].click()", filterBySize);
		Thread.sleep(2000);
		filterBySize.click();
	}

	public void expandAll() {
		if (expandAll.isDisplayed() && expandAll.isEnabled()) {
			expandAll.click();
		}
	}

	public void addToCart() throws InterruptedException {
		for (int i = 0; i < 3 && i < productsToCart.size(); i++) {
			WebElement product = productsToCart.get(i);
			Thread.sleep(3000);
			Actions actions = new Actions(driver);
			actions.keyDown(Keys.CONTROL).click(product).keyUp(Keys.CONTROL).perform();
//			product.sendKeys(Keys.CONTROL,Keys.ENTER);
			Set<String> windows = driver.getWindowHandles();
			Iterator<String> iterator = windows.iterator();
			String parentIdString = iterator.next();
			String childIdString = iterator.next();
			driver.switchTo().window(childIdString);

			singleProductPage.addToCartMethod();

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='add-to-cart-button']")));
			addToCart.click();
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//div[@id='sw-atc-details-single-container']")));
			driver.close();
			driver.switchTo().window(parentIdString);
			Thread.sleep(3000);
		}
	}
}
