package com.hdfc.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.hdfc.common.CommonConfiguration;

public class HomePage {
	
	public static WebDriver driver;
	public CommonConfiguration configuration;
	
	@FindBy(xpath = Elements.ViewAccountDetailsArrow)
	public static WebElement viewAccountDetailsArrow;
	
	@FindBy(xpath = Elements.AccountNumber)
	public static WebElement accountNumber;
	
	@FindBy(xpath = Elements.AccountBranchName)
	public static WebElement accountBranchName;
	
	@FindBy(xpath = Elements.AccountHolderName)
	public static WebElement accountHolderName;
	
	@FindBy(xpath = Elements.AccountBalance)
	public static WebElement accountBalance;
	
	@FindBy(xpath = Elements.FundsTransfer)
	public static WebElement fundsTransfer;

	public HomePage(WebDriver driver2) {
		driver= driver2;
		configuration = new CommonConfiguration(driver2);
	}

	public void clickAccountDetails()
	{
		viewAccountDetailsArrow.click();
		/*String accNum = accountNumber.getText();
		String accBranch = accountBranchName.getText();
		String accHolder = accountHolderName.getText();
		String accBalance = accountBalance.getText();*/
	}
	
	public static String getAccountNumber()
	{
		String accNum = accountNumber.getText();
		return accNum;
	}
	
	public static String getBranchName()
	{
		String accBranch = accountBranchName.getText();
		return accBranch;
	}
	
	public static String getAccountHolderName()
	{
		String accHolder = accountHolderName.getText();
		return accHolder;
	}
	
	public static String getAccountBalance()
	{
		String accBalance = accountBalance.getText();
		return accBalance;
	}
	
	public static void clickFundsTransfer()
	{
		fundsTransfer.click();
	}
	
}
