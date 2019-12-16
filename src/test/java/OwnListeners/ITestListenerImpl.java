package OwnListeners;

import Utility.PageObjectFactory;
import Utility.TestState;
import Utility.WebdriverFactory;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;

import java.io.IOException;

public class ITestListenerImpl implements ITestListener {

    WebdriverFactory webdriverFactory;
    //PageObjectFactory pageObjectFactory;
    // Scenario scenario;
    TestState testState;

    public ITestListenerImpl(){

    }

    public ITestListenerImpl(TestState state){
        testState = state;
        webdriverFactory = testState.getWebdriverFactory();
    }

    public void onTestStart(ITestResult result) {

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
    }

    public void onFinish(ITestContext context) {
        System.out.println("Execution ends on UAT Env.........");
    }

    @Before
    public void beforeScenario(Scenario scenario){

    }

    @After
    public void afterScenario(Scenario scenario) throws IOException {
        String ScreenShotFileName = "./ScreenShot/" + scenario.getName().replaceAll(" ","") + ".jpeg";
        if(scenario.isFailed()){

        }
    }

}
