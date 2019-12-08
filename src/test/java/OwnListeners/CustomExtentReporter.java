package OwnListeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.cucumber.core.api.Scenario;

import java.io.File;
import java.io.IOException;

public class CustomExtentReporter {

    private ExtentHtmlReporter extentHtmlReporter;
    private ExtentReports extentReports;

    public CustomExtentReporter(String reportLocation){
        extentHtmlReporter= new ExtentHtmlReporter(new File(reportLocation));
        extentReports= new ExtentReports();
        extentReports.attachReporter(extentHtmlReporter);
    }

    public void createTest(Scenario scenario, String screenShotFile) throws IOException {
        if(scenario !=null){
            String testName = getScenarioTitle(scenario);
            switch (scenario.getStatus()){
                case PASSED:
                    extentReports.createTest(testName).pass("Passed");
                    break;

                case FAILED:
                    extentReports.createTest(testName).fail("Failed").addScreenCaptureFromPath(getScreenShotLocation(screenShotFile));

                default:
                    extentReports.createTest(testName).skip("Skipped");
            }
        }
    }

    private String getScreenShotLocation(String screenShotFile) {
        return "file:///"+screenShotFile.replaceAll("\\\\","//");
    }

    private String getScenarioTitle(Scenario scenario){
        return scenario.getName().replaceAll(" ","");
    }

    public void writeToReport(){
        if(extentReports != null){
            extentReports.flush();
        }
    }
}
