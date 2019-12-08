package OwnListeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.gherkin.model.Feature;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class ITestListenerImpl extends ExtentReportListener implements ITestListener {

    private static ExtentReports extent;
    private static CustomExtentReporter customExtentReporter;
    private static boolean isReporterRunning;

    public void onTestStart(ITestResult result) {
        //testStartSetup();
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("PASS");
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("FAIL");
    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("SKIP");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }


    public void onStart(ITestContext context) {
        System.out.println("Execution starts on UAT Env.........");
        //extent=setUp();
    }

    public void onFinish(ITestContext context) {
        System.out.println("Execution ends on UAT Env.........");
       // extent.flush();
    }

    @Before
    public void beforeScenario(Scenario scenario){
        if(!isReporterRunning){
            customExtentReporter = new CustomExtentReporter("./Reports/Extent_Report.html");
            isReporterRunning=true;
        }
    }

    @After
    public void afterScenario(Scenario scenario) throws IOException {
        String ScreenShotFileName = "./ScreenShot/" + scenario.getName().replaceAll(" ","") + ".jpeg";
        if(scenario.isFailed()){

        }
        customExtentReporter.createTest(scenario,ScreenShotFileName);
        customExtentReporter.writeToReport();

    }
}
