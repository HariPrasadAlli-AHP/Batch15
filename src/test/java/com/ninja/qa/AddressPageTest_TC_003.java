package com.ninja.qa;

import static org.testng.Assert.assertEquals;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ninja.base.TestBase;
import com.ninja.pages.AddressPage;

public class AddressPageTest_TC_003 extends TestBase {

	AddressPage addressPage;
	String expectedSuccessMessageOfRegistration;

	public AddressPageTest_TC_003() throws Exception {
		super();
	}

	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		addressPage = new AddressPage(driver, prop);
		expectedSuccessMessageOfRegistration = prop.getProperty("expectedProduct");
	}

	@Test(description = "Filling Address Details for the logged in User")
	public void FillAllRegistrationDetails() {
		
		Reporter.log("Test Description: Filling Address Details for the logged-in User", true);
		addressPage.NavigateToRegistrationPage();
		addressPage.EnterRegistrationDetails();
		addressPage.SubmitRegistrationForm();

		String ActualSuccessMessageOfRegistration = addressPage.isSuccessAccountCreation();
		String expectedSuccessMessageOfRegistration = "Your Account Has Been Created!";
		assertEquals(expectedSuccessMessageOfRegistration, ActualSuccessMessageOfRegistration,
				"Text mismatch: Expected '" + expectedSuccessMessageOfRegistration + "  ' but found '" + ActualSuccessMessageOfRegistration + "'");
		System.out.println("Success: 'Your Account Has Been Created!' text is displayed correctly.");
	}
	
	@AfterClass
    public void tearDown() {
        closeDriver();
    }

}
