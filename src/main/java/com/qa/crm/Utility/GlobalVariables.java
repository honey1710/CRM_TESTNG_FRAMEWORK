package com.qa.crm.Utility;

import com.qa.crm.base.TestBase;

public class GlobalVariables extends TestBase {
    public static final long PAGE_LOAD_TIMEOUT=20;
    public static final long WAIT=5;
    public static String TEST_DATA_EXCEL_PATH=System.getProperty("user.dir")+"/src/main/java/com/qa/crm/testData/TestData.xlsx";

    public static void switchToFrame(){
        webDriver.switchTo().frame("mainpanel");
    }
}
