package com.guru.commons.testscripts;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.jmx.LoggerDynamicMBean;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.testng.Assert;
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
		Assert.assertEquals(fltCost, expectedCost);
		logger.info("========Finished Test verifyPrdActualCost()============= ");
		
	}
	
	@Test(priority=2)
	
	public void verifyAddress()
	{
		logger.info("========Starting Test verifyAddress()============= ");
		purchasePrdThroughemail=new PurchasePrdThroughEmail(driver);
	    Assert.assertEquals(purchasePrdThroughemail.billingAddress(), purchasePrdThroughemail.shippindAddress());
		logger.info("========Finished Test verifyAddress()============= ");
		
	}
	
	@Test(priority=3)
	
	public void verifyConfirmOrder()
	{
		logger.info("========Starting Test verifyConfirmOrder()============= ");
		purchasePrdThroughemail=new PurchasePrdThroughEmail(driver);
		String confirmorderCost=purchasePrdThroughemail.confirmOrder();
		String expectedCost=("$620.00");
		Assert.assertEquals(confirmorderCost, expectedCost);
		logger.info("========Finished Test verifyConfirmOrder()============= ");
		
	}
	
	@Test(priority=4)
	
	public void verifyPlaceOrder()
	{
		logger.info("========Starting Test verifyPlaceOrder()============= ");
		purchasePrdThroughemail=new PurchasePrdThroughEmail(driver);
		String Oderdetalils[]=purchasePrdThroughemail.placeOrder();
		Assert.assertEquals(true, Oderdetalils[0].contains("10000"));
		Assert.assertEquals(Oderdetalils[1], "Your order has been received.");
		logger.info("========Finished Test verifyPlaceOrder()============= ");
		
	}
}
