package GuruAutomation.GuruDemoSiteAutomation;

import java.util.Vector;

public class Enumeration {

	public static void main(String arf[])
	{
		java.util.Enumeration enumObj;
		Vector<String> vec=new Vector<String>();
		vec.addElement("Java");
		vec.addElement("PHP");
		vec.addElement("Selenium");
		vec.addElement("Spark");
		vec.addElement("R language");
	    enumObj=vec.elements();
		while(enumObj.hasMoreElements())
		{
			System.out.println("Name : "+enumObj.nextElement());
		}
		
	}
	
}
