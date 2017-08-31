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
		org.testng.Assert.assertEquals(cmpTex, "COMPARE PRODUCTS");

	}

	@Test(priority = 2, enabled = false)
	public void verifyCloseWindowPopup() {
		comparePrd = new ComparePrdInList(driver);
		comparePrd.WindowClosePop();
	}

}
