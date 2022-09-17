package com.qa.crm.pages;

import com.qa.crm.Utility.GlobalVariables;
import com.qa.crm.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ContactsPage extends TestBase {

    @FindBy(xpath = "table[@class='datacard']//a[@context='contact']")
    List<WebElement> contactsList;

    @FindBy(xpath = "//table[@class='datacard//input[@type='checkbox']']")
    List<WebElement> chkBoxList;


    @FindBy(name="title")
    WebElement title;

    @FindBy(name="first_name")
    WebElement firstName;

    @FindBy(name="last_name")
    WebElement lastName;

    @FindBy(name="client_lookup")
    WebElement company;

    @FindBy(xpath = "//input[@value='Save']")
    WebElement btnSave;

    String name;
    public ContactsPage(){
        PageFactory.initElements(webDriver,this);
       // GlobalVariables.switchToFrame();
    }

    public void selectCheckBoxByAdjValue(String value){
        /*
        List<WebElement> ls=contactsList;
        System.out.println(ls.size());
        for(int i=0;i<ls.size();i++){
            if(ls.get(i).getText().equals(value)){
                chkBoxList.get(i).click();
            }
        }

         */
        String xpath="//table[@class='datacard']//a[@context='contact' and @_name='"+value+"']/parent::td//preceding-sibling::td/input";
        System.out.println(xpath + ": "+webDriver.findElement(By.xpath(xpath)).isDisplayed());
        webDriver.findElement(By.xpath(xpath)).click();
    }

    public void addNewContact(String titleVal,String fn,String ln,String comp){
        Select titleDrp=new Select(title);
        titleDrp.selectByVisibleText(titleVal);
        firstName.sendKeys(fn);
        lastName.sendKeys(ln);
        company.sendKeys(comp);
        btnSave.click();
    }




}
