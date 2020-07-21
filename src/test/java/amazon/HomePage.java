package amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;

public class HomePage extends BasePage 
{
	@FindBy(how = How.XPATH, using = "//div[@class = 'nav-line-1-container']")
	private WebElement accountList;

	@FindBy(how = How.ID, using = "nav-item-signout")
	private WebElement signoutButton;
	
	public HomePage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public LoginPage signOut()
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(accountList).build().perform();
		signoutButton.click();
		return new LoginPage(driver);
		
	}
}
