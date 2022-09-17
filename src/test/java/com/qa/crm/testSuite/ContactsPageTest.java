package com.qa.crm.testSuite;

import com.qa.crm.Utility.TestUtils;
import com.qa.crm.base.TestBase;
import com.qa.crm.pages.ContactsPage;
import com.qa.crm.pages.HomePage;
import com.qa.crm.pages.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ContactsPageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    ContactsPage contactsPage;

    public ContactsPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        configInitialization();
        homePage=new LoginPage().login(properties.getProperty("user"),properties.getProperty("password"));
       contactsPage=homePage.clickOnContacts();
    }

    @Test(enabled = false)
    public void selectCheckboxByContactName(){
        contactsPage.selectCheckBoxByAdjValue("Lisa Carpenter");
    }

    @DataProvider(name ="getData" )
    public Object[][] getData(){
        return TestUtils.getExcelData("Contacts");
    }
    @Test(dataProvider = "getData")
    public void addNewContact(String title,String fn,String ln, String company){
       homePage.clickOnNewContacts();
        contactsPage.addNewContact(title,fn,ln,company);
        homePage.clickOnContacts();
        contactsPage.selectCheckBoxByAdjValue(fn+" "+ln);
    }

    @DataProvider
    public Object[][] getName()
    {
        Object[][] data={{"ram",3},{"tom",6}};
        return data;
    }

    @Test(dataProvider = "getData",enabled = false)
    public void printname(String title,String fn,String ln,String c)
    {
        System.out.println(title+":"+fn+":"+ln+":"+c);
    }
    @AfterMethod
    public void tearDown(){
        webDriver.close();
    }
}
