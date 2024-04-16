package com.testAutomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SignUpPage {

	public WebDriver driver;

	public SignUpPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "firstName")
	WebElement firstName;
	
	@FindBy(id = "lastName")
	WebElement lastName;
	
	@FindBy(xpath = "//*[text()='Next']")
	WebElement nextButton;
	
	@FindBy(id = "month")
	WebElement month;
	
	@FindBy(id = "day")
	WebElement day;
	
	@FindBy(id = "year")
	WebElement year;
	
	@FindBy(id = "gender")
	WebElement gender;
	
	@FindBy(xpath = "(//div[@jsname=\"CeL6Qc\"])[1]")
	WebElement chooseEmail;
	
	@FindBy(xpath = "//input[@name='Passwd']")
	WebElement password;
	
	@FindBy(xpath = "//input[@name='PasswdAgain']")
	WebElement confirmPassword;
	
	@FindBy(xpath = "//div[@data-value='optionc7']")
	WebElement showPassword;
	
	@FindBy(id = "phoneNumberId")
	WebElement phoneNumber;
	
	@FindBy(xpath = "//*[@id=\"dateError\"]/div")
	WebElement errorMess;
	
	public void firstNameField(String fname) throws InterruptedException {
		firstName.click();
		firstName.sendKeys(fname);
		boolean containsNumber = fname.matches(".*\\d.*");
		if(containsNumber) {
			System.out.println("Please use a correct name");
			throw new IllegalArgumentException("First name contains a number");
		}else {
			Thread.sleep(1000);
		}
	}
	
	public void lastNameField(String lname) throws InterruptedException {
		lastName.click();
		lastName.sendKeys(lname);
		boolean containsNumber = lname.matches(".*\\d.*");
		if(containsNumber) {
			System.out.println("Please use a correct last name");
			throw new IllegalArgumentException("Last name contains a number");
		}else {
			Thread.sleep(1000);
		}
	}
	
	
	
	public void monthField(int monthText) {
		if(monthText<1 || monthText>12) {
			System.out.println("Invalid value of month");
		}else {
			String stringValue = String.valueOf(monthText);
	        Select selectMonth = new Select(month);
	        selectMonth.selectByValue(stringValue);
		}
	}
	
	public void dayOfBirth(int dayBirth) {
		day.click();
		String stringValue = String.valueOf(dayBirth);
		day.sendKeys(stringValue);
	}
	
	public void yearOfBirth(int yearBirth) {
		year.click();
		String stringValue = String.valueOf(yearBirth);
		year.sendKeys(stringValue);
	}
	
	public void chooseGender(String genderString) {
		Select selectGender = new Select(gender);
		selectGender.selectByVisibleText(genderString);
	}
	
	public void chooseEmailAddress() {
		chooseEmail.click();
	}
	
	public void choosePasw(String passwordText) {
		password.click();
		password.sendKeys(passwordText);
	}
	
	public void confirmPasw(String PaswAgain) {
		confirmPassword.click();
		confirmPassword.sendKeys(PaswAgain);
	}
	
	public void showPaswCheckBox() {
		showPassword.click();
	}
	
	public void phone(String tel) {
		phoneNumber.click();
		String stringValue = String.valueOf(tel);
		phoneNumber.sendKeys(stringValue);
	}
	
	public void clickNext() {
		nextButton.click();
	}
	
	public String error() {
	String errorMessage =	errorMess.getText();
	return errorMessage.trim();
	}
}
