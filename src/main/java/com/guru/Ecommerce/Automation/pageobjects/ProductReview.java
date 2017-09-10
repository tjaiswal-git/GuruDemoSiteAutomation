package com.guru.Ecommerce.Automation.pageobjects;

import java.util.Properties;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.guru.Ecommerce.Automation.testbase.TestBase;

public class ProductReview extends TestBase 
{
	public final Logger logger=Logger.getLogger(ProductReview.class.getName());
	Properties prop=getTestDataFromProp();
	Properties propLink=getProp();
	public ProductReview(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="review_field")
	WebElement reivewField;
	
	@FindBy(id="summary_field")
	WebElement summaryField;
	
	@FindBy(id="nickname_field")
	WebElement nickField;
	
	@FindBy(xpath="//button[@title='Submit Review']")
	WebElement submitReview;
	
	public WebElement credUser()
	{
		    return driver.findElement(By.id("username"));		
	}
	
	public WebElement credPass()
	{	
		return driver.findElement(By.id("login"));
	}
	
	public WebElement credLogin()
	{
		return driver.findElement(By.xpath("//input[@value='Login']"));
	}
	
	@FindBy(xpath="//span[text()='Catalog']")
	WebElement catalogBtn;
	
	@FindBy(xpath="//span[text()='Reviews and Ratings']")
	WebElement reviewAndRatings;
	
	@FindBy(xpath=".//*[@id='nav']/li[2]/ul/li/ul/li[1]/a/span")
	WebElement customerReview;
	
	@FindBy(xpath=".//*[@id='nav']/li[2]/ul/li/ul/li[1]/ul/li[1]/a/span")
	WebElement pendingReview;
	
	@FindBy(xpath=".//*[@id='reviwGrid_table']/tbody/tr[1]/td[10]/a")
	WebElement reviewTable;
	
	@FindBy(id="status_id")
	WebElement selStatusId;
	
	@FindBy(id="save_button")
	WebElement saveReview;
	
	@FindBy(xpath = ".//*[@id='nav']/ol/li[1]/a")
	WebElement mobileBtn;
	
	//driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"#");
	@FindBy(id="product-collection-image-1")
	WebElement imgBtn;
	
	@FindBy(xpath=".//*[@id='top']/body/div[1]/div/div[2]/div/div[2]/div[2]/div[2]/ul/li[2]/span")
	WebElement reviewLink;
	
	@FindBy(xpath=".//*[@id='customer-reviews']/dl/dd[1]")
	WebElement reivewMsg;
	
	public boolean reviewPosted()
	{  
		boolean typeStatus=false;
		try{
		
		sleepTime(2);
		reivewField.clear();
		reivewField.sendKeys(prop.getProperty("reviewField"));
		
		summaryField.clear();
		summaryField.sendKeys(prop.getProperty("summryField"));
		
		nickField.clear();
		nickField.sendKeys(prop.getProperty("nickField"));
		
		sleepTime(3);
		submitReview.click();
		sleepTime(5);
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
		logger.info("new tab is opened.");
		sleepTime(3);
		driver.get(propLink.getProperty("BackURL"));
		
		credUser().clear();
		credUser().sendKeys(prop.getProperty("BackUser"));
		sleepTime(2);
		
		credPass().clear();
		credPass().sendKeys(prop.getProperty("BackPass"));
		
		sleepTime(3);
		credLogin().click();
		//logger.info("Login is has been successfully done "+credLogin().toString());
		
		sleepTime(3);
		if (ExportAllOrder.closePopup.isDisplayed()) {
			ExportAllOrder.closePopup.click();
		}
		
		
		sleepTime(2);
		
		Actions actions=new Actions(driver);
		actions.moveToElement(catalogBtn).build().perform();
		sleepTime(2);
		actions.moveToElement(reviewAndRatings).build().perform();
		sleepTime(2);
		actions.moveToElement(customerReview).build().perform();
		sleepTime(2);
		pendingReview.click();
		sleepTime(2);
		reviewTable.click();
		
		sleepTime(2);
		Select selStatus=new Select(selStatusId);
		selStatus.selectByVisibleText("Approved");
		
		sleepTime(2);
		saveReview.click();
		
		sleepTime(5);
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL , Keys.SHIFT , Keys.TAB);
		 for (String handle : driver.getWindowHandles()) {
		    	driver.switchTo().window(handle);
		    	}
		logger.info("we come up on previous tab ");
		sleepTime(3);
		mobileBtn.click();
		sleepTime(2);
		imgBtn.click();
		reviewLink.click();
		logger.info("review link is clicked..");
		if(reivewMsg.isDisplayed())
		{
			typeStatus=true;
		}
		}
		catch(NoSuchElementException e)
		{
			e.printStackTrace();
		}
		return typeStatus;
	}

}
