package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterationPage extends PageBase
{

	public RegisterationPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(id="gender-male")
	WebElement GenderMaleRadionBtn;

	@FindBy(id="gender-female")
	WebElement GenderFeMaleRadionBtn;

	@FindBy(id="FirstName")
	WebElement FirstNameTxtBox;

	@FindBy(id="LastName")
	WebElement LastNameTxtBox;

	@FindBy(id="Email")
	WebElement EmailTxtBox;

	@FindBy(id="Password")
	WebElement PasswordTxtBox;

	@FindBy(id="ConfirmPassword")
	WebElement ConfirmationPasswordTxtBox;

	@FindBy(id="register-button")
	WebElement RegisterBtn;

	public void UserRegisteration(String FirstName , String LastName, String Email, String password)
	{
		ClickButton(GenderMaleRadionBtn);
		FillTextBox(FirstNameTxtBox, FirstName);
		FillTextBox(LastNameTxtBox, LastName);
		FillTextBox(EmailTxtBox, Email);
		FillTextBox(PasswordTxtBox, password);
		FillTextBox(ConfirmationPasswordTxtBox, password);
		ClickButton(RegisterBtn);

	}
}
