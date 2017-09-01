package com.guru.commons.testscripts;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import java.util.Properties;
import org.openqa.selenium.By;
import static org.testng.AssertJUnit.assertEquals;



import com.guru.Ecommerce.Automation.testbase.TestBase;

public class TestCase4 extends TestBase{
	 // private WebDriver driver;
	
	  
		@BeforeTest
		public void setUp() {
			Properties properties = getProp();
			String URL1 = properties.getProperty("URL1");
			init(URL1);
		}

	  
	  @Test
	  public void testTestCase4() throws Exception {
		
		// 1. Go to http://live.guru99.com
	 //   driver.get(baseUrl); 
	    
	    // 2. Click on Mobile menu
	    driver.findElement(By.linkText("MOBILE")).click();
	    Thread.sleep(1000);
	    
	    // 3. In mobile products list , click on ‘Add To Compare’ for 2 mobiles (Iphone & Sony Xperia)
	    
	    //note: store the title of the 2 mobiles for comparison for verification later when popup page comes up
	    driver.findElement(By.xpath(".//*[@id='top']/body/div[1]/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[1]/div/div[2]/ul/li[2]/a")).click();
	    String mainMobile1 = driver.findElement(By.xpath("//h2/a[@title='IPhone']")).getText();  // text captured - upperCase "IPHONE"
	    System.out.println("mainMobile1 = "+mainMobile1);
	    Thread.sleep(1000);
	    driver.findElement(By.xpath(".//*[@id='top']/body/div[1]/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[3]/div/div[3]/ul/li[2]/a")).click();   
	    String mainMobile2 = driver.findElement(By.xpath("//h2/a[@title='Sony Xperia']")).getText();  // text captured - upperCase "SONY XPERIA"
	    System.out.println("mainMobile2 = "+mainMobile2);
	    Thread.sleep(1000);
	    
	    // 4. Click on ‘COMPARE’ button. A popup window opens	   
	    driver.findElement(By.xpath("//button[@title='Compare']")).click();	    
	    Thread.sleep(1000);
	    
	    // switching to new window
	    for (String handle : driver.getWindowHandles()) {
	    	driver.switchTo().window(handle);
	    	}
	    
	    // 5. Verify the pop-up window and check that the products are reflected in it
	    //    Heading "COMPARE PRODUCTS" with selected products in it.
	    String strHead = ("COMPARE PRODUCTS");
	    String compHead = driver.findElement(By.xpath(".//*[@id='top']/body/div[1]/div[1]/h1")).getText();	
	    System.out.println("compHead = "+compHead);
	    sleepTime(2);
	    String popupMobile1 = driver.findElement(By.xpath("//h2/a[@title='IPhone']")).getText();  // text captured is "IPHONE" in uppercase
	    sleepTime(2);
	    String popupMobile2 = driver.findElement(By.xpath("//h2/a[@title='Sony Xperia']")).getText();  // text captured "SONY XPERIA" in uppercase
	    System.out.println("popupMobile1 = "+popupMobile1);
	    System.out.println("popupMobile2 = "+popupMobile2);
	    Thread.sleep(1000);
	    // to check the popup heading/title
	    try {	    	
	    	assertEquals(strHead, compHead);
		    } catch (Exception e) {
		    	e.printStackTrace();	    	
		    }	
	    // to check the 2 mobiles selected are the two in the popup - this is tp check the IPhone
	    try {	    	
	    	assertEquals(mainMobile1, popupMobile1);
		    } catch (Exception e) {
		    	e.printStackTrace();	    	
		    }	
	    // to check the 2 mobiles selected are the two in the popup - this is to check Sony X
	    try {	    	
	    	assertEquals(mainMobile2, popupMobile2);
		    } catch (Exception e) {
		    	e.printStackTrace();	    	
		    }	
	    	    
	    // 6. Close the Popup Windows
	    sleepTime(2);
	    driver.findElement(By.xpath("//button[@title='Close Window']")).click();
	    
	    // switching to new window
	    for (String handle : driver.getWindowHandles()) {
	    driver.switchTo().window(handle);
	    }	    
	  }
	
	@AfterTest
	public void tearDown()  {
		sleepTime(2);
		driver.quit();
	  }
	
	}