package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductSelectionPage;
import pages.SearchPage;

public class ChangeCurrecnyTest extends TestBase
{
	
	HomePage HomePageObject;
	SearchPage SearchPageObject;
	ProductSelectionPage ProductSelectionPageObject;
	
	String ProductName = "Apple MacBook Pro 13-inch";
	
	@Test(priority=0)
	public void TestChangeCurrecny() throws InterruptedException
	{
		HomePageObject = new HomePage(driver);
		HomePageObject.ChangeCurrency();
		Thread.sleep(3000);
		HomePageObject = new HomePage(driver);
		HomePageObject.UserCanSearch(ProductName);
		Thread.sleep(3000);
		SearchPageObject = new SearchPage(driver);
		SearchPageObject.OpenProductLink();
		Thread.sleep(3000);
		ProductSelectionPageObject = new ProductSelectionPage(driver);
		Assert.assertTrue(ProductSelectionPageObject.ProductPriceTag.getText().contains("Ђ"));
		Thread.sleep(2000);
		
	}
	
/*	@Test(priority=2)
	public void TestCurrecnyChangeInProductList() throws InterruptedException
	{
		HomePageObject = new HomePage(driver);
		HomePageObject.UserCanSearch(ProductName);
		Thread.sleep(3000);
		SearchPageObject = new SearchPage(driver);
		SearchPageObject.OpenProductLink();
		Thread.sleep(3000);
		ProductSelectionPageObject = new ProductSelectionPage(driver);
		Assert.assertTrue(ProductSelectionPageObject.ProductPriceTag.getText().contains("Ђ"));
		Thread.sleep(2000);
		
		
	}*/

}
