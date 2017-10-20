package com.hdfc.common;

import java.io.File;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;

public class CommonConfiguration {
	
	public static Properties properties = new Properties();
	
	public static WebDriver driver;
	
	public static String url;
	public static String browser;
	public static String userName;
	public static String password;
	public static String beneficiaryName;
	public static String beneficiaryAccountNumber;
	public static String beneficiaryEmailId;
	
	public CommonConfiguration(WebDriver driver2) {
		driver=driver2;
	}
	

	static{
	url = properties.getProperty("url");		
	browser = properties.getProperty("Browser");		
	userName =properties.getProperty("customerId");
	password =properties.getProperty("password");
	beneficiaryName=properties.getProperty("beneficiaryName");
	beneficiaryAccountNumber=properties.getProperty("beneficiaryAccountNumber");
	beneficiaryEmailId=properties.getProperty("beneficiaryEmailId");
	}
	
	public static String loginURL() {
		Reporter.log("URL is: "+url, true);
		return url;

	}
	
	public static String loginUserName() {
		Reporter.log("userName is"+userName, true);
		return userName;

	}
	
	public static String loginPassword()
	{
		Reporter.log("userName is"+password, true);
		return password;
	}
	
	public static WebDriver browser() {
		Reporter.log("in browser loop",true);
		
		if (browser.equalsIgnoreCase("firefox")) {
			if(driver==null)
			driver = new FirefoxDriver();
			else 
				return driver;
			
		}
		else if (browser.equalsIgnoreCase("ie")) {
			if(driver==null){
			String filepath = "src/resources/IEDriverServer.exe";
			filepath = System.getProperty("user.dir") + "/" + filepath;
			File file = new File(filepath);
			System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
			driver = new InternetExplorerDriver();
			}
			else 
				return driver;
		}
		else if (browser.equalsIgnoreCase("chrome")) {
			if(driver==null){
			String filepath = "src/resources/chromedriver.exe";
			filepath = System.getProperty("user.dir") + "/" + filepath;
			File file = new File(filepath);
			System.setProperty("webdriver.chrome.driver",
					file.getAbsolutePath());

			driver = new ChromeDriver();
			}
			else 
				return driver;
		}
		return driver;
		
	}
	
	
}
