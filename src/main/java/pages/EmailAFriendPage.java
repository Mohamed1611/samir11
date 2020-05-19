package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailAFriendPage extends PageBase
{

	public EmailAFriendPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(id="FriendEmail")
	WebElement FriendEmailTxtField;

	//@FindBy(id="YourEmailAddress")
	//WebElement YourEmailAddressTxtField;

	@FindBy(id="PersonalMessage")
	WebElement PersonalMessageTxtField;

	@FindBy(css="input.button-1.send-email-a-friend-button")
	WebElement SendEmailBtn;

	public void SendEmail(String FriendEmail, String PersonalMessage)
	{
		FillTextBox(FriendEmailTxtField, FriendEmail);
		//FillTextBox(YourEmailAddressTxtField, YourEmailAddress);
		FillTextBox(PersonalMessageTxtField, PersonalMessage);
		ClickButton(SendEmailBtn);
	}
	
	@FindBy(css="div.result")
	public WebElement EmailAFriendResult;

}
