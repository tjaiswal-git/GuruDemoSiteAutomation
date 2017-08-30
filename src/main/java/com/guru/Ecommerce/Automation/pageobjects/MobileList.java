package com.guru.Ecommerce.Automation.pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.apache.bcel.generic.Select;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

public class MobileList 
{
	public static final Logger logger=Logger.getLogger(MobileList.class.getName());
	public WebDriver driver;

	public MobileList(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='Mobile']")
	WebElement mobileBtn;
	
	
	@FindBy(xpath="//h1[text()='Mobile']")
	WebElement mobileTitleTxt;
	
	@FindBy(xpath="//select[@title='Sort By']")
	WebElement itemSortBySelection;
	
	@FindBy(xpath=".//*[@id='top']/body/div[1]/div/div[2]/div/div[2]/div[1]/div[3]/ul/li/div/h2/a")
	By listofPrd;
    
	@FindBy(xpath=".//*[@id='product-price-1']/span")
	WebElement xperiaPrdCost;
	
	@FindBy(xpath="//a[@title='Sony Xperia']")
	WebElement xperiaLink; 
	
	public String getHomePageTitle()
	{
		String titleText=driver.findElement(By.cssSelector(".page-title>h2")).getText();
		logger.info("Home page Title is send "+titleText.toString());
	    return titleText;
	}
	
	
	public String mobilePageTitle()
	{
	   mobileBtn.click();
	   logger.info("Mobile btn link is clicked "+mobileBtn.toString());
	  String mobileBtnText=mobileTitleTxt.getText();
	  logger.info("Mobile btn text is send "+mobileBtnText.toString());
	  return mobileBtnText;
		
	}
	
	public ArrayList<String> listOfPrd()
	{
		org.openqa.selenium.support.ui.Select selValue=new org.openqa.selenium.support.ui.Select(itemSortBySelection);
		selValue.selectByVisibleText("Name");
		logger.info("selection tag is select "+itemSortBySelection.toString());
		//int i=0;
		//String xpathListPrd=".//*[@id='top']/body/div[1]/div/div[2]/div/div[2]/div[1]/div[3]/ul/li["+i+"]"+"/div/h2/a";
		
		ArrayList<String> allPrd=new ArrayList<String>();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println("size of list "+xx.size());
		for(int i=1;i<=3;i++)
		{
		 String text1= driver.findElement(By.xpath(".//*[@id='top']/body/div[1]/div/div[2]/div/div[2]/div[1]/div[3]/ul/li["+i+"]"+"/div/h2/a")).getText();	
	    
		 System.out.println("Prd is "+text1);
		  allPrd.add(text1);
		}
		
		return allPrd;
		
	}
	
	public ArrayList<String> allPrdByPrice()
	{
		org.openqa.selenium.support.ui.Select selValue=new org.openqa.selenium.support.ui.Select(itemSortBySelection);
		selValue.selectByVisibleText("Price");
		logger.info("selection tag is select "+itemSortBySelection.toString());
		//int i=0;
		//String xpathListPrd=".//*[@id='top']/body/div[1]/div/div[2]/div/div[2]/div[1]/div[3]/ul/li["+i+"]"+"/div/h2/a";
		
		ArrayList<String> allPrd=new ArrayList<String>();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println("size of list "+xx.size());
		for(int ii=1;ii<=2;ii++)
		{
			//int ii=0;
		//	.//*[@id='product-price-2']/span
		String t=".//*[@id='product-price-"+ii+""+"'"+"]/span";	
		 String text1= driver.findElement(By.xpath(".//*[@id='product-price-"+ii+""+"'"+"]/span")).getText();	
	     String text3=driver.findElement(By.xpath(".//*[@id='product-price-3']")).getText();
		 System.out.println("Prd is "+text1);
		  allPrd.add(text1);
		  if(ii==2)
		  {
		  allPrd.add(2, text3);
		  }
		}
		
		return allPrd;
	}
	
	
	  public String xperiaPrdCost()
	  {
		  
		  mobileBtn.click();
		 logger.info("Mobile btn is clicked. "+mobileBtn.toString());
		 String prdCost=xperiaPrdCost.getText();
		 return prdCost;
	  }
	  
	  public String afterDetailsXperiaCostPage()
	  {
		  xperiaLink.click();
		  logger.info("xperia btn is clilked..");
		  String prdDcost=xperiaPrdCost.getText();
		  return prdDcost;
		  
	  }
}
