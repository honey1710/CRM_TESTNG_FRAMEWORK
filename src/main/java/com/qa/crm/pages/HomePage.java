package com.qa.crm.pages;

import com.qa.crm.Utility.GlobalVariables;
import com.qa.crm.Utility.ObjectsActions;
import com.qa.crm.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import java.time.Duration;
import java.util.List;
import java.util.Optional;

public class HomePage extends TestBase {

    @FindBy(xpath = "//frame[@name='mainpanel']//td[contains(text(),'User: Honey Homes')]")
    WebElement user;

   @FindBy(xpath = "//a[@title='Contacts']")
    WebElement contacts;

   @FindBy(xpath = "//a[@title='New Contact']")
   WebElement newContact;


   public HomePage(){
       PageFactory.initElements(webDriver,this);
   }



   public String getHomePageTitle()
   {
        return webDriver.getTitle();
   }

   public ContactsPage clickOnContacts(){

       GlobalVariables.switchToFrame();
       contacts.click();
           return new ContactsPage();

   }

   public boolean isCOntactDisplayed()
   {
       return contacts.isDisplayed();
   }

    public void clickOnNewContacts(){
        Actions a=new Actions(webDriver);
        a.moveToElement(contacts).pause(Duration.ofSeconds(2)).build().perform();
        System.out.println(newContact.isDisplayed());
        newContact.click();
    }



}
