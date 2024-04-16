package com.testAutomation.tests;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.testAutomation.factory.DriverManager;
import com.testAutomation.pages.SearchFilter;

public class SearchFilterTest extends DriverManager{

	SearchFilter searchFilter;
	
	@BeforeTest
	public void startApplication() throws IOException, InterruptedException {

		driver = initDriver();
		driver.get(properties.getProperty("seearchUrl"));
		driver.manage().window().maximize();
		Thread.sleep(10000);
	}
	
	@Test
	public void productSearch() throws InterruptedException {
		searchFilter = new SearchFilter(driver);	
		searchFilter.agreeButton();
		searchFilter.flightsTab();
		searchFilter.roundTripButton(2,2,1,"Tirana","Berlin","June","25");
	}

	@AfterTest
	public void tearDown() {

//		driver.quit();
	}
	
}
