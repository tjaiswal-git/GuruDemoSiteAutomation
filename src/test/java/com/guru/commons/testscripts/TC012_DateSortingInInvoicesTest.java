package com.guru.commons.testscripts;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


import org.testng.annotations.Test;

import GuruAutomation.GuruDemoSiteAutomation.Person;

import com.guru.Ecommerce.Automation.pageobjects.SortingDateInInvoice;
import com.guru.Ecommerce.Automation.testbase.TestBase;

public class TC012_DateSortingInInvoicesTest extends TestBase 
{
	Logger logger=Logger.getLogger(TC012_DateSortingInInvoicesTest.class.getName());	
    SortingDateInInvoice sortDateInvoice;
	@BeforeTest
	public void setUp()
	{
		Properties properties = getProp();
		String URL1 = properties.getProperty("BackURL");
		init(URL1);
	}
    
	@Test(priority=1)
	public void verifySortDate() throws ParseException
	{
		sortDateInvoice=new SortingDateInInvoice(driver);
		List<String> Beforelist = sortDateInvoice.getDateFromInvoice();
		System.out.println(Beforelist);
		
		List<String> afterSort=new ArrayList<String>();
		List<Person>persons = new ArrayList<>();
	     int listLen=Beforelist.size();
	    
	     for(int i=0;i<listLen;i++)
	     {
	    	 persons.add(new Person(Beforelist.get(i)));
	    		
	     }

		Collections.sort(persons);

		 for(Person p : persons)
		 {
		   System.out.println(p.formatter.format(p.birthDay));
		    afterSort.add(p.formatter.format(p.birthDay));
	     }
		 System.out.println("After sort "+afterSort);
		 for(int ii=0;ii<afterSort.size();ii++){
			 Assert.assertEquals(Beforelist.get(ii),afterSort.get(ii));
		 }
}
	@AfterTest
	
	public void tearDown()
	{
		closeDriver();
	}
         
}
