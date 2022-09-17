package com.qa.crm.pages;

import com.qa.crm.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {
    //OR
    @FindBy(name="username")
    WebElement username;

    @FindBy(name="password")
    WebElement password;

    @FindBy(xpath="//input[@value='Login']")
    WebElement btnLogin;

    @FindBy(xpath = "//img[@class='img-responsive']")
    WebElement logo;

    //Page object Initialization
    public LoginPage(){
        PageFactory.initElements(webDriver,this);
    }

    //Actions
    public String getTitle(){
        return webDriver.getTitle();
    }

    public boolean isLogoDisplayed(){
        return logo.isDisplayed();
    }
    public HomePage login(String un,String pwd){
        username.sendKeys(un);
        password.sendKeys(pwd);
        btnLogin.click();
        return new HomePage();

    }
}
