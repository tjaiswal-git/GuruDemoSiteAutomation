package com.guru.Ecommerce.Automation.pageobjects;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortDate {

	public static void main(String args[]) throws ParseException
	{
	List<Person>persons = new ArrayList<>();

	 persons.add(new Person("MAR 2, 2001"));
	 persons.add(new Person("JAN 7, 2001"));
	 persons.add(new Person("JAN 2, 1976"));
	 persons.add(new Person("MAR 4, 1985"));

	Collections.sort(persons);

	 for(Person p : persons)
	   System.out.println(p.formatter.format(p.birthDay));
	
}
}