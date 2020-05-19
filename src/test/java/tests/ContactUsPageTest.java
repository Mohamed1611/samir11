package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ContactUsPage;
import pages.HomePage;
import pages.RegisterResultPage;

public class ContactUsPageTest extends TestBase
{

	HomePage HomePageObject;
	ContactUsPage ContactUsPageObject;
	RegisterResultPage RegisterResultPageObject;
	
	String YourName = "Mohamed";
	String YourEmail = "Bekatosshako2@Test.com";
	String Enquire = "Hoob omry la2to w sabny";
	String Result = "Your enquiry has been successfully sent to the store owner.";

	@Test(priority=0)
	public void TestUserCanUseContactUs() throws InterruptedException
	{
		HomePageObject = new HomePage(driver);
		HomePageObject.Scroll();
		Thread.sleep(2000);
		HomePageObject.OpenContactUsLink();
		Thread.sleep(3000);
		ContactUsPageObject = new ContactUsPage(driver);
		ContactUsPageObject.UserCanUseContactUs(YourName, YourEmail, Enquire);
		Thread.sleep(2000);
		System.out.println(ContactUsPageObject.ContactUsResult.getText());
		Assert.assertEquals(ContactUsPageObject.ContactUsResult.getText(),Result);
	}
	
}
