package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.SecurePage;

public class LogoutTest extends BaseTest
{

	SecurePage objSecurePage;
	
	@Test
	public void logOutTest()
	{
		objSecurePage = new SecurePage(driver);
		Assert.assertTrue(objSecurePage.isLoggedIn());
		objSecurePage.DoLogout();
	}
}
