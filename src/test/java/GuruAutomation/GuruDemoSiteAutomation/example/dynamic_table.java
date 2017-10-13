package GuruAutomation.GuruDemoSiteAutomation.example;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.guru.Ecommerce.Automation.testbase.TestBase;

public class dynamic_table extends TestBase {
 WebDriver driver = null;

 @BeforeTest
 public void setup() throws Exception {
	
  
	 DesiredCapabilities ds = new DesiredCapabilities().firefox();
     ds.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
  //   ds.setCapability(FirefoxDriver.PROFILE, profile);


      // this is the important line - i.e. don't use Marionette
     ds.setCapability(FirefoxDriver.MARIONETTE, false);

     driver = new FirefoxDriver(ds);
     System.setProperty("webdriver.gecko.driver", "C:\\geko\\geckodriver.exe");
	 //System.setProperty("webdriver.gecko.driver", "C:\\geko\\geckodriver.exe");
  
  
  //driver = new FirefoxDriver();
  driver.manage().window().maximize();
  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  //driver.get("http://only-testing-blog.blogspot.in/2014/05/form.html");
  driver.get("file:///C:/Users/tjaiswal/Desktop/htmlfiles/textBox.html");
 }

 @AfterTest
 public void tearDown() throws Exception {
  driver.quit();
 }

 @Test
 public void Handle_Dynamic_Webtable() throws InterruptedException {
 
	//driver.findElement(By.id("text1")).sendKeys("tarunjaiswal5487456215485488");
	boolean status = preValidateSendKeysLen(driver.findElement(By.id("text1")), "tarunjaiswal5487456215485488");
	Assert.assertTrue(status);
//	String ele = driver.findElement(By.id("text1")).getAttribute("maxlength"); 
	// System.out.println(ele);
	/*
	 Actions action=new Actions(driver);
	action.contextClick().build().perform();
	Thread.sleep(3000); 
  //To locate table.
  WebElement mytable = driver.findElement(By.xpath(".//*[@id='post-body-8228718889842861683']/div[1]/table/tbody"));
  //To locate rows of table.
  List<WebElement> rows_table = mytable.findElements(By.tagName("tr"));
  //To calculate no of rows In table.
  int rows_count = rows_table.size();
  
  //Loop will execute till the last row of table.
  for (int row=0; row<rows_count; row++)
  {
   //To locate columns(cells) of that specific row.
   List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName("td"));
   //To calculate no of columns(cells) In that specific row.
   int columns_count = Columns_row.size();
   System.out.println("Number of cells In Row "+row+" are "+columns_count);
   
   //Loop will execute till the last cell of that specific row.
   for (int column=0; column<columns_count; column++)
   {
    //To retrieve text from that specific cell.
    String celtext = Columns_row.get(column).getText();
    System.out.println("Cell Value Of row number "+row+" and column number "+column+" Is "+celtext);
   }
   System.out.println("--------------------------------------------------");
  }  
 }  */
}}