package com.testAutomation.tests;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.testAutomation.factory.DriverManager;
import com.testAutomation.pages.HomePage;
import com.testAutomation.pages.SignInPage;

public class testAutomationSignInTest extends DriverManager{

	HomePage homePage;
	SignInPage signInPage;
	
	@BeforeTest
    public void startApplication() throws IOException, InterruptedException {
   	 
   	 driver= initDriver();
   	 driver.get(properties.getProperty("AppUrl"));
   	 driver.manage().window().maximize();
   	 Thread.sleep(10000);
    }
    
    @Test
    public void validateLoginCredentails() throws InterruptedException {
    	homePage = new HomePage(driver);
    	Thread.sleep(10000);
    	homePage.clickOnSignIn();
    	signInPage = new SignInPage(driver);
    	signInPage.usernameField("egzonhajdari04@gmail.com");
    	signInPage.clickConituneButton();
    	Thread.sleep(3000);
    	signInPage.passwordField("xoniamazon2024");
    	signInPage.clickOnSignIn();
    	
    }
    
    @AfterTest
    public void tearDown() {
   	 
//   	 driver.quit();
    }
}
