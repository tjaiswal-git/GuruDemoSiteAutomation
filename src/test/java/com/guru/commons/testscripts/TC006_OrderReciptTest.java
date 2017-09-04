package com.guru.commons.testscripts;

import java.awt.AWTException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.guru.Ecommerce.Automation.pageobjects.PlacedOrderReceipt;
import com.guru.Ecommerce.Automation.testbase.TestBase;

public class TC006_OrderReciptTest extends TestBase{
	Logger logger=Logger.getLogger(TC006_OrderReciptTest.class.getName());	
    PlacedOrderReceipt placedRC;
	@BeforeTest
	public void setUp()
	{
		Properties properties = getProp();
		String URL1 = properties.getProperty("URL1");
		init(URL1);
	}
 
	@Test(priority=1)
	
	public void verifyPlacedOrderStatus()
	{
		placedRC=new PlacedOrderReceipt(driver);
		String Billstatus=placedRC.placedOrderStatus();
		String expectedStatus=("PENDING");
	    try
	    {
		Assert.assertEquals(true, Billstatus.contains(expectedStatus));
	    }
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
	}
    
	@Test(priority=2)
	
	public void verifyPlaceOrderPdfDownloadStatus() throws AWTException
	{
		placedRC=new PlacedOrderReceipt(driver);
		boolean statusOfPdf=placedRC.placedOrderPdfDownloadStatus();
		System.out.println("status od download "+statusOfPdf);
		try
		{
			Assert.assertEquals(statusOfPdf,true);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@AfterTest
	
	public void tearDown()
	{
		closeDriver();
	}
}
