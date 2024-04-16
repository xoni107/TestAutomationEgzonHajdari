package com.testAutomation.tests;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.testAutomation.factory.DriverManager;
import com.testAutomation.pages.SignUpPage;

public class SignUpTest extends DriverManager {
	
	SignUpPage signUpPage;

	@BeforeTest
	public void startApplication() throws IOException, InterruptedException {

		driver = initDriver();
		driver.get(properties.getProperty("SignUp"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
	}

	@Test
	public void validateLoginCredentails() throws InterruptedException {
		signUpPage = new SignUpPage(driver);
		String fnameString= "Egzon";
		String lnameString= "Hajdari";
		int month = 4;
		int day = 10;
		int year = 2001;
		String genderString = "Male";
		String passwString="EgzonTest##24";
		String confrimPaswString="EgzonTest##24";
		String phoneString = "0684444444";
		Thread.sleep(2000);
		
		try {
		    signUpPage.firstNameField(fnameString);
		    signUpPage.lastNameField(lnameString);
		} catch (IllegalArgumentException e) {
		    return;
		}
		
	
		signUpPage.clickNext();
		Thread.sleep(2000);
		signUpPage.monthField(month);
		signUpPage.dayOfBirth(day);
		signUpPage.yearOfBirth(year);
		signUpPage.chooseGender(genderString);
		signUpPage.clickNext();	
		Thread.sleep(2000);
		signUpPage.chooseEmailAddress();
		signUpPage.clickNext();
		signUpPage.choosePasw(passwString);
		signUpPage.confirmPasw(confrimPaswString);
		signUpPage.showPaswCheckBox();
		signUpPage.clickNext();
		signUpPage.phone(phoneString);
		signUpPage.clickNext();
	}
	@AfterTest
	public void tearDown() {

//   	 driver.quit();
	}
}
