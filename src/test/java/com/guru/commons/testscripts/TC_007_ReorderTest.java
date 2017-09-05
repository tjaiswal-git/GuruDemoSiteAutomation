/*  Verify you are able to change or reorder previously added product
 *  Test Data = QTY = 10
Test Steps:
1. Go to http://live.guru99.com/
2. Click on my account link
3. Login in application using previously created credential
4. Click on 'REORDER' link , change QTY & click Update
5. Verify Grand Total is changed
6. Complete Billing & Shipping Information
7. Verify order is generated and note the order number

Expected outcomes:
1) Grand Total is Changed
2) Order number is generated
*/

package com.guru.commons.testscripts;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.guru.Ecommerce.Automation.pageobjects.PlacedOrderReceipt;
import com.guru.Ecommerce.Automation.pageobjects.PurchasePrdThroughEmail;
import com.guru.Ecommerce.Automation.pageobjects.ReorderProduct;
import com.guru.Ecommerce.Automation.testbase.TestBase;

public class TC_007_ReorderTest extends TestBase {
	ReorderProduct reoderPrd;
	PlacedOrderReceipt placedRecipt;
	PurchasePrdThroughEmail purchase;
	Logger logger=Logger.getLogger(TC_007_ReorderTest.class.getName());	
	    @BeforeTest
		public void setUp()
		{
			Properties properties = getProp();
			String URL1 = properties.getProperty("URL1");
			init(URL1);
		}
		
	    @Test(priority=1)
	    
	    public void verifyReoderPrdTotalCost()
	    {
	    	logger.info("=========starting test verifyReoderPrdTotalCost() =================");
	    	reoderPrd=new ReorderProduct(driver);
	    	placedRecipt=new PlacedOrderReceipt(driver);
	    	purchase=new PurchasePrdThroughEmail(driver);
	    	String totalCost=reoderPrd.reorderPrducts();
	    	String expectedCost=("$6,150.00");
	    	try{
	    	Assert.assertEquals(totalCost, expectedCost);
	    	}
	    	catch(Exception e)
	    	{
	    		e.printStackTrace();
	    	}
	    	logger.info("=========Finished test verifyReoderPrdTotalCost() =================");
		    
	    }
	    
	    @Test(priority=2)
	    
	    public void verifyReoderIdConfirmation()
	    {
	    	logger.info("=========starting test verifyReoderIdConfirmation() =================");
	    	reoderPrd=new ReorderProduct(driver);
	    	String orderId=reoderPrd.reorderPlaceContinue();
	    	try{
	    	Assert.assertEquals(true, orderId.contains("10000"));
	    	}
	    	catch(Exception e)
	    	{
	    		e.printStackTrace();
	    	}
	    	logger.info("=========starting test verifyReoderIdConfirmation() =================");
	    	
	    }

	   @AfterTest
	   public void tearDown()
	   {
		   closeDriver();
	   }
	  
}
