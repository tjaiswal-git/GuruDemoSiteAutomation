package com.guru.Ecommerce.Automation.pageobjects;

import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guru.Ecommerce.Automation.testbase.TestBase;

public class ComparePrdInList extends TestBase {

	public static final Logger logger = Logger.getLogger(ComparePrdInList.class
			.getName());
	public WebDriver driver;

	public ComparePrdInList(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='Mobile']")
	WebElement mobileBtn;

	@FindBy(xpath = ".//*[@id='top']/body/div[1]/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[1]/div/div[2]/ul/li[2]/a")
	WebElement samsugPrdCompare;

	@FindBy(xpath = ".//*[@id='top']/body/div[1]/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[2]/div/div[3]/ul/li[2]/a")
	WebElement sonyExperiaCompare;

	@FindBy(xpath = "//button[@title='Compare']")
	WebElement comparePrd;

	@FindBy(xpath = "//h1['Compare Products']")
	WebElement comparePopUpWindowHeadertext;

	@FindBy(xpath = "//button[@title='Close Window']")
	WebElement windowClose;

	public String ComparePrdWithName() {

		mobileBtn.click();
		logger.info("mobile btn is clicked..");
		samsugPrdCompare.click();
		logger.info("samsung prd is added to compare "
				+ samsugPrdCompare.toString());
		sleepTime(1);
		sonyExperiaCompare.click();
		logger.info("sony prd is added to compare "
				+ sonyExperiaCompare.toString());
		sleepTime(1);
		comparePrd.click();
		logger.info("compare btn is clicked.. " + comparePrd.toString());
		sleepTime(2);
		Set<String> reciptHandle = driver.getWindowHandles();
		System.out.println("Recipt window handle " + reciptHandle);
		String handle = null;
		
		for (String handleValue : driver.getWindowHandles()) {
			System.out.println("HadleValue " + handleValue);
			sleepTime(2);
			// driver.switchTo().window(handleValue);
			handle = handleValue;
		}
		// String handleWin=driver.getWindowHandle();
		System.out.println("handle win " + handle);
		driver.switchTo().window(handle);

		String cmptext = comparePopUpWindowHeadertext.getText();
		sleepTime(3);
		// driver.switchTo().window(nameOrHandle)
		windowClose.click();
		return cmptext;
	}

	public void WindowClosePop() {

		windowClose.click();

		logger.info("close window is cliked " + windowClose.toString());

		// driver.switchTo().alert().dismiss();
		logger.info("close the window ");
	}

}
