package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.SecurePage;

public class PositiveLoginTests extends BaseTest
{
	
	@Test
	public void loginTest()
	{
		LoginPage loginpage = new LoginPage(driver);
		loginpage.open();
		SecurePage securepage = loginpage.LoginWith("tomsmith", "SuperSecretPassword!");
		securepage.waitForSecurePageToLoad();
		String message = securepage.getMessageText();
		Assert.assertTrue(message.contains("You logged into a secure area!"),"message does not contain expected text");
		
		
	}

}
