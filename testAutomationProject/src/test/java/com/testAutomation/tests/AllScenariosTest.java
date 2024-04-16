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
import com.testAutomation.pages.SignInPage;

public class AllScenariosTest extends DriverManager{

	HomePage homePage;
	SignInPage signInPage;
	ShopPage shopPage;
	CartPage cartPage;
	
	@BeforeTest
    public void startApplication() throws IOException, InterruptedException {
   	 
   	 driver= initDriver();
   	 driver.get(properties.getProperty("AppUrl"));
   	 driver.manage().window().maximize();
   	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }
    
    @Test
    public void validateLoginCredentails() throws InterruptedException {
    	homePage = new HomePage(driver);
    	homePage.passTestCharacters();
    	homePage.clickOnSignIn();
    	signInPage = new SignInPage(driver);
    	signInPage.usernameField("egzonhajdari04@gmail.com");
    	signInPage.clickConituneButton();
    	signInPage.passwordField("xoniamazon2024");
    	signInPage.clickOnSignIn();
    	Thread.sleep(5000);
    	homePage.filterCategory("Computers");
    	homePage.productSearch("Computer");
    	shopPage = new ShopPage(driver);
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@data-component-type='s-product-image'])[1]")));
		shopPage.addToCart();
		homePage.goToCartPage();
		cartPage = new CartPage(driver);
		cartPage.totalItemsOnCart();
		cartPage.totalPrice();
		cartPage.clickOnProceedToCheckout();
    	
    }
    
    @AfterTest
    public void tearDown() {
   	 
//   	 driver.quit();
    }
}
