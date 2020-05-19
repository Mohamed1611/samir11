package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutPage extends PageBase
{

	public CheckOutPage(WebDriver driver) {
		super(driver);

	}

	
	@FindBy(id="BillingNewAddress_CountryId")
	WebElement CountryList;

	@FindBy(id="BillingNewAddress_City")
	WebElement CityTxtField;

	@FindBy(id="BillingNewAddress_Address1")
	WebElement Address1TxtField;

	@FindBy(id="BillingNewAddress_ZipPostalCode")
	WebElement ZipTxtField;

	@FindBy(id="BillingNewAddress_PhoneNumber")
	WebElement PhoneNumberTxtField;

	@FindBy(css="input.button-1.new-address-next-step-button")
	WebElement ContinueBtnOfBillingAddress;

	@FindBy(css="input.button-1.shipping-method-next-step-button")
	WebElement ContinueBtnOfShippingMehod;

	@FindBy(css="input.button-1.payment-method-next-step-button")
	WebElement ContinueBtnOfPaymentMethod;

	@FindBy(css="input.button-1.payment-info-next-step-button")
	WebElement ContinueBtnOfPaymentInformation;

	@FindBy(css="input.button-1.confirm-order-next-step-button")
	WebElement ConfirmationBtnOfConfirmationOrder;

	@FindBy(css="strong")
	public WebElement CheckOutOrderSuccessfullMessage;

	@FindBy(linkText="Click here for order details.")
	WebElement OrderDetailsLink;
	
	@FindBy(css="input.button-1.checkout-as-guest-button")
	WebElement CheckOutAsAGuestLink;
	
	@FindBy(id="BillingNewAddress_FirstName")
	WebElement FirstNameTxtField;
	
	@FindBy(id="BillingNewAddress_LastName")
	WebElement LastNameTxtField;
	
	@FindBy(id="BillingNewAddress_Email")
	WebElement EmailTxtField;
	
	

	public void CheckOutOrderBillingAddress(String City , String Address1, String Zip, String PhoneNumber)
	{
		Select = new org.openqa.selenium.support.ui.Select(CountryList);
		Select.selectByVisibleText("Egypt");
		FillTextBox(CityTxtField, City);
		FillTextBox(Address1TxtField, Address1);
		FillTextBox(ZipTxtField, Zip);
		FillTextBox(PhoneNumberTxtField, PhoneNumber);
		ClickButton(ContinueBtnOfBillingAddress);	
	}
	public void CheckOutOrderShippmentMethod()
	{
		ClickButton(ContinueBtnOfShippingMehod);
	}

	public void CheckOutOrderPaymentMethod()
	{
		ClickButton(ContinueBtnOfPaymentMethod);
	}
	public void CheckOutpaymentInformation()
	{
		ClickButton(ContinueBtnOfPaymentInformation);
	}
	public void CheckOutConfirmationOrder()
	{
		ClickButton(ConfirmationBtnOfConfirmationOrder);
	}
	public void OpenOrderDetails()
	{
		ClickButton(OrderDetailsLink);
	}

	public void OpenCheckOutAsGuest()
	{
		ClickButton(CheckOutAsAGuestLink);
	}

   public void GuestCanCheckOutProduct(String FirstName, String LastName, String Email,
		   String City , String Address1, String Zip , String PhoneNumber)
   {
	   FillTextBox(FirstNameTxtField, FirstName);
	   FillTextBox(LastNameTxtField, LastName);
	   FillTextBox(EmailTxtField, Email);
	   Select = new org.openqa.selenium.support.ui.Select(CountryList);
	   Select.selectByVisibleText("Egypt");
	   FillTextBox(CityTxtField, City);
	   FillTextBox(Address1TxtField, Address1);
	   FillTextBox(ZipTxtField, Zip);
	   FillTextBox(PhoneNumberTxtField, PhoneNumber);
	   ClickButton(ContinueBtnOfBillingAddress);
   }
}
