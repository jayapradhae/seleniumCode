package com.hdfc.Pages;

import org.openqa.selenium.WebDriver;

public class WebTestcase {
	public static WebDriver driver;
	private PageFactory pageFactory;

	public WebTestcase() {
		setDriver(driver);
		pageFactory = new PageFactory(driver);
		
	}

	public PageFactory getPageFactory() {
		//System.out.println("pageFactory is " + pageFactory);
		return pageFactory;
	}

	public void setPageFactory(PageFactory pageFactory) {
		this.pageFactory = pageFactory;
	}
	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
	 //   super.setDriver(driver);
		this.driver = driver;
	}
}
