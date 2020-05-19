package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CheckOutPage;
import pages.HomePage;
import pages.ProductSelectionPage;
import pages.RegisterResultPage;
import pages.RegisterationPage;
import pages.SearchPage;
import pages.ShoppingCartPage;

public class CheckOutProductsTest extends TestBase
{
	HomePage HomePageObject;
	RegisterationPage RegisterationPageObject;
	SearchPage SearchPageObject;
	ProductSelectionPage ProductSelectionPageObject;
	ShoppingCartPage ShoppingCartPageObject;
	CheckOutPage CheckOutPageObject; 
	RegisterResultPage RegisterResultPageObject;

	String FirstName = "Mohamed";
	String LastName = "lolo";
	String Email = "Smishakosh1@Test.com";
	String Password = "1234567"; 
	String ProductName ="Apple MacBook Pro 13-inch";


	@Test(priority=0)
	public void TestCheckOutProducts() throws InterruptedException
	{
		HomePageObject = new  HomePage(driver);
		HomePageObject.OpenRegisterLink();
		RegisterationPageObject = new RegisterationPage(driver);
		Thread.sleep(3000);
		RegisterationPageObject.UserRegisteration(FirstName, LastName,Email,Password);
		Thread.sleep(1000);
		HomePageObject.UserCanSearch(ProductName);
		Thread.sleep(3000);
		SearchPageObject = new SearchPage(driver);
		SearchPageObject.OpenProductLink();
		Thread.sleep(3000);
		ProductSelectionPageObject = new ProductSelectionPage(driver);
		ProductSelectionPageObject.ClickOnAddToCartBtn();
		Thread.sleep(2000);
		driver.navigate().to("https://demo.nopcommerce.com/cart");
		Thread.sleep(2000);
		ShoppingCartPageObject = new ShoppingCartPage(driver);
		ShoppingCartPageObject.UserCanCheckOutProducts();
		Thread.sleep(2000);
		CheckOutPageObject = new CheckOutPage(driver);
		CheckOutPageObject.CheckOutOrderBillingAddress("Cairo", "Dubai", "82991", "0111516222");
		Thread.sleep(1000);
		CheckOutPageObject.CheckOutOrderShippmentMethod();
		Thread.sleep(1000);
		CheckOutPageObject.CheckOutOrderPaymentMethod();
		Thread.sleep(1000);
		CheckOutPageObject.CheckOutpaymentInformation();
		Thread.sleep(1000);
		CheckOutPageObject.CheckOutConfirmationOrder();
		Thread.sleep(1000);
		Assert.assertTrue(CheckOutPageObject.CheckOutOrderSuccessfullMessage.getText().contains
				("Your order has been successfully processed!"));
		Thread.sleep(3000);
		RegisterResultPageObject = new RegisterResultPage(driver);
		RegisterResultPageObject.UserLogout();
		Thread.sleep(3000);
		driver.navigate().to("https://demo.nopcommerce.com/");
		Thread.sleep(2000);
	}
	
	/*@Test(priority=1)
	public void AddToShopingCart() throws InterruptedException
	{
		ProductSelectionPageObject = new ProductSelectionPage(driver);
		ProductSelectionPageObject.ClickOnAddToCartBtn();
		Thread.sleep(2000);
		driver.navigate().to("https://demo.nopcommerce.com/cart");
		Thread.sleep(2000);
	}

	@Test(priority=2)
	public void TestCheckOut() throws InterruptedException
	{
		ShoppingCartPageObject = new ShoppingCartPage(driver);
		ShoppingCartPageObject.UserCanCheckOutProducts();
		Thread.sleep(2000);
		CheckOutPageObject = new CheckOutPage(driver);
		CheckOutPageObject.CheckOutOrderBillingAddress("Cairo", "Dubai", "82991", "0111516222");
		Thread.sleep(1000);
		CheckOutPageObject.CheckOutOrderShippmentMethod();
		Thread.sleep(1000);
		CheckOutPageObject.CheckOutOrderPaymentMethod();
		Thread.sleep(1000);
		CheckOutPageObject.CheckOutpaymentInformation();
		Thread.sleep(1000);
		CheckOutPageObject.CheckOutConfirmationOrder();
		Thread.sleep(1000);
		Assert.assertTrue(CheckOutPageObject.CheckOutOrderSuccessfullMessage.getText().contains
				("Your order has been successfully processed!"));
		Thread.sleep(3000);
		RegisterResultPageObject = new RegisterResultPage(driver);
		RegisterResultPageObject.UserLogout();
		Thread.sleep(3000);
		driver.navigate().to("https://demo.nopcommerce.com/");
		Thread.sleep(2000);
	}*/
		
}
