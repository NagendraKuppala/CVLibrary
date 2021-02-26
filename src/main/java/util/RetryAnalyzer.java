package main.java.util;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    int count = 0;
    int retryCount = 1;

    /** Retry Failed Testcase for (retryCount) times */
    @Override
    public boolean retry(ITestResult result) {
        while(count<retryCount) {
            count++;
            return true;
        }
        return false;
    }
}
