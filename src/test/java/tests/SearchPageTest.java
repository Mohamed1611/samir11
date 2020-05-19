package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductSelectionPage;
import pages.SearchPage;

public class SearchPageTest extends TestBase 
{
	HomePage HomePageObject;
	SearchPage SearchPageObject;
	ProductSelectionPage ProductSelectionPageObject;

	String ProductName ="Apple MacBook Pro 13-inch";

	@Test
	public void TestUserCanSearch() throws InterruptedException
	{
		HomePageObject = new HomePage(driver);
		HomePageObject.UserCanSearch(ProductName);
		Thread.sleep(3000);
		SearchPageObject = new SearchPage(driver);
		SearchPageObject.OpenProductLink();
		Thread.sleep(3000);
		ProductSelectionPageObject = new ProductSelectionPage(driver);
		Assert.assertTrue(ProductSelectionPageObject.ProductHeader.getText().equalsIgnoreCase(ProductName));
		Thread.sleep(3000);

	}


}
