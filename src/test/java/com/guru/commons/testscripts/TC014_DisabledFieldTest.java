package com.guru.commons.testscripts;


import java.util.Properties;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.guru.Ecommerce.Automation.pageobjects.Author;
import com.guru.Ecommerce.Automation.pageobjects.DisabledField;
import com.guru.Ecommerce.Automation.testbase.TestBase;

public class TC014_DisabledFieldTest extends TestBase
{   @Author(authorName="Tarun Jaiswal")   

    Logger logger=Logger.getLogger(TC014_DisabledFieldTest.class.getName());	
	Properties prop=getTestDataFromProp();
    DisabledField disbledFild;
	@BeforeTest
	public void setUp()
	{
		Properties properties = getProp();
		String URL1 = properties.getProperty("BackURL");
		init(URL1);
	}

	@Test(priority=1)
	
	public void verifyDisabledFieldTest()
	{
		disbledFild=new DisabledField(driver);
		logger.info("============Starting verifyDisabledFieldTest()================== ");
		boolean typeStatus = disbledFild.isElementdisableOrNot();
		try
		{
			Assert.assertFalse(typeStatus);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		logger.info("============Finished verifyDisabledFieldTest()================== ");
		
	}
	
   @AfterTest
	
	public void tearDown()
	{
		closeDriver();
	}
}
