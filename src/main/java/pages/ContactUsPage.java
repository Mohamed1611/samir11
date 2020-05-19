package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageBase
{

	public ContactUsPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(id="FullName")
	WebElement YourNameTxtField;

	@FindBy(id="Email")
	WebElement YourEmailTxtField;

	@FindBy(id="Enquiry")
	WebElement EnquiryTxtField;

	@FindBy(css="input.button-1.contact-us-button")
	WebElement SubmitBtn;

	public void UserCanUseContactUs(String YourName, String YourEmail, String Enquire)
	{
		FillTextBox(YourNameTxtField, YourName);
		FillTextBox(YourEmailTxtField, YourEmail);
		FillTextBox(EnquiryTxtField, Enquire);
		ClickButton(SubmitBtn);
	}

	@FindBy(css="div.result")
	public WebElement ContactUsResult;

}
