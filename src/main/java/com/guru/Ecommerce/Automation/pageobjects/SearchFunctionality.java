package com.guru.Ecommerce.Automation.pageobjects;

import java.util.List;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guru.Ecommerce.Automation.testbase.TestBase;

public class SearchFunctionality extends TestBase {
    
	Properties prop=getTestDataFromProp();
	public final Logger logger=Logger.getLogger(SearchFunctionality.class.getName());
	public SearchFunctionality(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath=".//*[@id='top']/body/div[1]/div/div[3]/div/div[3]/ul/li[3]/a")
	WebElement advancedSearch;
	
	@FindBy(id="price")
	WebElement price;
	
	@FindBy(id="price_to")
	WebElement priceTo;
	
	@FindBy(xpath=".//*[@id='form-validate']/div[2]/button")
	WebElement searchBtn;
	
	public List<WebElement> getPrdPrice()
	{
		return driver.findElements(By.xpath("//span[starts-with(@id,'product-price')]"));
	}
	
	/*
	@FindBy(xpath="//span[starts-with(@id,'product-price')]")
	WebElement prdPrice;
	*/
	public String[] serachCriteriaThroughPrice()
	{
		//@SuppressWarnings("unused")
		System.out.println("getPrsPrice size "+getPrdPrice().size());
		String[] prdCostList=new String[2];
	    try{
		sleepTime(2);
		advancedSearch.click();
		logger.info("advanced search btn is clicked ");
		sleepTime(2);
		
		price.clear();
		price.sendKeys(prop.getProperty("priceStart"));
		logger.info("Inital price is entered");
		
		sleepTime(2);
		
		priceTo.clear();
		priceTo.sendKeys(prop.getProperty("priceEnd"));
		logger.info("Final price is entered");
		
		sleepTime(1);
		searchBtn.click();
		logger.info("search btn is clicked");
		
		 int i=0;
			
		for(WebElement element:getPrdPrice())
		{ 
			String correctedPrice =element.getText().replace("$", "");        
			prdCostList[i]=correctedPrice;
			i++;
		  
	
		}
	    }
	    catch(NoSuchElementException e)
	    {
	    	e.printStackTrace();
	    }
		return prdCostList;
		
	}
	

	
	
	
}
