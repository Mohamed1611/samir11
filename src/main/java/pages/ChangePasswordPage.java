package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChangePasswordPage extends PageBase 
{

	public ChangePasswordPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(id="OldPassword")
	WebElement OldPasswordTxtField;

	@FindBy(id="NewPassword")
	WebElement NewPasswordTxtField;

	@FindBy(id="ConfirmNewPassword")
	WebElement CondirmPasswordTxtField;

	@FindBy(css="input.button-1.change-password-button")
	WebElement ChangePasswordBtn;

	@FindBy (css="div.result")
	public WebElement ChangePasswordResult;

	public void UserChangePassword(String OldPassword , String NewPassword)
	{
		FillTextBox(OldPasswordTxtField, OldPassword);
		FillTextBox(NewPasswordTxtField, NewPassword);
		FillTextBox(CondirmPasswordTxtField, NewPassword);
		ClickButton(ChangePasswordBtn);
	}

}
