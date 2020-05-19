package tests;



import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductReviewPage;
import pages.ProductReviewResultPage;
import pages.ProductSelectionPage;
import pages.RegisterResultPage;
import pages.RegisterationPage;
import pages.SearchPage;

public class AddReviewPageTest extends TestBase
{
	HomePage HomePageObject;
	RegisterationPage RegisterationPageObject;
	SearchPage SearchPageObject;
	ProductSelectionPage ProductSelectionPageObject;
	ProductReviewPage ProductReviewPageObject;
	ProductReviewResultPage ProductReviewResultPageObject;
	RegisterResultPage  RegisterResultPageObject;

	String FirstName = "Mohamed";
	String LastName = "lolo";
	String Email = "hamobs123@Test.com";
	String Password = "1234567";  
	String ProductName ="Apple MacBook Pro 13-inch";
    String ReviewTitle = "hamo";
    String ReviewText = "Beko";

	@Test(priority=0)
	public void TestUserCanAddReview() throws InterruptedException
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
		ProductSelectionPageObject.ClickOnAddYourReviewLink();
		Thread.sleep(3000);
		ProductReviewPageObject = new ProductReviewPage(driver);
		
		ProductReviewPageObject.UserCanSubmitAReview(ReviewTitle, ReviewText);
		Thread.sleep(3000);
		
		ProductReviewResultPageObject = new ProductReviewResultPage(driver);
		System.out.println(ProductReviewResultPageObject.AddReviewSuccessfullmMessage.getText());
		Assert.assertEquals(ProductReviewResultPageObject.AddReviewSuccessfullmMessage.getText(), "Product review is successfully added.");
		Thread.sleep(3000);
		RegisterResultPageObject = new RegisterResultPage(driver);
		RegisterResultPageObject.UserLogout();
		Thread.sleep(3000);
		driver.navigate().to("https://demo.nopcommerce.com/");
		Thread.sleep(2000);

	}
	
	
	
	/*@Test(priority=1)
	public void TestUserCanAddReview() throws InterruptedException
	{
		ProductSelectionPageObject = new ProductSelectionPage(driver);
		ProductSelectionPageObject.ClickOnAddYourReviewLink();
		Thread.sleep(3000);
		ProductReviewPageObject = new ProductReviewPage(driver);
		
		ProductReviewPageObject.UserCanSubmitAReview(ReviewTitle, ReviewText);
		Thread.sleep(3000);
		
		ProductReviewResultPageObject = new ProductReviewResultPage(driver);
		System.out.println(ProductReviewResultPageObject.AddReviewSuccessfullmMessage.getText());
		Assert.assertEquals(ProductReviewResultPageObject.AddReviewSuccessfullmMessage.getText(), "Product review is successfully added.");
		Thread.sleep(3000);
		RegisterResultPageObject = new RegisterResultPage(driver);
		RegisterResultPageObject.UserLogout();
		Thread.sleep(3000);
		driver.navigate().to("https://demo.nopcommerce.com/");
		Thread.sleep(2000);
	}*/



}
