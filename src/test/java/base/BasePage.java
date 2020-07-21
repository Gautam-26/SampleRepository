package base;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ReadConfigFile;

public class BasePage 
{
	protected WebDriver driver;
	protected ReadConfigFile file = new ReadConfigFile();
	
	public BasePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	protected WebElement find(By locator) 
	{
		return driver.findElement(locator);
	}
	protected void openUrl(String url)
	{
		System.out.println("Opening Url : "+url);
		driver.get(url);
		System.out.println("Page Opened");
	}
	
	private void waitFor(ExpectedCondition<WebElement> condition, Integer timeOutInSeconds) 
	{
		timeOutInSeconds = timeOutInSeconds != null ? timeOutInSeconds : 10;
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(condition);
	}

	protected void waitForVisibilityOf(By locator, Integer... timeOutInSeconds) 
	{
		int attempts = 0;
		while (attempts < 4) {
			try {
				waitFor(ExpectedConditions.visibilityOfElementLocated(locator),
						(timeOutInSeconds.length > 0 ? timeOutInSeconds[0] : null));
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
	}

}
