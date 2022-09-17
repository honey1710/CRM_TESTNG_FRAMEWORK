package com.qa.crm.Utility;

import com.qa.crm.base.TestBase;
import org.openqa.selenium.WebElement;

public class ObjectsActions extends TestBase {
    WebdDriverWaitMethod w;
    public ObjectsActions(WebElement webElement){
        w=new WebdDriverWaitMethod(webElement);
    }

    public boolean webElementIsDisplayed(WebElement webElement){
        return webElement.isDisplayed();
    }

    public void switchToFrame(){
        webDriver.switchTo().frame("mainpanel");
    }
}
