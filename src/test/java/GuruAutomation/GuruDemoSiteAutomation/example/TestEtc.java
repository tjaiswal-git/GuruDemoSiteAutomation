package GuruAutomation.GuruDemoSiteAutomation.example;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.guru.Ecommerce.Automation.testbase.TestBase;

public class TestEtc extends TestBase {
	@BeforeTest
	public void setUp()
	{
		Properties properties = getProp();
		String URL1 = properties.getProperty("URL1");
		init(URL1);
	}
    
	@Test
	public void test1()
	{
		sleepTime(2);
		driver.findElement(By.xpath(".//*[@id='top']/body/div[1]/div/div[3]/div/div[3]/ul/li[3]/a")).click();
	    driver.findElement(By.id("price")).clear();
	    driver.findElement(By.id("price")).sendKeys("0");
		sleepTime(2);
		driver.findElement(By.id("price_to")).clear();
		driver.findElement(By.id("price_to")).sendKeys("150");
		sleepTime(2);
		driver.findElement(By.xpath(".//*[@id='form-validate']/div[2]/button")).click();
		List<WebElement> ele = driver.findElements(By.xpath("//span[starts-with(@id,'product-price')]"));
		int len=ele.size();
	    for(WebElement element:ele)
	    {
	    	System.out.println(element.getText());
	    }

	}
	
	
}
