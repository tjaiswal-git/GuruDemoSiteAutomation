package com.guru.Ecommerce.Automation.pageobjects;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.guru.Ecommerce.Automation.testbase.TestBase;

public class PurchasePrdThroughEmail extends TestBase{

	public static final Logger logger = Logger.getLogger(PurchasePrdThroughEmail.class
			.getName());
	public WebDriver driver;
    Properties prop=getTestDataFromProp();
	public PurchasePrdThroughEmail(WebDriver driver) 
	{

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath=".//*[@id='top']/body/div[1]/div/div[3]/div/div[4]/ul/li[1]/a")
	WebElement accLink;
	
	@FindBy(id="email")
	WebElement eamilId;
	
	@FindBy(id="pass")
	WebElement pass;
	
	@FindBy(id="send2")
	WebElement loginUser;
	
	@FindBy(xpath=".//*[@id='top']/body/div[1]/div/div[2]/div/div[1]/div/div[2]/ul/li[8]/a")
	WebElement wishList;

	@FindBy(xpath="//input[starts-with(@id,'reorder-item')]")
	WebElement addLastPrd;
	
	@FindBy(xpath="//button[@title='Add to Cart']")
	WebElement addCart;
	
	@FindBy(xpath="//button[@title='Proceed to Checkout']")
	WebElement checkout;
	
	//shipping information field
	
	@FindBy(id="billing:street1")
	WebElement address;
	
	@FindBy(id="billing:city")
	WebElement city;
	
	@FindBy(xpath=".//*[@id='billing:postcode']")
	WebElement postCode;
	
	@FindBy(id="billing:region_id")
	WebElement regionId;
	
	@FindBy(id="billing:country_id")
	WebElement seL_billingCountry;
	
	@FindBy(xpath=".//*[@id='billing:telephone']")
	WebElement billingTelephone;
	
	@FindBy(xpath="//button[@title='Continue']")
	WebElement Billcontinue;
	
	@FindBy(xpath="//span[text()='$5.00']")
	WebElement flatCst;
	
	@FindBy(xpath=".//*[@id='billing-progress-opcheckout']/dd/address")
	WebElement billingAddress;
	
	@FindBy(xpath=".//*[@id='shipping-progress-opcheckout']/dd/address")
	WebElement shippingAddress;
	
	@FindBy(xpath=".//*[@id='shipping-method-buttons-container']/button")
	WebElement continueShip;
	
	@FindBy(id="p_method_checkmo")
	WebElement orderMyCod;
	
	@FindBy(xpath=".//*[@id='payment-buttons-container']/button")
	WebElement paymentContinue;
	
	@FindBy(xpath="//span[text()='$620.00']")
	WebElement totalPrdcost;
	
	@FindBy(xpath="//button[@title='Place Order']")
	WebElement placeOrder;
	
	@FindBy(xpath=".//*[@id='top']/body/div[1]/div/div[2]/div/div/p[1]")

	WebElement orderId;
	
	@FindBy(xpath="//h1[text()='Your order has been received.']")
	WebElement OrderMsg;
   
	public String purchasePrdById()
	{
	 accLink.click();
	 sleepTime(1);
	 logger.info("account link is clicked "+accLink.toString());
	 eamilId.clear();
	 eamilId.sendKeys(prop.getProperty("emailId"));
	 logger.info("email is is entered "+eamilId.toString());
	 pass.clear();
	 pass.sendKeys(prop.getProperty("password"));
	 logger.info("pass is enterd "+pass.toString());
	 loginUser.click();
	 logger.info("login user is clicked "+loginUser.toString());
	 sleepTime(2);
	 wishList.click();
	 logger.info("wishList is clicked "+wishList.toString());
	 addCart.click();
	 logger.info("addcart is clicked "+addCart.toString());
	 checkout.click();
	 logger.info("checkout is proceed.. "+checkout.toString());
	 address.clear();
	 address.sendKeys(prop.getProperty("shipAddress"));
	 logger.info("ship address is entered "+address.toString());
	 
	 city.clear();
	 city.sendKeys(prop.getProperty("shipCity"));
	 logger.info("ship city is enterd "+city.toString());
	 
	 Select sel1=new Select(regionId);
	 sel1.selectByVisibleText("New York");
	 
	 sleepTime(2);
	 postCode.clear();
	 postCode.sendKeys("562568");
	 
	 Select select=new Select(seL_billingCountry);
	 select.selectByVisibleText(prop.getProperty("shipCountry"));
	 logger.info("county is selected "+select.toString());
	 
	 sleepTime(2);
	 billingTelephone.clear();
	 billingTelephone.sendKeys("2545445");
	 sleepTime(1);
	 Billcontinue.click();
	 
	 String fltCost=flatCst.getText();
	 return fltCost;
			 
  }
	public String billingAddress()
	{
		String billingAddress =this.billingAddress.getText();
		return billingAddress;
	}
	
	public String shippindAddress()
	{
		String shippingAdress=shippingAddress.getText();
		return shippingAdress;
	}

	public String confirmOrder()
	{
		continueShip.click();
		orderMyCod.click();
		sleepTime(1);
		paymentContinue.click();
		String totalPrdCost=totalPrdcost.getText();
		return totalPrdCost;
		
	}
	
	public String[] placeOrder()
	{
		placeOrder.click();
		String val[]=new String[2];
		val[0]=orderId.getText();
		val[1]=OrderMsg.getText();
		return val;
	}
}