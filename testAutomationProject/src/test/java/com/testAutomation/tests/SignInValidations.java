package com.testAutomation.tests;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.List;

import com.testAutomation.factory.DriverManager;
import com.testAutomation.pages.HomePage;
import com.testAutomation.pages.SignInPage;

public class SignInValidations extends DriverManager {

	HomePage homePage;
	SignInPage signInPage;

	@BeforeTest
	public void startApplication() throws IOException, InterruptedException {

		driver = initDriver();
		driver.get(properties.getProperty("AppUrl"));
		driver.manage().window().maximize();
//   	 Thread.sleep(10000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}

	@Test
	public void validateLoginCredentails() throws InterruptedException {

		homePage = new HomePage(driver);
		homePage.passTestCharacters();
		homePage.clickOnSignIn();
		signInPage = new SignInPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='ap_email']")));
		signInPage.usernameField("egzonhajdari04@gmail.com");
		signInPage.clickConituneButton();
		List<WebElement> errorMessages = driver.findElements(By.xpath("//*[@id=\"auth-error-message-box\"]/div/div/ul/li/span"));
		if (!errorMessages.isEmpty()) {
			signInPage.checkEmail("We cannot find an account with that email address");
		} else {
			signInPage.passwordField("xoniamazon2024");
			signInPage.clickOnSignIn();
			List<WebElement> passwordErrorMessages = driver.findElements(By.xpath("//*[@id=\"auth-error-message-box\"]/div/div/ul/li/span"));
			if (!passwordErrorMessages.isEmpty()) {
				signInPage.verifyWarningAlert("Your password is incorrect");
			} else {
				// Continue
			}
		}
	}

	@AfterTest
	public void tearDown() {

//   	 driver.quit();
	}
}
