package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends PageBase
{

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(name="removefromcart")
	WebElement RemoveFromCartCheckBox;
	
	@FindBy(className="qty-input")
	WebElement QantityTxtField;
	
	@FindBy(css="input.button-2.update-cart-button")
	WebElement UpdateShoppingCartBtn;
	
	@FindBy(css="span.product-subtotal")
	public WebElement TotalAmount;
	
	@FindBy(css="div.no-data")
	public WebElement RemoveShoppingCartMessage;
	
	@FindBy(id="termsofservice")
	WebElement TermsAndConditionCheckBox;
	
	@FindBy(id="checkout")
	WebElement CheckOutbtn;
	
    public void UserCanDeleteProductInShoppingCart()
    {
    	ClickButton(RemoveFromCartCheckBox);
    	ClickButton(UpdateShoppingCartBtn);
    	
    }
    
    public void UserCanAddQuantityOfProductInShoppingCart(String QuantityProductNumber)
    {
    	ClearFiled(QantityTxtField);
    	FillTextBox(QantityTxtField, QuantityProductNumber);
    	ClickButton(UpdateShoppingCartBtn);

    }
    
    public void UserCanCheckOutProducts()
    {
    	ClickButton(TermsAndConditionCheckBox);
    	ClickButton(CheckOutbtn);
    }
}
