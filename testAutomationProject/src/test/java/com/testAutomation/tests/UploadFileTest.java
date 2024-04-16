package com.testAutomation.tests;

import java.awt.AWTException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.testAutomation.factory.DriverManager;
import com.testAutomation.pages.UploadFIle;

public class UploadFileTest extends DriverManager {

	UploadFIle uploadFIle;

	@BeforeTest
	public void startApplication() throws IOException, InterruptedException {

		driver = initDriver();
		driver.get(properties.getProperty("fileUploadUrl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@Test
	public void fileUpload() throws AWTException, InterruptedException {
	
		uploadFIle = new UploadFIle(driver);
		uploadFIle.uploadImage();
		uploadFIle.fileUpload();
		List<WebElement> message = driver.findElements(By.xpath("//*[text()='Wrong image type: jpg, png or gif please.']"));
		if (!message.isEmpty()) {
			uploadFIle.error();
		} else {
			Thread.sleep(3000);
			uploadFIle.success();
			Thread.sleep(3000);
			uploadFIle.url();
		}
	}
	

	@AfterTest
	public void tearDown() {
//		driver.quit();
	}
}
