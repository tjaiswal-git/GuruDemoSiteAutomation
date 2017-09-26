package com.guru.Ecommerce.Automation.pageobjects.Login;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.guru.Ecommerce.Automation.testbase.TestBase;

/**
 * This class is used for backend login apps, that has access level is admin
 * @author tjaiswal
 *
 */

public class BackendLogin extends TestBase 
{
   
	//public static WebDriver driver;  
    public final static Logger logger=Logger.getLogger(BackendLogin.class.getName());
    static Properties prop=getPropOnlyLogin();
    public static WebDriver driver=TestBase.driver;
	public BackendLogin(WebDriver driver) 
	{
	TestBase.driver=driver;
	PageFactory.initElements(driver, this);
	}  
	
	public static WebElement getUserName()
	{
		return driver.findElement(By.cssSelector("#username"));
	}
	
	
	public static WebElement getPassword()
	{
		return driver.findElement(By.cssSelector("#login"));
	}
	
	public static WebElement loginbtn()
	{
		return driver.findElement(By.cssSelector("input[value='Login']"));
	}
	
	public static WebElement getClosePopup()
	{
		return driver.findElement(By.xpath(".//*[@id='message-popup-window']/div[1]/a/span"));
	}
	
	public static WebElement verifyLoggedUser()
	{
		return driver.findElement(By.xpath(".//*[contains(text(),'Logged in as')]"));
	}
	
	/**
	 * This method is used for backend apps login purpose, this is a static method
	 * @return
	 */

	public static boolean loginToBackendApps()
	{     
		
		boolean type=false;
		try{
		
		getUserName().clear();
		getUserName().sendKeys(prop.getProperty("BackUser"));
		
		logger.info("backend apps userName is entered");
		
		getPassword().clear();
		getPassword().sendKeys(prop.getProperty("BackPass"));
	
		logger.info("backend apps passWord is entered");
		
		loginbtn().click();
		logger.info("login is btn is clicked");
	    sleepTime(4);
	    for (String handle : driver.getWindowHandles()) {                                             
	    	driver.switchTo().window(handle);
	    	} 	 		
	    
	    if(getClosePopup().isDisplayed())
	    {
	    	getClosePopup().click();
	    	logger.info("Extra popup is closed");
	    }
	    
	    sleepTime(2);
	    if(verifyLoggedUser().isDisplayed())
	    {   
	    	sleepTime(2);
	    	String loggedText=verifyLoggedUser().getText().trim();
	    	if(loggedText.contains("Logged in as"))
	    	{
	    		type=true;
	    	}
	    }
	    else
	    {
	    	return false;
	    }
		}
		catch(NoSuchElementException e)
		{
			e.printStackTrace();
		}
		return type;
	}
	
}
