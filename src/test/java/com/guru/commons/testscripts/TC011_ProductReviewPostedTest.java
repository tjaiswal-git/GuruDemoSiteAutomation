/*
 * 
1. Go to http://live.guru99.com/.
2. Go To Link - http://live.guru99.com/index.php/review/product/list/id/1/
3. Fill the required review and submit it
4.Go to http://live.guru99.com/index.php/backendlogin
5.Login as with credentials provided
6. Go to Catalogue -> Reviews and Ratings -> Customer Reviews ->Pending Reviews Menu
7.Sort table by Id and select comment then click on Edit link
8.Change status to 'Approved' and click "Save Review"
9.Go to http://live.guru99.com/. Click Mobile Menu
10. Click on Sony Xperia image.
11. In detail page click on Review tab at bottom of page
12. Verify the review comment is shown

 */
package com.guru.commons.testscripts;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;




import com.guru.Ecommerce.Automation.pageobjects.ExportAllOrder;
import com.guru.Ecommerce.Automation.pageobjects.ProductReview;
import com.guru.Ecommerce.Automation.testbase.TestBase;

public class TC011_ProductReviewPostedTest extends TestBase {
	Logger logger=Logger.getLogger(TC011_ProductReviewPostedTest.class.getName());	
    ProductReview prdReview;
	@BeforeTest
	public void setUp()
	{
		Properties properties = getProp();
		String URL1 = properties.getProperty("prdURL");
		init(URL1);
	}
	
	@Test(priority=1)
	
	public void verifyPrductReviewPosted()
	{
		prdReview=new ProductReview(driver);
		ExportAllOrder exp=new ExportAllOrder(driver);
		boolean typeStatus = prdReview.reviewPosted();
		try
		{
			Assert.assertTrue(typeStatus);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@AfterTest
	
	public void tearDown()
	{
		closeDriver();
	}
}
