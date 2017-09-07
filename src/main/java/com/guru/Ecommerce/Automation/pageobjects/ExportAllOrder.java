package com.guru.Ecommerce.Automation.pageobjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guru.Ecommerce.Automation.testbase.TestBase;

public class ExportAllOrder extends TestBase {

	public WebDriver diver;
    public final Logger logger=Logger.getLogger(ExportAllOrder.class.getName());
	Properties prop=getTestDataFromProp();
	public ExportAllOrder(WebDriver driver)
	{
		this.diver=driver;
		PageFactory.initElements(diver, this);
	}
	
	@FindBy(id="username")
	WebElement userName;
	
	@FindBy(id="login")
	WebElement password;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginBtn;
    
	@FindBy(xpath="//button[@title='Export']")
	WebElement exportBtn;
	
	@FindBy(xpath=".//*[@id='message-popup-window']/div[1]/a/span")
	WebElement closePopup;
	
	public boolean orderCsvfileIsdownload() throws AWTException
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
		/*	try{
		Alert alert=driver.switchTo().alert();
		alert.accept();;
		logger.info("Alert popup is dismiss now.");
		
		}
		catch(NoAlertPresentException e)
		{
			e.printStackTrace();
		}
		*/
		sleepTime(2);
		exportBtn.click();
		sleepTime(10);
		Robot robot=new Robot();
		robot.delay(300);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.delay(300);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.delay(300);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		
		robot.delay(300);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		logger.info("save file is clicked..");
		sleepTime(10);
		boolean downloadStatus=isFileDownloaded(downloadPath, "customers.csv");
		System.out.println("download status "+downloadStatus);
		sleepTime(3);
	    return downloadStatus;
	
   }
	
	
}
