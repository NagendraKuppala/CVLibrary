package test.java;

import main.java.PageEvents.HomePageEvents;
import main.java.util.CustomDataProvider;
import org.testng.annotations.Test;

public class FindJobs {

	/** Execute Testcase for Three sets of data provided using DataProvider class */
	@Test(dataProvider = "findJobsData",dataProviderClass = CustomDataProvider.class)
	public void findJobsTest(String jt, String jl, String jd) {
		HomePageEvents homePageEvents = new HomePageEvents();

		homePageEvents.findJobsInCVLibrary(jt, jl, jd);
	}

}
