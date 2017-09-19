
/*-------------------------------------------------------------------------------------------------------------------*\
|  Copyright (C) 2017-2021 Tarun                                                                                     |
|----------------------------------------------TestCase details------------------------------------------------------|                                                                                              |
|1.Go to http://live.guru99.com/index.php/backendlogin                                                               |          
|2.Login the credentials provided                                                                                    |
|3.Go to Customer-> Manage Customers                                                                                 |
|4.Go to Page and click next                                                                                         |                                                                                  |5.Capture the result page level and verify to the page Number.                                                      |
|6.Now go the previous page and same as Step:5"                                                                      |                      
\*-------------------------------------------------------------------------------------------------------------------*/

package com.guru.commons.testscripts;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.guru.Ecommerce.Automation.pageobjects.PaginationOperation;
import com.guru.Ecommerce.Automation.testbase.TestBase;



public class TC015_PaginationOperationTest extends TestBase {

    Logger logger=Logger.getLogger(TC015_PaginationOperationTest.class.getName());	
	Properties prop=getTestDataFromProp();
    PaginationOperation pageOps;
	@BeforeTest
	public void setUp()
	{
		Properties properties = getProp();
		String URL1 = properties.getProperty("BackURL");
		init(URL1);
	}
	
	@Test(priority=1)
	
	public void verifyPaginationTrackTest()
	{
		pageOps=new PaginationOperation(driver);
		logger.info("============Starting verifyPaginationTrackTest() =================");
		int[] Actualval = pageOps.paginationTracking();
		try{
		if(Actualval[0]>1 && Actualval[1]<=1)
		{   
		
			Assert.assertTrue(true);
		
		}
		else
		{
			Assert.fail();
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		logger.info("============Finished verifyPaginationTrackTest() =================");
		
		
	}
	
	@AfterTest
	
	public void tearDown()
	{ 
		closeDriver();
		
	}

}
