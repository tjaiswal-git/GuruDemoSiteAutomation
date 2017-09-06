package com.guru.Ecommerce.Automation.pageobjects;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.guru.Ecommerce.Automation.testbase.TestBase;

public class DiscountCoupon extends TestBase {
	public WebDriver diver;
	Properties prop=getTestDataFromProp();
	public DiscountCoupon(WebDriver driver)
	{
		this.diver=driver;
		PageFactory.initElements(diver, this);
	}

	@FindBy(xpath = "//a[text()='Mobile']")
	WebElement mobileBtn;
   
	@FindBy(xpath=".//*[@id='top']/body/div[1]/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[3]/div/div[3]/button")
	WebElement iphoneAddTOCart;
	
	@FindBy(id="coupon_code")
	WebElement couponCode;
	
	@FindBy(xpath="//button[@title='Apply']")
	WebElement applyCoupen;
	
	@FindBy(xpath="//button[@title='Proceed to Checkout']")
	WebElement checkout;
	
	@FindBy(id="onepage-guest-register-button")
	WebElement guest;
	
	@FindBy(id="billing:firstname")
	WebElement billFistname;
	
	@FindBy(id="billing:lastname")
	WebElement billLastname;
	
	@FindBy(id="billing:email")
	WebElement billEmail;
	
	@FindBy(id="billing:street1")
	WebElement billAddress;
	
	@FindBy(id="billing:city")
	WebElement billCity;
	
	@FindBy(id="billing:region_id")
	WebElement SelbillRigion;
	
	@FindBy(id="billing:postcode")
	WebElement billpostCode;
	
	@FindBy(id="billing:country_id")
	WebElement SelbillCountryId;
	
	@FindBy(id="billing:telephone")
	WebElement billTelephone;
	
	@FindBy(xpath=".//*[@id='billing-buttons-container']/button")
	WebElement billContinue;
	
	@FindBy(xpath=".//*[@id='shipping-method-buttons-container']/button")
	WebElement shippContainerBtn;
	
	@FindBy(id="p_method_checkmo")
	WebElement checkbtn;
	
	@FindBy(xpath=".//*[@id='payment-buttons-container']/button")
	WebElement paymentBtn;
	@FindBy(xpath="//span[text()='-$25.00']")
	WebElement discountMoney;

	public boolean discountByCoupen()
	{
		boolean type;
		mobileBtn.click();
		logger.info("mobile link is clicked.");
		sleepTime(3);
		iphoneAddTOCart.click();
		logger.info("iphone product is selected ");
	    sleepTime(1);
		couponCode.clear();
		couponCode.sendKeys(prop.getProperty("DiscountCoupen"));
		sleepTime(1);
		applyCoupen.click();
		logger.info("coupen is applied ");
		
		checkout.click();
		logger.info("checkout is clicked");
		sleepTime(1);
		guest.click();
		logger.info("guest acc is selected ");
		billFistname.clear();
		billFistname.sendKeys(prop.getProperty("billFirstName"));
		logger.info("fistname is entered ");
		
		
		billLastname.clear();
		billLastname.sendKeys(prop.getProperty("billLastName"));
		
		logger.info("Lastname is entered ");
		
		billEmail.clear();
		billEmail.sendKeys(prop.getProperty("billEmail"));
		
		logger.info("Email is entered ");
		
		billAddress.clear();
		billAddress.sendKeys(prop.getProperty("billAddress"));
		
		logger.info("Address is entered ");
		
		billCity.clear();
		billCity.sendKeys(prop.getProperty("billCity"));
		
		logger.info("billcity is entered ");
		
		Select billRegieon=new Select(SelbillRigion);
		billRegieon.selectByVisibleText("New York");
		
		billpostCode.clear();
		billpostCode.sendKeys(prop.getProperty("billPostCode"));
		
		logger.info("pincode is entered ");
		
		billTelephone.clear();
		billTelephone.sendKeys(prop.getProperty("billTelephone"));
		
		logger.info("telephone is entered ");
		
		billContinue.click();
		sleepTime(1);
		shippContainerBtn.click();
		checkbtn.click();
		paymentBtn.click();
		sleepTime(1);
		String discountMsg=discountMoney.getText();
		if(discountMoney.isDisplayed())
		{
			type=true;
		}
		else
		{
			type=false;
		}
		
		
		return type;
		
	}

}


