package com.testAutomation.tests;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.testAutomation.factory.DriverManager;
import com.testAutomation.pages.HomePage;
import com.testAutomation.pages.ShopPage;
import com.testAutomation.pages.SignInPage;

public class SearchTest extends DriverManager {

	HomePage homePage;
	SignInPage signInPage;
	ShopPage shopPage;

	@BeforeTest
	public void startApplication() throws IOException, InterruptedException {

		driver = initDriver();
		driver.get(properties.getProperty("AppUrl"));
		driver.manage().window().maximize();
		Thread.sleep(10000);
	}

	@Test
	public void productSearch() throws InterruptedException {
		homePage = new HomePage(driver);
		homePage.passTestCharacters();
		homePage.filterCategory("Computers");
		Thread.sleep(2000);
		homePage.productSearch("Computer");		
	}

	@AfterTest
	public void tearDown() {

//		driver.quit();
	}
}
