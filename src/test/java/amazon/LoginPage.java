package amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;

public class LoginPage extends BasePage
{
	@FindBy(how = How.ID, using = "nav-link-accountList")
	private WebElement signInLink;
	
	@FindBy(how = How.ID, using = "ap_email")
	private WebElement username;
	
	@FindBy(how = How.ID, using = "continue")
	private WebElement continueButton;
	
	@FindBy(how = How.ID, using = "ap_password")
	private WebElement password;
	
	@FindBy(how = How.ID, using = "signInSubmit")
	private WebElement signInButton;
	
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void enterUsername(String uname)
	{
		username.sendKeys(uname);
	}
	
	public void clickOnContinue()
	{
		continueButton.click();
	}
	
	public void enterPassword(String pwd)
	{
		password.sendKeys(pwd);
	}
	
	public void clickOnSignInButton()
	{
		signInButton.click();
	}
	
	public HomePage loginWith(String uname, String pwd)
	{
		enterUsername(uname);
		clickOnContinue();
		enterPassword(pwd);
		clickOnSignInButton();
		
		return new HomePage(driver);
		
		
	}

}
