package com.testAutomation.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UploadFIle {

	public WebDriver driver;

	public UploadFIle(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[contains(@class,'uploader__browse_button')]")
	WebElement browseImages;

	@FindBy(xpath = "//a[@id='error-textbox']")
	WebElement errorMessage;

	@FindBy(xpath = "//span[contains(@class,'uploader__success_title')]")
	WebElement successMessage;

	@FindBy(xpath = "//a[@id='link-textbox']")
	WebElement linkScreenshot;

	public void uploadImage() {
		browseImages.click();
	}

	public String error() {
		String error = errorMessage.getText();
		System.out.println(errorMessage.getText());
		return error;
	}

	public String success() {
		String success = successMessage.getText();
		System.out.println(successMessage.getText());
		return success;
	}

	public String url() {
		String url = linkScreenshot.getText();
		System.out.println("link of the image = "+linkScreenshot.getText());
		linkScreenshot.click();
		return url;
	}

	public void fileUpload() throws AWTException {
		String filename="C:\\Users\\USER\\Downloads\\Software-Tester.png";
		StringSelection filedetails=new StringSelection(filename);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filedetails,null);
		Robot robot=new Robot();
		  robot.delay(1000);
		  robot.keyPress(KeyEvent.VK_CONTROL);
		  robot.keyPress(KeyEvent.VK_V);
		  robot.keyRelease(KeyEvent.VK_V);
		  robot.keyRelease(KeyEvent.VK_CONTROL);
		  robot.keyPress(KeyEvent.VK_ENTER);
		  robot.keyRelease(KeyEvent.VK_ENTER);
	}
}
