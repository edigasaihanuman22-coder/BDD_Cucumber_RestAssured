package reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ExtentTestManager {

    public static ExtentTest test;

    public static void createTest(String scenarioName) {

        ExtentReports extent = ExtentManager.getInstance();

        test = extent.createTest(scenarioName);
    }

    public static ExtentTest getTest() {
        return test;
    }
}