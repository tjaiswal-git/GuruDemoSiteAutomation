/*
Test Steps
Step 1. Goto http://live.guru99.com/
Step 2. Verify Title of the page
Step 3. Click on ‘MOBILE’ menu
Step 4. Verify Title of the page
Step 5. In the list of all mobile , select ‘SORT BY’ dropdown as ‘name’
Step 6. Verify all products are sorted by name
*/
package com.guru.commons.testscripts;

import java.util.ArrayList;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.guru.Ecommerce.Automation.pageobjects.MobileList;

public class TC001_MobileListTest extends
		com.guru.Ecommerce.Automation.testbase.TestBase {
	MobileList mobileList;

	@BeforeTest
	public void setUp() {
		Properties properties = getProp();
		String URL1 = properties.getProperty("URL1");
		init(URL1);
	}

	@Test(priority = 1)
	public void verifyTitle() {
		mobileList = new MobileList(driver);
		String titleTxt = mobileList.getHomePageTitle();
		String actualTxt = titleTxt.trim();
		try{
		getScreenShot("verifyTitle");
		Assert.assertEquals(actualTxt, "THIS IS DEMO SITE FOR");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		}

	@Test(priority = 2)
	public void verifyMobilePageTitle() {
		mobileList = new MobileList(driver);
		String actualmobilePageTitle = mobileList.mobilePageTitle();
		try{
		getScreenShot("verifyMobilePageTitle");
		Assert.assertEquals(actualmobilePageTitle, "MOBILE");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Test(priority = 3)
	public void verifyPrdInSortOrder() {
		mobileList = new MobileList(driver);
		ArrayList<String> data = mobileList.listOfPrd();
		getScreenShot("verifyPrdInSortOrder");
		System.out.println(data);
		int len = data.size();
		String previus = data.get(0);
		// int i=0;
		boolean type = true;
		for (int i = 1; i < len; i++) {
			String current = data.get(i);
			if (current.compareTo(previus) > 0)
				type = false;
			previus = current;

		}
		// type=true;
		try{
		Assert.assertFalse(type);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Test(priority = 4)
	public void verifyPrdSortInPrice() {
		mobileList = new MobileList(driver);
		ArrayList<String> data = mobileList.allPrdByPrice();
		getScreenShot("verifyPrdSortInPrice");
		System.out.println(data);
		String previus = data.get(0);
		int len = data.size();
		boolean type = true;
		for (int i = 1; i < len; i++) {
			String current = data.get(i);
			if (current.compareTo(previus) > 0)
				type = false;
			previus = current;

		}
		// type=true;
		Assert.assertFalse(type);
	}

	@Test(priority = 5)
	public void verifyPrdCostListToDetailsPage() {
		mobileList = new MobileList(driver);
		String actulaCost = mobileList.xperiaPrdCost();
		getScreenShot("xperiaPrdCost");
		String expectedCost = mobileList.afterDetailsXperiaCostPage();
		try{
		getScreenShot("afterDetailsXperiaCostPage");
		Assert.assertEquals(actulaCost, expectedCost);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@AfterTest
	public void close() {
		driver.close();
	}

	{

	}

}
