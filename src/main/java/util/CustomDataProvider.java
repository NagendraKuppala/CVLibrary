package main.java.util;

import org.testng.annotations.DataProvider;

public class CustomDataProvider {
    /** Three sets of data for testing "findJobsTest" testcase */
    @DataProvider(name = "findJobsData")
    public Object[][] testData(){
        Object[][] data = {{"Selenium","London","50"},{"Java","UK","100"},{"Automation","Britain","100"}};
        return data;
    }

}
