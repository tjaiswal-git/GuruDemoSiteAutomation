
/*
 1.Go to http://live.guru99.com/index.php/backendlogin
 2.Login with credentials provided
 3.Go to Customers-> Manage Customers menu
 4.Open any customer's detail by clicking on view link in the grid
 5.Click on 'Account Information' tab for the customer's detail page
 6. Verify disabled fields
 7. Verify Blank fields"
 */
package com.guru.Ecommerce.Automation.pageobjects;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.guru.Ecommerce.Automation.testbase.TestBase;

public class DisabledField extends TestBase 
{
	   
	Properties prop=getTestDataFromProp();
	public final org.apache.log4j.Logger logger=Logger.getLogger(DisabledField.class.getName());
	public DisabledField(WebDriver driver) 
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
	
	@FindBy(xpath=".//*[@id='message-popup-window']/div[1]/a/span")
	WebElement closePopup;
	
	@FindBy(xpath="//span[starts-with(text(),'Customers')]")
	WebElement customers;
	
	@FindBy(xpath=".//*[@id='nav']/li[3]/ul/li/a/span")
	WebElement manageCustomers;
	
	@FindBy(xpath=".//*[@id='customerGrid_table']/tbody/tr[1]/td[3]")
	WebElement customerSelect;
	
	@FindBy(xpath=".//*[contains(@id,'customer_info_tabs_account')]/span")
	WebElement cusAccountInfo;
	
	@FindBy(id="_accountwebsite_id")
	WebElement associateField;
	
	@FindBy(id="_accountcreated_in")
	WebElement accountCreatedField;
	
	public boolean isElementdisableOrNot()
	{   
		boolean type=false;
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
	    for (String handle : driver.getWindowHandles()) 
	        {                                             
	    	driver.switchTo().window(handle);
	    	} 	 		
	    
	    if(closePopup.isDisplayed())
	    {
	    	closePopup.click();
	    	logger.info("Extra popup is closed");
	    }
	    sleepTime(2);
	    Actions actions=new Actions(driver);
	    actions.moveToElement(customers).build().perform();
	    logger.info("Hover btn is performed ");
		manageCustomers.click();
		logger.info("Manage customer is clicked");
		customerSelect.click();
		sleepTime(2);
		cusAccountInfo.click();
		sleepTime(1);
		boolean t1=associateField.isEnabled();
		logger.info("element 1 status "+t1);
		sleepTime(2);
		boolean t2=	accountCreatedField.isEnabled();
		logger.info("element 2 status "+t2);
		type=(t1 && t2);
		logger.info("checking the element is enabled ot not "+type);
	}
	catch(NoSuchElementException e)
	{
		e.printStackTrace();
	}
		return type;
		
	}
}
