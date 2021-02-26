package test.java;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import main.java.util.Constant;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public static WebDriver driver;
    public ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest logger;


    @BeforeTest
    public void beforeTestMethod() {
        /** Extent Reports Initialize*/
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-YYYY HH-mm-ss");
        htmlReporter = new ExtentHtmlReporter(new File(System.getProperty("user.dir") + "/src/test/resources/Reports/TestReport " + dateFormat.format(date) + ".html"));
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setDocumentTitle("Automation Report");
        htmlReporter.config().setReportName("Automation Test Results");
        htmlReporter.config().setTheme(Theme.DARK);
        extent.setSystemInfo("Run By", System.getProperty("user.name"));
        extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("Java Version", System.getProperty("java.version"));
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    /** Browser parameterization using testng.xml
     *  Browser setup */
    @BeforeMethod
    @Parameters(value = {"browserName"})
    public void beforeMethodMethod(String browserName, Method testMethod) {
        logger = extent.createTest(testMethod.getName());
        setupDriver(browserName);
        driver.manage().window().maximize();
        driver.get(Constant.url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    /** TestNG listener, Extent report logger, WebDriver quit */
    @AfterMethod
    public void afterMethodMethod(ITestResult result) {

        if (result.getStatus() == ITestResult.SUCCESS) {
            String methodName = result.getMethod().getMethodName();
            String logText = "Test case: " + methodName + " Passed";
            Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
            logger.log(Status.PASS, m);
        } else if (result.getStatus() == ITestResult.FAILURE) {
            String methodName = result.getMethod().getMethodName();
            String logText = "Test case: " + methodName + " Failed";
            Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
            logger.log(Status.FAIL, m);
        } else if (result.getStatus() == ITestResult.SKIP) {
            String methodName = result.getMethod().getMethodName();
            String logText = "Test case: " + methodName + " Skipped";
            Markup m = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
            logger.log(Status.SKIP, m);
        }

        driver.quit();
    }

    /** Extent report flush */
    @AfterTest
    public void afterTestMethod() {
        extent.flush();
    }

    /** Initialize Browser using  browser drivers */
    public void setupDriver(String browserName) {

        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "driver" + File.separator + "chromedriver.exe");
            driver = new ChromeDriver();

        } else if (browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + File.separator + "driver" +File.separator + "geckodriver.exe");
            driver = new FirefoxDriver();

        } else {
            //Default browser
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "driver" +File.separator + "chromedriver.exe");
            driver = new ChromeDriver();

        }

    }
}
