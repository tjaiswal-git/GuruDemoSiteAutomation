package com.guru.Ecommerce.Automation.pageobjects;

import java.util.Properties;







import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.guru.Ecommerce.Automation.testbase.TestBase;
import com.guru.Ecommerce.Automation.pageobjects.SearchCustomerThroughCountry;
import com.guru.Ecommerce.Automation.pageobjects.Login.BackendLogin;
public class CustomerDataInDataGrid extends TestBase 
{
    Properties prop=getProp();
    public final Logger logger=Logger.getLogger(CustomerDataInDataGrid.class.getName());
	
    public CustomerDataInDataGrid(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, SearchCustomerThroughCountry.class);
		PageFactory.initElements(driver, this);	
	}
	
	
	
	
	public int[] TotalCustomerDataInGrid()
	{   //BackendLogin back=new BackendLogin(driver);
		//logger.info("Login status "+back.loginToBackendApps());
	    int valueStore[]=new int[2];
		BackendLogin.loginToBackendApps();
	    //org.openqa.selenium.support.ui.Select selView=new org.openqa.selenium.support.ui.Select(SearchCustomerThroughCountry.viewSelection);
	    int count=0;
	    try{
	    SearchCustomerThroughCountry.viewSelection.click();
	    logger.info("view has selected "+SearchCustomerThroughCountry.viewSelection);
		int viewVal=Integer.parseInt(SearchCustomerThroughCountry.viewSelection.getText().trim());
	    valueStore[0]=viewVal;
	    for(int i=1;i<=viewVal;i++)
	    {   
	    	sleepTime(1);
	    	if(driver.findElement(By.xpath(".//*[@id='customerGrid_table']/tbody/tr["+i+"]/td[1]/input")).isDisplayed())
	    	{
	    		
	    		count++;
	    		logger.info("reading "+i+" customer data");
	    	}
	    }
	    valueStore[1]=count;
	    logger.info("total customer data in dataGrid is "+valueStore[1]);
		}
		catch(NoSuchElementException e)
		{
			e.printStackTrace();
		}
		return valueStore;
	   
    }
}