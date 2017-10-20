package com.hdfc.Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;
import com.hdfc.common.CommonConfiguration;

public class LoginPage {

	public static WebDriver driver;
	public CommonConfiguration configuration;
	
	@FindBy(xpath = Elements.CustomerId)
	public static WebElement customerId;
	
	@FindBy(xpath = Elements.Password)
	public static WebElement passWord;
	
	@FindBy(xpath = Elements.ContinueLogin)
	public static WebElement continueLogin;
	
	@FindBy(xpath = Elements.SecureAccessImage)
	public static WebElement secureAccessImage;
	
	@FindBy(xpath = Elements.LoginButton)
	public static WebElement loginButton;
	
	public LoginPage(WebDriver driver2) {
		driver= driver2;
		configuration = new CommonConfiguration(driver2);
	}
	
	public void loginToApp(String userName, String password) {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Reporter.log("LoginTo App");
		customerId.sendKeys(userName);
		continueLogin.click();
		passWord.sendKeys(password);
		secureAccessImage.click();
		loginButton.click();
	}

}
