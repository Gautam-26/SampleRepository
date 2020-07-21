package base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class BaseTest 
{
	protected  WebDriver driver;
	

	
	@BeforeTest
	public void setUp()
	{
		BrowserFactory factory = new BrowserFactory();
		driver = factory.getDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
	}
	
	@AfterTest(alwaysRun = true)
	public void tearDown()
	{
		if(driver != null)
		{
			driver.close();
			driver.quit();
		}
		
	}

}
