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

public class PaginationOperation extends TestBase
{
    Properties prop=getTestDataFromProp();
    Logger logger=Logger.getLogger(PaginationOperation.class.getName());
	public PaginationOperation(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css="#username")
	WebElement userName;
	
	@FindBy(css="#login")
	WebElement password;
	
	@FindBy(css="input[value='Login']")
	WebElement loginBtn;
	
	@FindBy(css=".active>span")
	WebElement cusTomer;
	
	@FindBy(xpath="//span[contains(text(),'Manage Customers')]")
	WebElement mngCustomers;
	
	@FindBy(css="img[alt='Go to Previous page']")
	WebElement previousPage;
	
	@FindBy(css="img[alt='Go to Next page']")
	WebElement nextPage;
	
	@FindBy(css=".input-text.page")
	WebElement pageValue;
	
	@FindBy(xpath=".//*[@id='message-popup-window']/div[1]/a/span")
	static WebElement closePopup;
	
	public int[] paginationTracking()
	{   
		int[] MainpagePreAndNextval=new int[2];
		int actualPage = 0;
		try
		{
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
		Actions actions=new Actions(driver);
		actions.moveToElement(cusTomer).build().perform(); //hover click
		mngCustomers.click();
		for(int i=1;i<=5;i++)
		{
			sleepTime(12);
			nextPage.click();
			sleepTime(2);
			
			logger.info("we are in page "+(i+1));
		}
	    String txt = pageValue.getAttribute("value");
	    logger.info("actual page number is (Next Level) "+txt.trim());
	    
	    actualPage=Integer.parseInt(txt.trim());
	    MainpagePreAndNextval[0]=actualPage;
	//    return actualPage;
	    sleepTime(12);
	    for(int i=1;i<=5;i++)
		{
			sleepTime(7);
			previousPage.click();
			logger.info("we are in page (Previous Level) "+(actualPage-i));
			sleepTime(2);
			
		}
	    String txt1 = pageValue.getAttribute("value");
	    actualPage=Integer.parseInt(txt1.trim());
		MainpagePreAndNextval[1]=actualPage;    
		}
		catch(NoSuchElementException e)
		{
			e.printStackTrace();
		}
		return MainpagePreAndNextval;
	  }
	
}
