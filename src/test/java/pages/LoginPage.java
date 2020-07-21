	package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;

public class LoginPage extends BasePage
{
	
	@FindBy(how = How.ID, using = "username")
	private WebElement usernameLocator;
	
	@FindBy(how = How.ID, using = "password")
	private WebElement passwordLocator;
	
	@FindBy(how = How.XPATH, using ="//button[@type='submit']")
	private WebElement loginButtonLocator;
	
	@FindBy(how = How.ID, using = "flash")
	private WebElement errorMessageLocator;
	By byerrorMessageLocator = By.id("flash");
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public SecurePage LoginWith(String uname, String pwd)
	{
		usernameLocator.sendKeys(uname);
		passwordLocator.sendKeys(pwd);
		loginButtonLocator.click();
		
		return new SecurePage(driver);
	}
	
	public void open()
	{
		openUrl(file.getLoginUrl());
	}
	
	public void waitForErrorMessage()
	{
		waitForVisibilityOf(byerrorMessageLocator,5);
		
	}

}
