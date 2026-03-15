
package hooks;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import reporting.ScenarioResult;
import reporting.ExtentManager;
import reporting.ExtentTestManager;
import reporting.EmailUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Hooks {

    static long startTime;
    public static List<ScenarioResult> results = new ArrayList<>();

    @Before
    public void beforeScenario() {
        startTime = System.currentTimeMillis();
        System.out.println("startTime "+startTime);
    }

    @Before
    public void beforeScenario(Scenario scenario) {

        ExtentTestManager.createTest(scenario.getName());
    }
    @After
    public void afterScenario(Scenario scenario) {

        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        String scenarioName = scenario.getName();
        String status = scenario.getStatus().toString();

        ScenarioResult result = new ScenarioResult(
                scenarioName,
                status,
                executionTime
        );

        results.add(result);

        System.out.println("Scenario: " + scenarioName +
                " | Status: " + status +
                " | Time: " + executionTime + " ms");
    }
   
    @AfterAll
    public static void afterAll() throws Exception  {

        ExtentManager.getInstance().flush();

        System.out.println("===================================");
        System.out.println("Extent Report Generated Successfully");
        System.out.println("Location: target/API_Test_Report.html");
        System.out.println("===================================");
        EmailUtil.sendEmail(Hooks.results);
    }
    
//    @AfterAll
//    public static void verifyExtentReport() {
//
//        String reportPath = "target/ExtentReport.html";
//
//        File reportFile = new File(reportPath);
//
//        if (reportFile.exists()) {
//            System.out.println("======================================");
//            System.out.println("Extent Report Generated Successfully");
//            System.out.println("Report Location: " + reportFile.getAbsolutePath());
//            System.out.println("======================================");
//        } else {
//            System.out.println("======================================");
//            System.out.println("Extent Report NOT Generated!");
//            System.out.println("Check Extent configuration");
//            System.out.println("======================================");
//        }
    }
