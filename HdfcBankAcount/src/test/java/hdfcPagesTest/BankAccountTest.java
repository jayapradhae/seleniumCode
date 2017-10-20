package hdfcPagesTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hdfc.Pages.FundsTransferPage;
import com.hdfc.Pages.HomePage;
import com.hdfc.Pages.LoginPage;
import com.hdfc.Pages.PageFactory;
import com.hdfc.common.CommonConfiguration;
import com.hdfc.common.ExcelManager;
import com.hdfc.common.ReadExcelData;

public class BankAccountTest {
	
	private static final String String = null;
	PageFactory getPageFactory=null;
	WebDriver driver=null;
	private ExcelManager xls = null;
	private String biFilePath = "src/test/resources/InputExcel.xlsx";
	
	
	@BeforeClass
	public void openBrowser() throws InterruptedException
	{
		//xls = new ExcelManager(System.getProperty("user.dir") + "/" + biFilePath);
		System.out.println("driver=" + driver); 
		System.out.println("Browser Invoked");
		driver.manage().window().maximize();
		System.out.println("Browser Maximize");
		driver.get(CommonConfiguration.loginURL());
		driver.manage().timeouts().implicitlyWait(9, TimeUnit.SECONDS);
		System.out.println("Before class");
		LoginPage login= getPageFactory.getLoginPage();
		login.loginToApp(CommonConfiguration.loginUserName(),CommonConfiguration.loginPassword());
		//login.createUserAccount(Configuration.LoginUserName(),Configuration.Companycode());
	}
	
	@Test(dataProvider="accountDetails",testName = "VerifyAccountDetails", description = "This testcase will check for the account deatils")
	public void verifyAccountDetails(String accNumber, String branchName, String accountHolder, String balance)
	{
		String accNum = HomePage.getAccountNumber();
		String accBranch = HomePage.getBranchName();
		String accHolder = HomePage.getAccountHolderName();
		String accBalance = HomePage.getAccountBalance();
		List<String> accountDetails = new ArrayList<String>();
		accountDetails.add(accNum);
		accountDetails.add(accBranch);
		accountDetails.add(accHolder);
		accountDetails.add(accBalance);
		List<String> accountDetails1 = new ArrayList<String>();
		accountDetails1.add(accNumber);
		accountDetails1.add(branchName);
		accountDetails1.add(accountHolder);
		accountDetails1.add(balance);
		Collections.sort(accountDetails);
		Collections.sort(accountDetails1);
		for (int i = 0; i < accountDetails.size(); i++) {
			if (accountDetails.get(i).equalsIgnoreCase(accountDetails1.get(i))) {
				System.out.println("Values match");
			}
			else
			{
				System.out.println("Values doesnt match");
			}
		}
	}
	
	@Test(dataProvider="beneficiaryList",testName = "View list of beneficiaries", description = "This testcase will print the list of beneficiaries and assert the values")
	public void verifyBeneficiaryList(String beneficiary1, String beneficiary2, String beneficiary3, String beneficiary4,String beneficiary5,String beneficiary6)
	{
		String beneficiaryName1 = FundsTransferPage.getBeneficiary1();
		String beneficiaryName2 = FundsTransferPage.getBeneficiary2();
		String beneficiaryName3 = FundsTransferPage.getBeneficiary3();
		String beneficiaryName4 = FundsTransferPage.getBeneficiary4();
		String beneficiaryName5 = FundsTransferPage.getBeneficiary5();
		String beneficiaryName6 = FundsTransferPage.getBeneficiary6();
		List<String> beneficiaryList = new ArrayList<String>();
		beneficiaryList.add(beneficiaryName1);
		beneficiaryList.add(beneficiaryName2);
		beneficiaryList.add(beneficiaryName3);
		beneficiaryList.add(beneficiaryName4);
		beneficiaryList.add(beneficiaryName5);
		beneficiaryList.add(beneficiaryName6);
		List<String> beneficiaryList1 = new ArrayList<String>();
		beneficiaryList1.add(beneficiary1);
		beneficiaryList1.add(beneficiary2);
		beneficiaryList1.add(beneficiary3);
		beneficiaryList1.add(beneficiary4);
		beneficiaryList1.add(beneficiary5);
		beneficiaryList1.add(beneficiary6);
		Collections.sort(beneficiaryList);
		Collections.sort(beneficiaryList1);
		
		for (String beneficiary : beneficiaryList1) {
			System.out.println(beneficiary);
		}
		
		for (int i = 0; i < beneficiaryList.size(); i++) {
			if (beneficiaryList.get(i).equalsIgnoreCase(beneficiaryList1.get(i))) {
				System.out.println("Values match");
			}
			else
			{
				System.out.println("Values doesnt match");
			}
		}
	}
	
	@Test(testName = "Add Beneficiary", description = "This testcase will add a new beneficiary")
	public void addBeneficiary()
	{
		HomePage.clickFundsTransfer();
		FundsTransferPage.addBeneficiary();
	}
	
	
	@DataProvider(name = "accountDetails")
	public Object[][] getAccountDetails() throws InvalidFormatException, IOException {
	return new ReadExcelData().readExcel("AccDetails");	
	}
	
	@DataProvider(name = "beneficiaryList")
	public Object[][] getBeneficiaryList() throws InvalidFormatException, IOException {
	return new ReadExcelData().readExcel("ListBeneficiary");	
	}
	
	
	
	

}
