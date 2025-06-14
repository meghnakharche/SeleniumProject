package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reportclass {
	  private static ExtentReports extent;

	    public static ExtentReports getReportInstance() {
	        if (extent == null) {
	            ExtentSparkReporter reporter = new ExtentSparkReporter("reports/index.html");
	            reporter.config().setReportName("Web Automation Test Report");
	            reporter.config().setDocumentTitle("Test Results");
	            extent = new ExtentReports();
	            extent.attachReporter(reporter);
	        }
	        return extent;
	    }

}
