package com.guru.commons.testscripts;

import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.guru.Ecommerce.Automation.pageobjects.MobileList;
import com.guru.Ecommerce.Automation.testbase.TestBase;

public class TC002_AddCartOptionTest extends TestBase {

	MobileList mobileList;

	@BeforeTest
	public void setUp() {
		Properties properties = getProp();
		String URL1 = properties.getProperty("URL1");
		init(URL1);
	}

	@Test(priority = 1)
	public void verifyMaxPrdAvailableInStore() {
		logger.info("============Starting Test==========================");
		mobileList = new MobileList(driver);
		String prdStatus = mobileList.addXperiaprdinCart();
		try{
		Assert.assertEquals(prdStatus,
				"Some of the products cannot be ordered in requested quantity.");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		logger.info("============Finished Test==========================");
	}

	@Test(priority = 2)
	public void verifyPrdEmptyInCart() {
		logger.info("============Starting Test==========================");
		mobileList = new MobileList(driver);
		String cartStatus = mobileList.emptyCart();
		try{
		Assert.assertEquals(cartStatus, "SHOPPING CART IS EMPTY");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		logger.info("============Finished Test==========================");
	}
    
	@AfterTest
	public void tearDown()
	{
		closeDriver();
	}
}
