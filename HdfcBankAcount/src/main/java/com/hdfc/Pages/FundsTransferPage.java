package com.hdfc.Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.hdfc.common.CommonConfiguration;

public class FundsTransferPage {
	
	public static WebDriver driver;
	public CommonConfiguration configuration;
	
	@FindBy(xpath = Elements.RequestAccount)
	public static WebElement requestAccount;
	
	@FindBy(xpath = Elements.BeneficiaryEmailId)
	public static WebElement beneficiaryEmailId;
	
	@FindBy(xpath = Elements.AddBeneficiary)
	public static WebElement addBeneficiary;
	
	@FindBy(xpath = Elements.BeneficiaryAccountNumber)
	public static WebElement beneficiaryAccountNumber;
	
	@FindBy(xpath = Elements.BeneficiaryReEnterAccountNumber)
	public static WebElement beneficiaryReEnterAccountNumber;
	
	@FindBy(xpath = Elements.BeneficiaryName1)
	public static WebElement beneficiaryName1;
	
	@FindBy(xpath = Elements.BeneficiaryName2)
	public static WebElement beneficiaryName2;
	
	@FindBy(xpath = Elements.BeneficiaryName3)
	public static WebElement beneficiaryName3;
	
	@FindBy(xpath = Elements.BeneficiaryName4)
	public static WebElement beneficiaryName4;
	
	@FindBy(xpath = Elements.BeneficiaryName5)
	public static WebElement beneficiaryName5;
	
	@FindBy(xpath = Elements.BeneficiaryName6)
	public static WebElement beneficiaryName6;
	
	@FindBy(xpath = Elements.BeneficiaryNickName)
	public static WebElement beneficiaryNickName;
	
	@FindBy(xpath = Elements.BeneficiaryAddButton)
	public static WebElement beneficiaryAddButton;
	
	@FindBy(xpath = Elements.BeneficiaryConfirm)
	public static WebElement beneficiaryConfirm;
	
	public FundsTransferPage(WebDriver driver2) {
		driver= driver2;
		configuration = new CommonConfiguration(driver2);
	}
	
	public static void addBeneficiary()
	{
		requestAccount.click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		addBeneficiary.click();
		beneficiaryAccountNumber.sendKeys(CommonConfiguration.beneficiaryAccountNumber);
		beneficiaryReEnterAccountNumber.sendKeys(CommonConfiguration.beneficiaryAccountNumber);
		beneficiaryNickName.sendKeys(CommonConfiguration.beneficiaryName);
		beneficiaryEmailId.sendKeys(CommonConfiguration.beneficiaryEmailId);
		beneficiaryAddButton.click();
		Alert alt = driver.switchTo().alert();
		alt.accept();
		beneficiaryConfirm.click();
	}
	
	public static String getBeneficiary1()
	{
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		String beneficiary_Name1 = beneficiaryName1.getText();
		return beneficiary_Name1;
	}
	
	public static String getBeneficiary2()
	{
		String beneficiary_Name2 = beneficiaryName2.getText();
		return beneficiary_Name2;
	}
	
	public static String getBeneficiary3()
	{
		String beneficiary_Name3 = beneficiaryName3.getText();
		return beneficiary_Name3;
	}
	
	public static String getBeneficiary4()
	{
		String beneficiary_Name4 = beneficiaryName4.getText();
		return beneficiary_Name4;
	}
	
	public static String getBeneficiary5()
	{
		String beneficiary_Name5 = beneficiaryName5.getText();
		return beneficiary_Name5;
	}
	
	public static String getBeneficiary6()
	{
		String beneficiary_Name6 = beneficiaryName6.getText();
		return beneficiary_Name6;
	}
	
}
