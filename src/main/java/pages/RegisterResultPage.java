package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterResultPage extends PageBase 
{

	public RegisterResultPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(css="div.page-body")
	public WebElement RegisterationSucssfullMessage;

	@FindBy(css="a.ico-logout")
	public WebElement LogoutLink;

	@FindBy(linkText="My account")
	WebElement MyAccountLink;


	public void UserLogout()
	{
		ClickButton(LogoutLink);
	}
	public void OpenMyAccountpage()
	{
		ClickButton(MyAccountLink);
	}
}
