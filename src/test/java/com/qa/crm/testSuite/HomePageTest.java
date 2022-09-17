package com.qa.crm.testSuite;

import com.qa.crm.Utility.GlobalVariables;
import com.qa.crm.base.TestBase;
import com.qa.crm.pages.ContactsPage;
import com.qa.crm.pages.HomePage;
import com.qa.crm.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    ContactsPage contactsPage;

    public HomePageTest(){
        super();
    }
    @BeforeMethod
    public void setUp(){
        configInitialization();
        loginPage=new LoginPage();
        homePage=loginPage.login(properties.getProperty("user"),properties.getProperty("password"));
        //contactsPage=homePage.clickOnContacts();
    }

    @Test
    public void verifyUserNameOnHomePageTest(){
        Assert.assertEquals(homePage.getHomePageTitle(),"CRMPRO");
    }

    @Test
    public void contactDisplayedTest(){
        GlobalVariables.switchToFrame();
        Assert.assertTrue(homePage.isCOntactDisplayed());
    }




    @AfterMethod
    public void tearDown()
    {
        webDriver.close();
    }
}
