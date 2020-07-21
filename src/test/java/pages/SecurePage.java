package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;

public class SecurePage extends BasePage
{
	@FindBy(how = How.XPATH, using = "//a[@href='/logout']")
	private WebElement Logout;
	
	@FindBy(how = How.ID, using = "flash-messages")
	private WebElement message;
	By bymessage = By.id("flash-messages1");

	public SecurePage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public Boolean isLoggedIn()
	{
		return Logout.isDisplayed();
	}

	public LoginPage DoLogout()
	{
		Logout.click();
		return new LoginPage(driver);
	}
	
	public void waitForSecurePageToLoad()
	{
		waitForVisibilityOf(bymessage);
	}
	

	public String getMessageText() 
	{
		return find(bymessage).getText();
	}
}
