package com.guru.Ecommerce.Automation.pageobjects;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;



class Person implements Comparable<Person>
{
      Date birthDay;
      static SimpleDateFormat formatter = new SimpleDateFormat("MMM dd, yyyy");

      public Person(String birthDay) throws ParseException
      {
           this.birthDay = formatter.parse(birthDay); 

      }        

   
      public int compareTo(Person o) {
      Calendar cal1 = Calendar.getInstance();
      cal1.setTime(this.birthDay);
      Calendar cal2 = Calendar.getInstance();
      cal2.setTime(o.birthDay);

      
      int month1 = cal1.get(Calendar.MONTH); 
      int month2 = cal2.get(Calendar.MONTH);
      int year1=cal1.get(Calendar.YEAR);
      int year2=cal2.get(Calendar.YEAR);
 
      if(year1 < year2)  
        return -1;
      else if(month1 == month2)
        return cal1.get(Calendar.DAY_OF_MONTH) - cal2.get(Calendar.DAY_OF_MONTH);
      else if(year1==year2)
    		return  cal1.get(Calendar.MONTH)-cal2.get(Calendar.MONTH);
      else return 1;

    }
}