package com.guru.commons.testscripts;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.guru.Ecommerce.Automation.pageobjects.CustomerDataInDataGrid;
import com.guru.Ecommerce.Automation.testbase.TestBase;

public class TC017_CustomerDataInGridTest extends TestBase {
	Logger logger=Logger.getLogger(TC017_CustomerDataInGridTest.class.getName());	
	Properties prop=getTestDataFromProp();
    CustomerDataInDataGrid custD;

    @BeforeTest
	public void setUp()
	{
		Properties properties = getProp();
		String URL1 = properties.getProperty("BackURL");
		init(URL1);
	}
    
    @Test(priority=1)
    
    public void verifyCustmerdataInDataGridTest()
    {
    	logger.info("============Starting verifyCustmerdataInDataGridTest() =================");
    	custD=new CustomerDataInDataGrid(driver);
    	int[] valAll = custD.TotalCustomerDataInGrid();
    	Assert.assertEquals(valAll[0], valAll[1]);
    	logger.info("============Finished verifyCustmerdataInDataGridTest() =================");
    	
    }
    
    @AfterTest
	
  	public void tearDown()
  	{ 
  		closeDriver();
  		
  	}
}
