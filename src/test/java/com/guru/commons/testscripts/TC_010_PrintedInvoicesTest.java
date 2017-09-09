package com.guru.commons.testscripts;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.guru.Ecommerce.Automation.pageobjects.ExportAllOrder;
import com.guru.Ecommerce.Automation.pageobjects.InvoicesPrinted;
import com.guru.Ecommerce.Automation.testbase.TestBase;

public class TC_010_PrintedInvoicesTest extends TestBase {
	Logger logger=Logger.getLogger(TC_010_PrintedInvoicesTest.class.getName());	
    InvoicesPrinted printedOdr;
	@BeforeTest
	public void setUp()
	{
		Properties properties = getProp();
		String URL1 = properties.getProperty("BackURL");
		init(URL1);
	}
	
	@Test(priority=1)
	
	public void verifyInvoiceSatus()
	{
		printedOdr=new InvoicesPrinted(driver);
		ExportAllOrder exportOdr = new ExportAllOrder(driver);
		String ActualinvoicMsg=printedOdr.printedInvoicesChecked();
		String ExpectedInvoiceMsg=("There are no printable documents related to selected orders.");
		try
		{
		  Assert.assertEquals(ActualinvoicMsg, ExpectedInvoiceMsg);	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Test(priority=2)
	
	public void veridyInvoicesIsDownload()
	{
		printedOdr=new InvoicesPrinted(driver);
		try
		{
		 Assert.assertTrue(printedOdr.printedInvoicesIsDownloadOrNot());	
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
