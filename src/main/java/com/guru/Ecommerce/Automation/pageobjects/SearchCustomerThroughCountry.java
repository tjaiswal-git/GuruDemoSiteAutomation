/**  @author tjaiswal
 *   @description TestCase Details
 "1.Go to http://live.guru99.com/index.php/backendlogin
 2.Login the credentials provided
 3.Go to Customer-> Manage Customers
 4.Go to the Country selection box and set the ""India""
 5.Now click the Search button
 6.Verify the all customer have field country in page
 should show  the  ""india""
 "
 */

package com.guru.Ecommerce.Automation.pageobjects;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guru.Ecommerce.Automation.testbase.TestBase;

public class SearchCustomerThroughCountry extends TestBase
{
	    Properties prop=getTestDataFromProp();
	    Logger logger=Logger.getLogger(SearchCustomerThroughCountry.class.getName());
	public SearchCustomerThroughCountry(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="#username")
	public static WebElement userName;
	
	@FindBy(css="#login")
	public static WebElement password;
	
	@FindBy(css="input[value='Login']")
	public static WebElement loginBtn;
	
	//@FindBy(xpath="//option[@selected='selected']")
	@FindBy(xpath=".//*[@id='customerGrid']/table/tbody/tr/td[1]/select/option[3]")
	
	public static WebElement viewSelection;
	
	@FindBy(css="#customerGrid_filter_billing_country_id")
	WebElement selcountryName;

	@FindBy(xpath=".//*[@id='message-popup-window']/div[1]/a/span")
	static WebElement closePopup;
	
	@FindBy(xpath="//button[@title='Search']")
	WebElement searchBtn;
	// .//*[@id='customerGrid_table']/tbody/tr[1]/td[8]
	
	public String getCustomerCountry(String xPath,int i)
	{   
		sleepTime(1);
		String getVal=driver.findElement(By.xpath(xPath)).getText();
		logger.info(i+"Times getting country name "+getVal.trim());
		return getVal;
	}
	
	
	public boolean searchCustomerDataByCountry()
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
	    for (String handle : driver.getWindowHandles()) {                                             
	    	driver.switchTo().window(handle);
	    	} 	 		
	    
	    if(closePopup.isDisplayed())
	    {
	    	closePopup.click();
	    	logger.info("Extra popup is closed");
	    }
		//ownImplicitWait(5);
	    org.openqa.selenium.support.ui.Select selCtr=new org.openqa.selenium.support.ui.Select(selcountryName);
	    selCtr.selectByVisibleText("India");
	    sleepTime(8);
	   // ownFluentWait(searchBtn);
	    searchBtn.click();
	    sleepTime(2);
	    logger.info("search btn is clicked...");
	    
	    sleepTime(2);
	    String viewValue=viewSelection.getAttribute("value").trim();
	    System.out.println("value of view "+viewValue);
	    for(int i=1;i<=Integer.parseInt(viewValue);i++)
	    {
	    	String xpathString=".//*[@id='customerGrid_table']/tbody/tr["+i+"]/td[8]";
	    	if("India".contains(getCustomerCountry(xpathString, i).trim()))
	    	   {
	    		   type=true;
	    	   }
	    	else
	    	   {  
	    	break;
	    	   }
	    }
	}
	catch(NoSuchElementException e)
		{
		e.printStackTrace();
		}
		return type;
	
}
}


