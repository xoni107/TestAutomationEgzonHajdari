package com.testAutomation.tests;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.testAutomation.factory.DriverManager;
import com.testAutomation.pages.CartPage;
import com.testAutomation.pages.HomePage;
import com.testAutomation.pages.ShopPage;

public class CartPageTest extends DriverManager{

	HomePage homePage;
	CartPage cartPage;
	ShopPage shopPage;
	
	@BeforeTest
	public void startApplication() throws IOException, InterruptedException {

		driver = initDriver();
		driver.get(properties.getProperty("AppUrl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		shopPage = new ShopPage(driver);
		cartPage = new CartPage(driver);
	}
	
	@Test
	public void addProductsToCart() throws InterruptedException {
		homePage = new HomePage(driver);
		homePage.passTestCharacters();
		homePage.productSearch("Computer");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@data-component-type='s-product-image'])[1]")));
		shopPage.addToCart();
		homePage.goToCartPage();
		cartPage.totalItemsOnCart();
		cartPage.totalPrice();
		cartPage.clickOnProceedToCheckout();
	}
	
    @AfterTest
    public void tearDown() {
   	 
//   	 driver.quit();
    }
}
