package com.ninja.qa;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ninja.base.TestBase;
import com.ninja.pages.SearchPage;

public class SearchPage_TC_001 extends TestBase {

	public SearchPage_TC_001() throws Exception {
		super();
	}

	SearchPage searchPage;

	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		searchPage = new SearchPage(driver);
	}

	@Test
	public void TestSearchPage_TC_001() {
		searchPage.searchProductEnterName();
		assertTrue(searchPage.isMessagedisplayed(), "There is no product that matches the search criteria.");
		System.out.println("success");
	}
	
	@AfterClass
    public void tearDown() {
        closeDriver();
    }

}
