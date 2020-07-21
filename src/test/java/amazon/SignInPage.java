package amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;

public class SignInPage extends BasePage
{
	
	private String url = "https://www.amazon.in/";
	
	@FindBy(how = How.ID, using = "nav-link-accountList")
	private WebElement singInLink;
	
	public SignInPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void open()
	{
		openUrl(url);
	}
	
	public LoginPage goToLoginPage()
	{
		singInLink.click();
		return new LoginPage(driver);
	}

}
