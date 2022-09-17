package com.qa.crm.base;


import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import com.qa.crm.Utility.GlobalVariables;

import static com.qa.crm.Utility.GlobalVariables.*;

public class TestBase {
    public static WebDriver webDriver;
    public static Properties properties;

    public TestBase() {
        FileInputStream fis;
        properties=new Properties();

        try {
            fis = new FileInputStream("C:\\Users\\hchauha1\\IdeaProjects\\freeCRM_Automation_Framework\\src\\main\\java\\com\\qa\\crm\\configProperties\\config.properties");
            properties.load(fis);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void configInitialization(){
        try {
            String browser = properties.getProperty("browser");
            if (browser.equals("chrome")) {
                System.setProperty("webdriver.chrome.driver", "src/main/java/com/qa/crm/driver/chromedriver.exe");
                webDriver = new ChromeDriver();
            }
            webDriver.manage().deleteAllCookies();
            webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_TIMEOUT));
            webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WAIT));
            webDriver.manage().window().maximize();
            webDriver.get(properties.getProperty("url"));
           // webDriver.get("https://www.google.com/");

            webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WAIT));
            webDriver.navigate().refresh();
            System.out.println("Iniit");
        }
        catch(Exception exception){
            System.out.println(exception.getMessage());
        }



    }
}