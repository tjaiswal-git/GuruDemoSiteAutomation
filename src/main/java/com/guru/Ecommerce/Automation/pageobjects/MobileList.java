package com.guru.Ecommerce.Automation.pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.apache.bcel.generic.Select;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.guru.Ecommerce.Automation.testbase.TestBase;

public class MobileList extends TestBase {
	public static final Logger logger = Logger.getLogger(MobileList.class
			.getName());
	public WebDriver driver;

	public MobileList(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='Mobile']")
	WebElement mobileBtn;

	@FindBy(xpath = "//h1[text()='Mobile']")
	WebElement mobileTitleTxt;

	@FindBy(xpath = "//select[@title='Sort By']")
	WebElement itemSortBySelection;

	@FindBy(xpath = ".//*[@id='top']/body/div[1]/div/div[2]/div/div[2]/div[1]/div[3]/ul/li/div/h2/a")
	By listofPrd;

	@FindBy(xpath = ".//*[@id='product-price-1']/span")
	WebElement xperiaPrdCost;

	@FindBy(xpath = "//a[@title='Sony Xperia']")
	WebElement xperiaLink;

	@FindBy(xpath = "//input[@class='input-text qty']")
	WebElement xperiaQty;

	@FindBy(xpath = "//button[@title='Update']")
	WebElement updateCart;

	@FindBy(xpath = "//button[@title='Add to Cart']")
	WebElement addtoCart;

	@FindBy(xpath = "//span[text()='Some of the products cannot be ordered in requested quantity.']")
	WebElement invaildPrdQtyAdded;

	@FindBy(id = "empty_cart_button")
	WebElement emptyCart;

	@FindBy(xpath = "//h1[text()='Shopping Cart is Empty']")
	WebElement shoppingCartVerifyText;

	public String getHomePageTitle() {
		String titleText = driver.findElement(By.cssSelector(".page-title>h2"))
				.getText();
		logger.info("Home page Title is send " + titleText.toString());
		return titleText;
	}

	public String mobilePageTitle() {
		mobileBtn.click();
		logger.info("Mobile btn link is clicked " + mobileBtn.toString());
		String mobileBtnText = mobileTitleTxt.getText();
		logger.info("Mobile btn text is send " + mobileBtnText.toString());
		return mobileBtnText;

	}

	public ArrayList<String> listOfPrd() {
		org.openqa.selenium.support.ui.Select selValue = new org.openqa.selenium.support.ui.Select(
				itemSortBySelection);
		selValue.selectByVisibleText("Name");
		logger.info("selection tag is select " + itemSortBySelection.toString());
		// int i=0;
		// String
		// xpathListPrd=".//*[@id='top']/body/div[1]/div/div[2]/div/div[2]/div[1]/div[3]/ul/li["+i+"]"+"/div/h2/a";

		ArrayList<String> allPrd = new ArrayList<String>();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// System.out.println("size of list "+xx.size());
		for (int i = 1; i <= 3; i++) {
			String text1 = driver
					.findElement(
							By.xpath(".//*[@id='top']/body/div[1]/div/div[2]/div/div[2]/div[1]/div[3]/ul/li["
									+ i + "]" + "/div/h2/a")).getText();

			System.out.println("Prd is " + text1);
			allPrd.add(text1);
		}

		return allPrd;

	}

	public ArrayList<String> allPrdByPrice() {
		org.openqa.selenium.support.ui.Select selValue = new org.openqa.selenium.support.ui.Select(
				itemSortBySelection);
		selValue.selectByVisibleText("Price");
		logger.info("selection tag is select " + itemSortBySelection.toString());
		// int i=0;
		// String
		// xpathListPrd=".//*[@id='top']/body/div[1]/div/div[2]/div/div[2]/div[1]/div[3]/ul/li["+i+"]"+"/div/h2/a";

		ArrayList<String> allPrd = new ArrayList<String>();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// System.out.println("size of list "+xx.size());
		for (int ii = 1; ii <= 2; ii++) {
			// int ii=0;
			// .//*[@id='product-price-2']/span
			String t = ".//*[@id='product-price-" + ii + "" + "'" + "]/span";
			String text1 = driver.findElement(
					By.xpath(".//*[@id='product-price-" + ii + "" + "'"
							+ "]/span")).getText();
			String text3 = driver.findElement(
					By.xpath(".//*[@id='product-price-3']")).getText();
			System.out.println("Prd is " + text1);
			allPrd.add(text1);
			if (ii == 2) {
				allPrd.add(2, text3);
			}
		}

		return allPrd;
	}

	public String xperiaPrdCost() {

		mobileBtn.click();
		logger.info("Mobile btn is clicked. " + mobileBtn.toString());
		String prdCost = xperiaPrdCost.getText();
		return prdCost;
	}

	public String afterDetailsXperiaCostPage() {
		xperiaLink.click();
		logger.info("xperia btn is clilked..");
		String prdDcost = xperiaPrdCost.getText();
		return prdDcost;

	}

	public String addXperiaprdinCart() {
		String spanInvaildMsg = null;
		try {
			mobileBtn.click();
			logger.info("mobile btn has clicked.." + mobileBtn.toString());
			sleepTime(2);
			xperiaLink.click();
			logger.info("xperia btn link has cliked.. " + xperiaLink.toString());
			addtoCart.click();
			logger.info("item is added " + addtoCart.toString());
			xperiaQty.clear();
			xperiaQty.sendKeys("1000");
			sleepTime(1);
			logger.info("xperiaQty is puted.. " + xperiaQty.toString());
			sleepTime(1);
			updateCart.click();
			logger.info("cart is updated .. " + updateCart.toString());
			spanInvaildMsg = invaildPrdQtyAdded.getText();
		} catch (ElementNotFoundException e) {
			logger.info("Exception is generated " + e.getMessage());
			e.printStackTrace();
		}

		return spanInvaildMsg;

	}

	public String emptyCart() {
		sleepTime(1);
		emptyCart.click();
		logger.info("cart empty link is clicked " + emptyCart.toString());
		String shoppingText = shoppingCartVerifyText.getText();
		logger.info("shopping empty cart is verified " + shoppingText);
		return shoppingText;
	}

}
