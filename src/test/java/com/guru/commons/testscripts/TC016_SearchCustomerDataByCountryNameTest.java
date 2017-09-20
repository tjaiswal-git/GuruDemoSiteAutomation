package com.guru.commons.testscripts;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.guru.Ecommerce.Automation.pageobjects.SearchCustomerThroughCountry;
import com.guru.Ecommerce.Automation.testbase.TestBase;

public class TC016_SearchCustomerDataByCountryNameTest extends TestBase {
	Logger logger=Logger.getLogger(TC016_SearchCustomerDataByCountryNameTest.class.getName());	
	Properties prop=getTestDataFromProp();
    SearchCustomerThroughCountry srchCountry;

    @BeforeTest
	public void setUp()
	{
		Properties properties = getProp();
		String URL1 = properties.getProperty("BackURL");
		init(URL1);
	}
    
    @Test(priority=1)
    
    public void verifySerachCustomerDataByCountryTest()
    {   
    	logger.info("============Starting verifySerachCustomerDataByCountryTest() =================");
    	srchCountry=new SearchCustomerThroughCountry(driver);
    	boolean status=srchCountry.searchCustomerDataByCountry();
    	try
    	{
    		Assert.assertTrue(status);
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	logger.info("============Finished verifySerachCustomerDataByCountryTest() =================");
    }
    
   @AfterTest
	
	public void tearDown()
	{ 
		closeDriver();
		
	}
}
