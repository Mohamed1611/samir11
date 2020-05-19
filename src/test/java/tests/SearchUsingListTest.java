package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductSelectionPage;
import pages.SearchPage;

public class SearchUsingListTest extends TestBase
{
	HomePage HomePageObject;
	SearchPage SearchPageObject;
	ProductSelectionPage ProductSelectionPageObject;

	String PartOfProductName = "Apple";
	String ProductName ="Apple iCam";

	@Test
	public void TestUserCanSearchWithList() throws InterruptedException
	{
		HomePageObject = new HomePage(driver);
		HomePageObject.UserCanSearchWithList(PartOfProductName);
		Thread.sleep(1000);
		ProductSelectionPageObject = new ProductSelectionPage(driver);
		Assert.assertTrue(ProductSelectionPageObject.ProductHeader.getText().equalsIgnoreCase(ProductName));
		Thread.sleep(2000);


	}
}
