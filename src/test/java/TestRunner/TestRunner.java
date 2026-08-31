package TestRunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepdefinations", "hooks"},
        plugin = {
                "pretty",
                "json:target/cucumber-json-report.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "rerun:target/rerun.txt"
        }
)

public class TestRunner extends AbstractTestNGCucumberTests {

    @AfterClass(alwaysRun = true)
    public void rerunFailedScenarios() {
        RerunExecutor.rerunFailedScenariosIfAny();
    }
}
