package com.testAutomation.tests;

import java.io.IOException;
import java.time.Duration;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.testAutomation.factory.DriverManager;
import com.testAutomation.pages.CheckTableRows;

public class CheckTableRowsTest extends DriverManager{
	
	CheckTableRows checkTableRows;

	@BeforeTest
	public void startApplication() throws IOException, InterruptedException {

		driver = initDriver();
		driver.get(properties.getProperty("tablesUrl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	}
	
	@Test
	public void filterTable() throws InterruptedException {
		
		checkTableRows = new CheckTableRows(driver);
		checkTableRows.selectByPosition("Support Engineer");
	}
}
