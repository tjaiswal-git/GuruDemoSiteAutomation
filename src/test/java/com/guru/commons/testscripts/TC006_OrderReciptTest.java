/*  Verify that you will be able to save previously placed order as a pdf file
 *  
 *  Note: This TestCase7b version is due to the below amended steps.
 *  
Test Steps:
1. Go to http://live.guru99.com/
2. Click on My Account link
3. Login in application using previously created credential 
4. Click on 'My Orders'
5. Click on 'View Order'
6. *** when steps 4 and 5 are executed, step 6 RECENT ORDERS was not displayed
   Verify the previously created order is displayed in 'RECENT ORDERS' table and status is Pending
7. Click on 'Print Order' link
8. *** note: the Change ... link was not found. 
   Click 'Change...' link and a popup will be opened as 'Select a destination' , select 'Save as PDF' link.
9. *** unable to execute this step, due to issue with step 8 issue
   Click on 'Save' button and save the file in some location.
10. *** unable to execute this step, due to steps 8 and 9 issues.
    Verify Order is saved as PDF
    
Expected results:
1. Previously created order is displayed in 'RECENT ORDERS' table and status is Pending.
2. Order is saved as PDF.


*/
package com.guru.commons.testscripts;

import java.awt.AWTException;
import java.io.IOException;
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
	
	public void verifyPlaceOrderPdfDownloadStatus() throws AWTException, IOException
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
