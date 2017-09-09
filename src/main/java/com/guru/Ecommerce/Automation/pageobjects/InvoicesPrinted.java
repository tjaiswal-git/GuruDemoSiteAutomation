package com.guru.Ecommerce.Automation.pageobjects;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.guru.Ecommerce.Automation.testbase.TestBase;

public class InvoicesPrinted extends TestBase {
	public final Logger logger=Logger.getLogger(InvoicesPrinted.class.getName());
	Properties prop=getTestDataFromProp();
	public InvoicesPrinted(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement credUser()
	{
		    return driver.findElement(By.id("username"));		
	}
	
	public WebElement credPass()
	{	
		return driver.findElement(By.id("login"));
	}
	
	public WebElement credLogin()
	{
		return driver.findElement(By.xpath("//input[@value='Login']"));
	}
	
	public WebElement salesBtn()
	{
		return driver.findElement(By.xpath("//span[text()='Sales']"));
	}
	
	public WebElement salesInOrders()
	{
		return driver.findElement(By.xpath(".//*[@id='nav']/li[1]/ul/li[1]/a/span"));
	}
	
	public WebElement statusSelectionList()
	{
		return driver.findElement(By.id("sales_order_grid_filter_status"));
	}
	
	public WebElement searchBtn()
	{
		return driver.findElement(By.xpath("//button[@title='Search']"));
				
	}
	
	
	public WebElement submitButton()
	{
		return driver.findElement(By.xpath("//button[@title='Submit']"));
	}
	
	public java.util.List<WebElement> selectCheckbox(int tdVal)
	{  
		String tdXapth;
	    java.util.List<WebElement> allElement=new ArrayList<WebElement>();
		for(int i=1;i<=tdVal;i++)
		{
		  sleepTime(3);	
	      tdXapth=".//*[@id='sales_order_grid_table']/tbody/tr["+i+"]"+"/td[1]/input";
	      allElement.add(driver.findElement(By.xpath(tdXapth)));
		}
		return allElement;
	}
	
	public WebElement selectionActionItem()
	{
		
		return driver.findElement(By.id("sales_order_grid_massaction-select"));
		
	}
	
	public WebElement submitActionBtn()
	{
		return driver.findElement(By.xpath("//button[starts-with(@id,'id_d0063')]"));
	}
	
	@FindBy(xpath=".//*[@id='messages']/ul/li/ul/li/span")
	WebElement spanMsg;
	
	public String printedInvoicesChecked()
	{   
		String spanMsg = null;
		try
		{
		credUser().clear();
		credUser().sendKeys(prop.getProperty("BackUser"));
		sleepTime(1);
		
		credPass().clear();
		credPass().sendKeys(prop.getProperty("BackPass"));
		
		credLogin().click();
		
		if (ExportAllOrder.closePopup.isDisplayed()) {
			ExportAllOrder.closePopup.click();
		}
		
		salesBtn().click();
		salesInOrders().click();
		sleepTime(2);
		
		Select selStatus=new Select(statusSelectionList());
		selStatus.selectByVisibleText("Canceled");
		sleepTime(2);
		searchBtn().click();
		sleepTime(3);
		List<WebElement> totalCheckbox = selectCheckbox(2);
		int lenBox=totalCheckbox.size();
		logger.info("total item is list "+totalCheckbox);
		
		for(WebElement val:totalCheckbox)
		{
		    val.click();	
		}
/*		for(int i=0;i<lenBox;i++)
		{   
			sleepTime(3);
			totalCheckbox.get(i).click();
			logger.info("check box is selected "+i);
			sleepTime(2);
		}
		*/
		sleepTime(2);
		
		Select selAction=new Select(selectionActionItem());
		selAction.selectByVisibleText("Print Invoices");
		submitButton().click();
		sleepTime(2);
		spanMsg=this.spanMsg.getText();
		logger.info("verify msg is  "+spanMsg);
		}
		catch(NoSuchElementException e)
		{
			e.printStackTrace();
		}
		return spanMsg;
		
	}
	
	public boolean printedInvoicesIsDownloadOrNot()
	{
		try
		{
	    sleepTime(5);
		Select selectStatus=new Select(statusSelectionList());
		selectStatus.selectByVisibleText("Complete");
		sleepTime(5);
		searchBtn().click();
		List<WebElement> totalCheckbox = selectCheckbox(1);
		int lenBox=totalCheckbox.size();
		
		for(WebElement val:totalCheckbox)
		{
		    val.click();	
		}
		
		/*
		for(int i=0;i<lenBox;i++)
		{
			sleepTime(3);
			totalCheckbox.get(i).click();
			logger.info("check box is selected "+i);
			sleepTime(2);
		}
		*/
		Select selAction=new Select(selectionActionItem());
		selAction.selectByVisibleText("Print Invoices");
		submitButton().click();
		sleepTime(2);
		}
		catch(NoSuchElementException e)
		{
			e.printStackTrace();
		}
		Robot robot;
		try {
			robot = new Robot();
			robot.delay(300);
			robot.keyPress(KeyEvent.VK_TAB); 
			robot.keyRelease(KeyEvent.VK_TAB); 
			
			robot.delay(300);
			robot.keyPress(KeyEvent.VK_TAB); 
			robot.keyRelease(KeyEvent.VK_TAB); 
			
			robot.delay(300);
			robot.keyPress(KeyEvent.VK_TAB); 
			robot.keyRelease(KeyEvent.VK_TAB); 
			
			robot.delay(300);
			robot.keyPress(KeyEvent.VK_ENTER); 
			robot.keyRelease(KeyEvent.VK_ENTER); 

			robot.delay(1000);
			
		} catch (AWTException e) {
			
			e.printStackTrace();
		}
		sleepTime(15);
		boolean isDownload=isFileDownloaded_Ext(downloadPath, ".pdf");
		
		return isDownload;
		
	}
	
	
}