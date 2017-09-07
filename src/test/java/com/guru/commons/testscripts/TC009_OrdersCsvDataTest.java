package com.guru.commons.testscripts;

import java.awt.AWTException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.guru.Ecommerce.Automation.mailSender.emailReport;
import com.guru.Ecommerce.Automation.pageobjects.ExportAllOrder;
import com.guru.Ecommerce.Automation.testbase.TestBase;

public class TC009_OrdersCsvDataTest extends TestBase {

	Logger logger=Logger.getLogger(TC009_OrdersCsvDataTest.class.getName());	
    ExportAllOrder exportOdr;
	@BeforeTest
	public void setUp()
	{
		Properties properties = getProp();
		String URL1 = properties.getProperty("BackURL");
		init(URL1);
	}
	@Test(priority=1)
	
	public void verifyOrderCsvIsDownloadorNot() throws AWTException
	{
		logger.info("=========Starting verifyOrderCsvIsDownloadorNot()===============");
		exportOdr=new ExportAllOrder(driver);
		boolean DownloadStatus=exportOdr.orderCsvfileIsdownload();
		
		try{
		Assert.assertTrue(DownloadStatus);
		if(DownloadStatus==true)
		{
			verifyMailIsSent();
		}
		
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		logger.info("=========Finished verifyOrderCsvIsDownloadorNot()===============");
		
	}
	

	
	public void verifyMailIsSent()
	{
		boolean statusOfMail=emailReport.mailSenderWithAttachement("tarunjaiswal92@gmail.com", "tkjaiswal9292@gmail.com", "********");
		logger.info("mail status is "+statusOfMail);
		try{
		Assert.assertTrue(statusOfMail);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		logger.info("mail sent has successfully...");
	}
	
	@AfterTest
	
	public void tearDown()
	{
		closeDriver();
	}
}
