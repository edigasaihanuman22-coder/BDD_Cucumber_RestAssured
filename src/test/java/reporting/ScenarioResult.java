package reporting;

public class ScenarioResult {

    private String scenarioName;
    private String status;
    private long executionTime;

    public ScenarioResult(String scenarioName, String status, long executionTime) {
        this.scenarioName = scenarioName;
        this.status = status;
        this.executionTime = executionTime;
    }

    public String getScenarioName() {
        return scenarioName;
    }

    public String getStatus() {
        return status;
    }

    public long getExecutionTime() {
        return executionTime;
    }
}