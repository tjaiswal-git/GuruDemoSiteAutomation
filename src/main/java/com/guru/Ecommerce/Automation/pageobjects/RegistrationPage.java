package com.guru.Ecommerce.Automation.pageobjects;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.guru.Ecommerce.Automation.testbase.TestBase;

public class RegistrationPage extends TestBase{

	public static final Logger logger = Logger.getLogger(RegistrationPage.class
			.getName());
	public WebDriver driver;

	public RegistrationPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath=".//*[@id='top']/body/div[1]/div/div[3]/div/div[4]/ul/li[1]/a")
	WebElement accLink;
	
	@FindBy(xpath="//span[text()='Create an Account']")
	WebElement createAcc;
	
	@FindBy(id="firstname")
	WebElement fstName;
	
	@FindBy(id="middlename")
	WebElement middleName;
	
	@FindBy(id="lastname")
	WebElement lstName;
	
	@FindBy(id="email_address")
	WebElement emailAddress;
	
	@FindBy(id="confirmation")
	WebElement confPassword;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(xpath="//button[@title='Register']")
	WebElement rigester;
	
	@FindBy(xpath="//span[text()='Thank you for registering with Main Website Store.']")
    WebElement registerSuccess;
	
	@FindBy(xpath="//a[text()='TV']")
	WebElement tvMenu;
	
	@FindBy(xpath=".//*[@id='top']/body/div[1]/div/div[2]/div/div[2]/div[1]/div[2]/ul/li[1]/div/div[2]/ul/li[1]/a")
    WebElement addToLgWishList;
	
	@FindBy(name="save_and_share")
	WebElement saveAndShare;
	
	@FindBy(id="email_address")
	WebElement emailIDShare;
	
	@FindBy(id="message")
	WebElement msgItm;
	
	@FindBy(xpath="//button[@title='Share Wishlist']")
	WebElement shareWish;
	
	@FindBy(xpath="//span[text()='Your Wishlist has been shared.']")
	WebElement sharedSuccesMsg;
	
	Properties prop=getTestDataFromProp();
	public String registrationPage()
	{   String regStatus=null;
	
		try{
			
		sleepTime(2);
		accLink.click();
		logger.info("acclink btn is clicked "+accLink.toString());
		createAcc.click();
		fstName.clear();
		fstName.sendKeys(prop.getProperty("fstName"));
		logger.info("fistName is enterd "+fstName.toString());
		middleName.clear();
		middleName.sendKeys(prop.getProperty("middleName"));
		logger.info("middle name is entered "+middleName.toString());
		lstName.clear();
		lstName.sendKeys(prop.getProperty("lstName"));
		logger.info("LastName is enterd "+lstName.toString());
		emailAddress.clear();
		emailAddress.sendKeys(prop.getProperty("emailId"));
		logger.info("email id is entered "+emailAddress.toString());
		password.clear();
		password.sendKeys(prop.getProperty("password"));
		logger.info("password is entered "+password.toString());
		confPassword.clear();
		confPassword.sendKeys(prop.getProperty("conPassword"));
		sleepTime(1);
		rigester.click();
		regStatus=registerSuccess.getText();
		getScreenShot("registrationSuceess");
		logger.info("registration is done!");
		}
		catch(ElementNotFoundException e)
		{
			e.printStackTrace();
		}
		return regStatus;
			}
	
	public String wishListAnsShareMsg()
	{
		tvMenu.click();
	    addToLgWishList.click();
	    saveAndShare.click();
	    emailIDShare.clear();
	    emailIDShare.sendKeys(prop.getProperty("emailShare"));
	    msgItm.clear();
	    msgItm.sendKeys(prop.getProperty("msgItem"));
	    shareWish.click();
	    sleepTime(1);
	    String shareMsg=sharedSuccesMsg.getText();
	    getScreenShot("wishListStatus");
	    return shareMsg;
	}
}
