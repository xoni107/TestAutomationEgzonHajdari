package com.testAutomation.factory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {

	public WebDriver driver;
	public Properties properties;
	
	public WebDriver initDriver() throws IOException {
		
		properties = new Properties();
		String filePath = System.getProperty("user.dir") + "/configuration/config.properties";
		
		FileInputStream fileInputStream = new FileInputStream(filePath);
		properties.load(fileInputStream);
		
		String browserName = properties.getProperty("browser");
		if(browserName.equals("chrome")) {
			driver = new ChromeDriver();
		}else if(browserName.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		
		return driver;
	}
}
