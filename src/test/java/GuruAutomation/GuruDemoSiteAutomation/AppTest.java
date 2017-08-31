package GuruAutomation.GuruDemoSiteAutomation;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
}


/*
 *  WebDriver popup = null;
    String popwin = "";
    boolean present;

    try {

        System.out.println(driver.getCurrentUrl());

        for (String winHandle : driver.getWindowHandles()) {
            System.out.println("WinHandle : " + winHandle);
            driver.switchTo().window(winHandle);
            Actions action = new Actions(popup);
            action.moveToElement(popup.findElement(by.id("idContinue"))).sendKeys(Keys.ENTER).build().perform();
            break; 
        }
 * 
 * 
 * 
 */
