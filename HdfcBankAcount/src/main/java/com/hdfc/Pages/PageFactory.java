package com.hdfc.Pages;

import org.openqa.selenium.WebDriver;

public class PageFactory extends WebTestcase {
	private LoginPage loginpage ;//= new AccountPage();
	private HomePage homepage ;//= new AgentsPage();
	private FundsTransferPage fundstransferpage;

	public PageFactory(WebDriver driver){
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		fundstransferpage = new FundsTransferPage(driver);
	}

	public LoginPage getLoginPage() {
		return loginpage;
	}
	public HomePage getHomePage() {
		return homepage;
	}	
	public FundsTransferPage getFundsTransferPage() {
		return fundstransferpage;
	}
}
