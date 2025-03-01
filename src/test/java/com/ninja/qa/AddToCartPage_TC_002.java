package com.ninja.qa;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ninja.base.TestBase;
import com.ninja.pages.AddToCartPage;

public class AddToCartPage_TC_002 extends TestBase {

	AddToCartPage addToCartPage;
	String expectedProduct;
	String expectedSuccessMessage;

	public AddToCartPage_TC_002() throws Exception {
		super();
	}

	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		addToCartPage = new AddToCartPage(driver);
		expectedProduct = prop.getProperty("expectedProduct");
		expectedSuccessMessage = prop.getProperty("expectedSuccessMessage");
	}

	@Test(description = "Verify that an iMac can be added to cart successfully and checkout is completed")

	public void TestAddToCartPage_TC_002() throws Exception {
		addToCartPage.navigateToMac();
		String actualTextFirstProduct = addToCartPage.getDesktopsFirstMacText();
		assertEquals(expectedProduct, actualTextFirstProduct,
				"Text mismatch: Expected ' " + expectedProduct + " ' but found '" + actualTextFirstProduct + "'");
		System.out.println("Success: 'iMac' text is displayed correctly.");

		addToCartPage.AddtoCartiMac();
		String actualSuccessMessage = addToCartPage.SuccessPopUpAfterAddToCart();
		assertEquals(expectedSuccessMessage, actualSuccessMessage,
				"Text mismatch: Expected ' " + expectedSuccessMessage + " ' but found '" + actualSuccessMessage + "'");
		System.out
				.println("Success: 'Success: You have added iMac to your shopping cart!' text is displayed correctly.");

		addToCartPage.checkOutwithOneProduct();
		System.out.println("Checkout Done");

	}

	@AfterClass
	public void tearDown() {
		closeDriver();
	}

}
