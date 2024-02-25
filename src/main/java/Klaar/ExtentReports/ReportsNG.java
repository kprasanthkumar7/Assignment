package Klaar.ExtentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.BeforeTest;

public class ReportsNG {
   // public static ExtentReports extent;

    public static ExtentReports Reports() {


       String path =System.getProperty("user.dir")+"\\Reports\\htmlReport\\index.html";
       // String file = new FileInputStream("user.dir")+"\\Reports\\index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setDocumentTitle("Report Results");
        reporter.config().setReportName("Planit Test Results");
        ExtentReports  extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester","Prasanth Kumar");
        return extent;
    }
}
