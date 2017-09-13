package com.guru.Ecommerce.Automation.pageobjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guru.Ecommerce.Automation.testbase.TestBase;

public class SortingDateInInvoice extends TestBase
{
	public final Logger logger=Logger.getLogger(SortingDateInInvoice.class.getName());
	Properties prop=getTestDataFromProp();
	public SortingDateInInvoice(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="username")
	WebElement userName;
	
	@FindBy(id="login")
	WebElement password;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginBtn;
	
	@FindBy(xpath="//span[text()='Sales']")
	WebElement sales;
	
	@FindBy(xpath=".//*[@id='nav']/li[1]/ul/li[2]/a/span")
	WebElement invoices;
	
	@FindBy(xpath="//span[text()='Invoice Date']")
	WebElement invoiceAscSort;
  
	@FindBy(xpath="//span[text()='close']")
	WebElement closeBtn;
	
	public List<String> getDateFromInvoice()
	{  ArrayList<String> listOfDate=new ArrayList<String>();
	 
		try{
		userName.clear();
		userName.sendKeys(prop.getProperty("BackUser"));
		
		logger.info("backend apps userName is entered");
		
		password.clear();
		password.sendKeys(prop.getProperty("BackPass"));
	
		logger.info("backend apps passWord is entered");
		
		loginBtn.click();
		logger.info("login is btn is clicked");
	    sleepTime(4);
	    if(closeBtn.isDisplayed())
	    {
	    	closeBtn.click();
	    }
	    
	    for (String handle : driver.getWindowHandles()) {                                             
	    	driver.switchTo().window(handle);
	    	} 	 
	    sleepTime(2);
	    Actions action=new Actions(driver);
	    action.moveToElement(sales).build().perform();
	    sleepTime(2);
	    invoices.click();
	    sleepTime(2);
	    invoiceAscSort.click();
	   for(int i=1;i<=6;i++)
	   {   sleepTime(3);
	       //Aug 23, 2014 12:25:57 AM
		   String dateData=".//*[@id='sales_invoice_grid_table']/tbody/tr["+i+"]/td[3]";
           String spanDate=driver.findElement(By.xpath(dateData)).getText();
           String TrimData = spanDate.trim();
           String[] sp=TrimData.split(" ", 4);
           String newval=sp[0]+" "+sp[1]+" "+sp[2];
           System.out.println("new Val after extracting "+newval);
           listOfDate.add(newval);
           
	   }}
	catch(Exception e)
	{
		e.printStackTrace();
	}
		return listOfDate;
		
		
	}
	
}
