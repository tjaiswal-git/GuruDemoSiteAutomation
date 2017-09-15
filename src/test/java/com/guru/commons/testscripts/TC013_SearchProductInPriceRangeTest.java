/*
 1. Go to http://live.guru99.com/index.php/
 2. Click on Advance Search
 3. In Price field enter range 0-150. Click Search
 4. Note the Price and Product Name in the result. Print on console
 5. Again, In Price field enter range 151-1000. Click Search
 6. Note the Price and Product Name in the result. Print on console"
 * 
 */
package com.guru.commons.testscripts;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.guru.Ecommerce.Automation.pageobjects.SearchFunctionality;
import com.guru.Ecommerce.Automation.testbase.TestBase;

public class TC013_SearchProductInPriceRangeTest extends TestBase {

	Logger logger=Logger.getLogger(TC013_SearchProductInPriceRangeTest.class.getName());	
	Properties prop=getTestDataFromProp();
    SearchFunctionality serhFun;
	@BeforeTest
	public void setUp()
	{
		Properties properties = getProp();
		String URL1 = properties.getProperty("URL1");
		init(URL1);
	}
	
	@Test(priority=1)
	
	public void verifySearchPrdInPrice()
	{
		serhFun=new SearchFunctionality(driver);
		logger.info("===============Starting test verifySearchPrdInPrice()================");
		for(int i=0;i<=1;i++){
		String[] ss = serhFun.serachCriteriaThroughPrice(i);
		for(String s:ss)
		{
			System.out.println("Actual Product Price is "+s);
			try
		    {
			float price=Float.parseFloat(s);
			float actualPrice = 0;
			if(i==0)
			{
		      actualPrice=Float.parseFloat(prop.getProperty("priceEnd"));
			}
			if(i==1)
			    {
				 actualPrice=Float.parseFloat(prop.getProperty("price2End"));
				}
				
			System.out.println("Product Range Price is "+actualPrice);
			if(price<=actualPrice)
			{
				Assert.assertTrue(true);
				logger.info("verified for the product price getting under the range "+" Range: "+actualPrice+" Product-Price: "+price);
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
		}
		}
		logger.info("===============Finished test verifySearchPrdInPrice()================");
	}
	
	@AfterTest
	
	public void tearDown()
	{
		closeDriver();
	}
}
