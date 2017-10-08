package GuruAutomation.GuruDemoSiteAutomation;

import org.testng.annotations.Test;

import com.guru.Ecommerce.Automation.testbase.TestBase;

public class ParrelTesting extends TestBase {

	@Test
	public void testCaseOne() {
		//Printing Id of the thread on using which test method got executed
		System.out.println("Test Case One with Thread Id:- "
				+ Thread.currentThread().getId());
		sleepTime(8);
		System.out.println("Fist test done");
		
	}

	@Test
	public void testCaseTwo() {
		////Printing Id of the thread on using which test method got executed
		System.out.println("Test Case two with Thread Id:- "
				+ Thread.currentThread().getId());
		sleepTime(8);
		System.out.println("second test done");
		
	}
	
	@Test
	public void testCaseThree() {
		////Printing Id of the thread on using which test method got executed
		System.out.println("Test Case three with Thread Id:- "
				+ Thread.currentThread().getId());
		sleepTime(5);
		System.out.println("thrid test done");
		
	}
	
	
}
