/*  Verify user is able to purchase product using registered email id(USE CHROME BROWSER)     
Test Steps:
1. Go to http://live.guru99.com/
2. Click on my account link
3. Login in application using previously created credential
4. Click on MY WISHLIST link 
5. In next page, Click ADD TO CART link
6. Enter general shipping country, state/province and zip for the shipping cost estimate
7. Click Estimate 
8. Verify Shipping cost generated 
9. Select Shipping Cost, Update Total 
10. Verify shipping cost is added to total 
11. Click "Proceed to Checkout"
12a. Enter Billing Information, and click Continue
12b. Enter Shipping Information, and click Continue
13. In Shipping Method, Click Continue
14. In Payment Information select 'Check/Money Order' radio button. Click Continue
15. Click 'PLACE ORDER' button 
16. Verify Oder is generated. Note the order number

NOTE: PROCEED TO CHECKOUT (step 6 ) was taken out, so as to allow the Estimate button step to get processed. 
      Rest of the steps renumbered accordingly. 
*/
package com.guru.commons.testscripts;


import java.util.Properties;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.guru.Ecommerce.Automation.pageobjects.PurchasePrdThroughEmail;
import com.guru.Ecommerce.Automation.testbase.TestBase;

public class TC005_PurchasePurducts extends TestBase {
   PurchasePrdThroughEmail purchasePrdThroughemail;
   Logger logger=Logger.getLogger(TC005_PurchasePurducts.class.getName());	
    @BeforeTest
	public void setUp()
	{
		Properties properties = getProp();
		String URL1 = properties.getProperty("URL1");
		init(URL1);
	}
	
	@Test(priority=1)
	public void verifyPrdActualCost()
	{
		logger.info("========Starting Test verifyPrdActualCost()============= ");
		purchasePrdThroughemail=new PurchasePrdThroughEmail(driver);
		String fltCost=purchasePrdThroughemail.purchasePrdById();
		String expectedCost=("$5.00");
		try{
		Assert.assertEquals(fltCost, expectedCost);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		logger.info("========Finished Test verifyPrdActualCost()============= ");
		
	}
	
	@Test(priority=2)
	
	public void verifyAddress()
	{
		logger.info("========Starting Test verifyAddress()============= ");
		purchasePrdThroughemail=new PurchasePrdThroughEmail(driver);
	    try{
		Assert.assertEquals(purchasePrdThroughemail.billingAddress(), purchasePrdThroughemail.shippindAddress());
	    }
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
		logger.info("========Finished Test verifyAddress()============= ");
		
	}
	
	@Test(priority=3)
	
	public void verifyConfirmOrder()
	{
		logger.info("========Starting Test verifyConfirmOrder()============= ");
		purchasePrdThroughemail=new PurchasePrdThroughEmail(driver);
		String confirmorderCost=purchasePrdThroughemail.confirmOrder();
		String expectedCost=("$620.00");
		try{
		Assert.assertEquals(confirmorderCost, expectedCost);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		logger.info("========Finished Test verifyConfirmOrder()============= ");
		
	}
	
	@Test(priority=4)
	
	public void verifyPlaceOrder()
	{
		logger.info("========Starting Test verifyPlaceOrder()============= ");
		purchasePrdThroughemail=new PurchasePrdThroughEmail(driver);
		String Oderdetalils[]=purchasePrdThroughemail.placeOrder();
		try{
		Assert.assertEquals(true, Oderdetalils[0].contains("10000"));
		Assert.assertEquals(Oderdetalils[1], "Your order has been received.");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		logger.info("========Finished Test verifyPlaceOrder()============= ");
		
	}
	
	@AfterTest
	
	public void tearDown()
	{
		closeDriver();
	}
}
