package TestRunner;

import io.cucumber.core.cli.Main;
import java.io.File;

public class RerunExecutor {
    private static boolean rerunExecuted = false;

    public static void rerunFailedScenariosIfAny() {
        if (rerunExecuted) {
            return;
        }
        rerunExecuted = true;

        File rerunFile = new File("target/rerun.txt");
        if (!rerunFile.exists() || rerunFile.length() == 0) {
            return;
        }

        System.out.println("Detected failed scenarios in target/rerun.txt. Re-running failed scenarios...");

        String[] args = new String[]{
                "--glue", "stepdefinations",
                "--glue", "hooks",
                "--plugin", "pretty",
                "--plugin", "json:target/cucumber-rerun-report.json",
                "@target/rerun.txt"
        };

        Main.main(args);
    }
}
