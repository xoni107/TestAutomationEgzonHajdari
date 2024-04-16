package com.testAutomation.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckTableRows {
	
	public WebDriver driver;

	public CheckTableRows(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "button.next")
	WebElement nextPageButton;

	public void selectByPosition(String positionWanted) throws InterruptedException {
		List<WebElement> pages = driver.findElements(By.cssSelector("button.dt-paging-button"));
	    int totalPages = pages.size()-4;
		for (int i = 1; i <= totalPages; i++) {
            List<WebElement> rows = driver.findElements(By.cssSelector("table#example tbody tr"));
        for (WebElement row : rows) {
           String position = row.findElement(By.xpath("./td[2]")).getText();
            if (position.equals(positionWanted)) {
                String name = row.findElement(By.xpath("./td[1]")).getText();
                String office = row.findElement(By.xpath("./td[3]")).getText();
                String age = row.findElement(By.xpath("./td[4]")).getText();
                String startDate = row.findElement(By.xpath("./td[5]")).getText();

                System.out.println("Found on page number "+i);
                System.out.println("Name: " + name);
                System.out.println("Position: " + position);
                System.out.println("Office: " + office);
                System.out.println("Age: " + age);
                System.out.println("Start date: " + startDate);
                
                System.out.println("-----------------------------");
                Thread.sleep(1000);
            }
        }
        
        nextPageButton.click();
        
        Thread.sleep(1000);
	}
	}
	}
