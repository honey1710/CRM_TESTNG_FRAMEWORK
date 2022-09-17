package com.qa.crm.testSuite;

import com.qa.crm.base.TestBase;
import com.qa.crm.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTest extends TestBase {

    public LoginTest(){
        super();
    }

    @BeforeMethod
    public void setUp()
    {
        configInitialization();

    }

    @Test(priority = 2)
    public void loginPageTitle()
    {
        String title=new LoginPage().getTitle();
        Assert.assertEquals(title,"Free CRM - CRM software for customer relationship management, sales, and support.");
    }

    @Test(priority = 1)
    public void ValidateLogoDisplyed(){
        Assert.assertTrue(new LoginPage().isLogoDisplayed());
    }
    @Test(priority = 1)
    public void login()
    {
        new LoginPage().login(properties.getProperty("user"),properties.getProperty("password"));
    }

    @AfterMethod
    public void tearDown()
    {
        webDriver.close();
    }
}
