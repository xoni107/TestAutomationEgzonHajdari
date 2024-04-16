package com.testAutomation.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchFilter {

	public WebDriver driver;

	public SearchFilter(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[@id='cm-acceptAll']")
	WebElement acceptPrivacy;
	
	@FindBy(xpath = "//*[text()='Flights']")
	WebElement flights;
	
	@FindBy(xpath = "//*[text()='Round trip']")
	WebElement roundTrip;
	
	@FindBy(xpath = "//button[contains(@class,'travel-details-opener')]")
	WebElement travelDetails;
	
	@FindBy(xpath = "(//*[text()='Economy'])[1]")
	WebElement travelClass;
	
	@FindBy(xpath = "//*[text()='Continue']")
	WebElement continueButton;
	
	@FindBy(xpath = "//input[@placeholder='From']")
	WebElement fromFlight;
	
	@FindBy(xpath = "(//div[contains(@class,'input-border-wrapper')])[2]")
	WebElement destination;
	
	@FindBy(xpath = "//input[@placeholder='Departure']")
	WebElement departure;
	
	@FindBy(xpath = "//*[text()='Search flights']")
	WebElement searchFlights;
	
	public void agreeButton() {
		acceptPrivacy.click();
	}
	
	public void flightsTab() {
		flights.click();
	}
	
	
	
	public void roundTripButton(int adults, int children, int infants, String airport, String dest, String month, String date) throws InterruptedException {
		roundTrip.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[4]/div/div/div[2]/div/div/div[2]/div[1]/div/section/div[2]/div[1]/div/div/form/div[1]/div[1]/div/div[2]/ul/li[2]/div")));
		
		WebElement oneWay = driver.findElement(By.xpath("/html/body/div[3]/div[4]/div/div/div[2]/div/div/div[2]/div[1]/div/section/div[2]/div[1]/div/div/form/div[1]/div[1]/div/div[2]/ul/li[2]/div"));
		oneWay.click();
		Thread.sleep(2000);
		
		travelDetails.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Travel Details']")));
		
		travelClass.click();
		WebElement economyElement = driver.findElement(By.xpath("(//*[text()='Economy'])[1]"));
		economyElement.click();
		Thread.sleep(1000);
		// Usage:
		incrementPassengers(adults, 1);
		incrementPassengers(children, 2);
		incrementPassengers(infants, 3);
		
		Thread.sleep(2000);
		
		WebElement additionalOptions = driver.findElement(By.xpath("//*[text()='Coupon']"));
		additionalOptions.click();
		Thread.sleep(2000);
		
		continueButton.click();
		Thread.sleep(2000);
		
//		fromFlight.click();
//		Thread.sleep(2000);
//		fromFlight.sendKeys(Keys.chord(Keys.CONTROL, "a"));
//		Thread.sleep(5000);
//		fromFlight.sendKeys(Keys.DELETE);
//		fromFlight.sendKeys(airport);
//		Thread.sleep(1000);
		
		destination.click();
		Thread.sleep(2000);
		destination.sendKeys(dest);
		Thread.sleep(1000);
		
		departure.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Departure date']")));
		
		if ( !driver.findElement(By.id("dcep-aeb6d95f9-507e-42e9-b380-0a5ebc747c5d-flm-flight-isOneWay")).isSelected() )
		{
		     driver.findElement(By.id("dcep-aeb6d95f9-507e-42e9-b380-0a5ebc747c5d-flm-flight-isOneWay")).click();
		}
		
		Thread.sleep(2000);
		
		WebElement monthDate = driver.findElement(By.id("dcep-aeb6d95f9-507e-42e9-b380-0a5ebc747c5d-flm-flight-month"));
		monthDate.click();
		
		List<WebElement> monthOptions = driver.findElements(By.xpath("//div[@class='selectable-result-list selectable-result-list-calendar']//div[@role='option']"));
        for (WebElement monthOption : monthOptions) {
            String monthText = monthOption.getText();
            if (monthText.equals(month)) {
                monthOption.click();
                break; 
            }
        }
        Thread.sleep(2000);
        
        
        List<WebElement> dateOptions = driver.findElements(By.xpath("//td[@role='button']//div[@class='calendar-day-item']"));
        for (WebElement dateOption : dateOptions) {
            String dateText = dateOption.getText();
            if (dateText.equals(date)) {
                dateOption.click(); 
                break;
            }
        }
        
		continueButton.click();
		Thread.sleep(2000);
		
		searchFlights.click();
		Thread.sleep(3000);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Please select your departure']")));
		
		WebElement selectTheLowestPriceElement = driver.findElement(By.xpath("//*[text()='Recommendation']"));
		selectTheLowestPriceElement.click();
		Thread.sleep(2000);
		WebElement selectCheapest = driver.findElement(By.xpath("//*[text()='Cheapest']"));
		selectCheapest.click();
		Thread.sleep(1000);
		WebElement clickFirstFlight = driver.findElement(By.xpath("(//button[@data-fare-family-group='eco'])[1]"));
		clickFirstFlight.click();
		Thread.sleep(2000);
		
		WebElement selectFlight = driver.findElement(By.xpath("//button[@id='selectFare-BC1-1-SLP9-7901607480822179057-3-WWWWM0SFL1']"));
		selectFlight.click();
		
	}
	public void incrementPassengers(int count, int index) {
	    WebElement plusicon = driver.findElement(By.xpath("(//button//i[contains(@class,'lh-plus')])[" + index + "]"));
	    for (int i = 1; i <= count; i++) {
	        plusicon.click();
	    }
	}
}
