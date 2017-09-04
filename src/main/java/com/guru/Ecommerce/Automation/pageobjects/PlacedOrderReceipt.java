package com.guru.Ecommerce.Automation.pageobjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guru.Ecommerce.Automation.testbase.TestBase;

public class PlacedOrderReceipt extends TestBase{

	public WebDriver driver;
	Properties prop=getTestDataFromProp();
	public PlacedOrderReceipt(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="MY ACCOUNT")
	WebElement myacc;
	
	@FindBy(id="email")
	WebElement eamilId;
	
	@FindBy(id="pass")
	WebElement pass;
	
	@FindBy(id="send2")
	WebElement loginUser;
	
	@FindBy(linkText="MY ORDERS")
	WebElement myOrder;
	
	@FindBy(linkText="VIEW ORDER")
	WebElement viewOrder;
	
	@FindBy(xpath=".//*[@id='top']/body/div[1]/div/div[2]/div/div[2]/div/div[1]/h1")
	WebElement pendingStatus;
	
	@FindBy(linkText="Print Order")
	WebElement printOrder;
	
	
	public String placedOrderStatus()
	{     
		 myacc.click();
		 sleepTime(1);
		 logger.info("account link is clicked "+myacc.toString());
		 eamilId.clear();
		 eamilId.sendKeys(prop.getProperty("emailId"));
		 logger.info("email is is entered "+eamilId.toString());
		 pass.clear();
		 pass.sendKeys(prop.getProperty("password"));
		 logger.info("pass is enterd "+pass.toString());
		 loginUser.click();
		 logger.info("login user is clicked "+loginUser.toString());
		 myOrder.click();
		 logger.info("myoder link is clicked "+myOrder.toString());
		 viewOrder.click();
		 logger.info("viewOrder link is clicked "+viewOrder.toString());
		 String pandingStatus=pendingStatus.getText();
		 
		 
		 return pandingStatus;
		
	}
	
	public boolean placedOrderPdfDownloadStatus() throws AWTException
	{
		printOrder.click();
		Robot robot=new Robot();
		int[] execuate={KeyEvent.VK_T,KeyEvent.VK_K,KeyEvent.VK_J,KeyEvent.VK_DECIMAL,KeyEvent.VK_X,KeyEvent.VK_P,KeyEvent.VK_S};
		robot.delay(500);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.delay(330);
		for(int i=0;i<execuate.length;i++)	
		{
			robot.delay(200);
			robot.keyPress(execuate[i]);
			robot.keyRelease(execuate[i]);
		}
		
		boolean downloadStatus=isFileDownloaded(downloadPath, "tkj.xps");
		return downloadStatus;
		
		
	}
}
