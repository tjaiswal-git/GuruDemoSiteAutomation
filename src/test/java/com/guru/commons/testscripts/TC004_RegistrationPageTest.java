/*      
	Test Steps:
	1. Goto http://live.guru99.com/
	2. Click on ‘MOBILE’ menu
	3. In mobile products list , click on ‘Add To Compare’ for 2 mobiles (Sony Xperia & Iphone)
	4. Click on ‘COMPARE’ button. A popup window opens
	5. Verify the pop-up window and check that the products are reflected in it
	   Heading "COMPARE PRODUCTS" with selected products in it.
	6. Close the Popup Windows
	*/
package com.guru.commons.testscripts;

import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.guru.Ecommerce.Automation.pageobjects.RegistrationPage;
import com.guru.Ecommerce.Automation.testbase.TestBase;

public class TC004_RegistrationPageTest extends TestBase 
{
	RegistrationPage registraionPage;
	@BeforeTest
	public void setUp()
	{
		Properties properties = getProp();
		String URL1 = properties.getProperty("URL1");
		init(URL1);
	}

	@Test(priority=1)
	
	public void verifyRegistration()
	{
		registraionPage=new RegistrationPage(driver);
		logger.info("===========Staring test RegistrationPage============");
		String statusPage=registraionPage.registrationPage();
		String expectedStatus=("Thank you for registering with Main Website Store.");
		try{
		Assert.assertEquals(statusPage, expectedStatus);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		logger.info("========Finished test verifyRegistration=============");
		
	}
	
	@Test(priority=2)
	
	public void verifyWishListAdded()
	{   
		registraionPage=new RegistrationPage(driver);
		logger.info("========Starting test verifyWishListAdded=============");
		String actualStatus=registraionPage.wishListAnsShareMsg();
		String exepctedStatus=("Your Wishlist has been shared.");
		try{
		Assert.assertEquals(actualStatus, exepctedStatus);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		logger.info("========Finished test verifyWishListAdded=============");
		
	}
    
	@AfterTest
	
	public void tearDown()
	{
		driver.close();
	}
}
