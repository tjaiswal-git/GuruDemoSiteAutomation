package com.guru.Ecommerce.Automation.pageobjects;

import java.util.Properties;

import com.guru.Ecommerce.Automation.pageobjects.PlacedOrderReceipt;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;

import com.guru.Ecommerce.Automation.testbase.TestBase;

public class ReorderProduct extends TestBase{
    public WebDriver driver;
    public final Logger logger=Logger.getLogger(ReorderProduct.class.getName());
    Properties prop=getTestDataFromProp();
	public ReorderProduct(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="REORDER")
	WebElement reoder;
	
	@FindBy(xpath="//input[@title='Qty']")
	WebElement qty;
	
	@FindBy(xpath=".//*[@id='shopping-cart-table']/tbody/tr/td[4]/button")
	WebElement updateQty;
	
	@FindBy(xpath=".//*[@id='shopping-cart-table']/tbody/tr/td[5]/span/span")
	WebElement spanTextUpdateProducts;
	
	@FindBy(xpath=".//*[@id='top']/body/div[1]/div/div[2]/div/div/div/div[1]/ul/li/button")
	WebElement proccedTO;
	
	@FindBy(xpath="//*[@id='billing-buttons-container']/button")
	WebElement continueBtn;
	
	public String reorderPrducts()
	{
		PlacedOrderReceipt.myacc.click();
		 sleepTime(1);
		  for (String handle : driver.getWindowHandles()) 
		        {
		    	driver.switchTo().window(handle);
		    	}
		 logger.info("account link is clicked "+PlacedOrderReceipt.myacc.toString());
		 PlacedOrderReceipt.eamilId.clear();
		 PlacedOrderReceipt.eamilId.sendKeys(prop.getProperty("emailId"));
		 logger.info("email is is entered "+PlacedOrderReceipt.eamilId.toString());
		 PlacedOrderReceipt.pass.clear();
		 PlacedOrderReceipt.pass.sendKeys(prop.getProperty("password"));
		 logger.info("pass is enterd "+PlacedOrderReceipt.pass.toString());
		 PlacedOrderReceipt.loginUser.click();
		 logger.info("login user is clicked "+PlacedOrderReceipt.loginUser.toString());
		 
		  for (String handle : driver.getWindowHandles()) 
		        {
		    	driver.switchTo().window(handle);
		    	}
		  sleepTime(3);
		  reoder.click();
		  sleepTime(2);
		  qty.clear();
		  qty.sendKeys("10");
		  sleepTime(3);
		  updateQty.click();
		  String prdCost=spanTextUpdateProducts.getText();
		  return prdCost;
	}
	public String reorderPlaceContinue()
	{  
		sleepTime(2);
		proccedTO.click();
		logger.info("procced to ...");
		continueBtn.click();
		logger.info("Continue btn proceed "+continueBtn.toString());
		PurchasePrdThroughEmail.continueShip.click();
		logger.info("Continue ship btn is clicked..");
		PurchasePrdThroughEmail.orderMyCod.click();
		logger.info("Payment mode is selected..");
		PurchasePrdThroughEmail.paymentContinue.click();
		logger.info("payment btn continue is proceed. ");
		PurchasePrdThroughEmail.placeOrder.click();
		logger.info("place order btn is clicked..");
		String orderIdMsg=PurchasePrdThroughEmail.orderId.getText();
		logger.info("order id has been sent successfully.");
		return orderIdMsg;
	}
	
	@AfterTest
	
	public void tearDown()
	{
		closeDriver();
	}
	
}
