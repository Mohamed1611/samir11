package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase
{

	public LoginPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(id="Email")
	WebElement EmailTxtBox;

	@FindBy(id="Password")
	WebElement PasswordTxtBox;

	@FindBy(css="input.button-1.login-button")
	WebElement LoginBtn;

	public void UserLogin(String Email , String Password)
	{
		FillTextBox(EmailTxtBox, Email);
		FillTextBox(PasswordTxtBox, Password);
		ClickButton(LoginBtn);
	}



}
