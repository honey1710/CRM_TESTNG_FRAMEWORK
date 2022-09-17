package com.qa.crm.Utility;

import com.qa.crm.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebdDriverWaitMethod extends TestBase {

    public WebdDriverWaitMethod(WebElement webElement){
        WebDriverWait wait=new WebDriverWait(webDriver, Duration.ofSeconds(GlobalVariables.WAIT));
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }
}
