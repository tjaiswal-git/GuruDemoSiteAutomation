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

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.guru.Ecommerce.Automation.pageobjects.ComparePrdInList;
import com.guru.Ecommerce.Automation.testbase.TestBase;

public class TC003_ComparePrdTest extends TestBase {

	ComparePrdInList comparePrd;
	@BeforeTest
	public void setUp() {
		Properties properties = getProp();
		String URL1 = properties.getProperty("URL1");
		init(URL1);
	}

	@Test(priority = 1)
	public void verifycomparePrd() {
		comparePrd = new ComparePrdInList(driver);
		String cmpTex = comparePrd.ComparePrdWithName();
		try{
		org.testng.Assert.assertEquals(cmpTex, "COMPARE PRODUCTS");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Test(priority = 2, enabled = false)
	public void verifyCloseWindowPopup() {
		comparePrd = new ComparePrdInList(driver);
		comparePrd.WindowClosePop();
	}

}
