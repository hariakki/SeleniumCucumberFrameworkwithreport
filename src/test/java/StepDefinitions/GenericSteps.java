package StepDefinitions;

import Utility.*;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import org.openqa.selenium.WebDriver;

public class GenericSteps {

    private WebDriver driver;
    ConfigFactory obj=new ConfigFactory();
    BaseUtils base =  new BaseUtils();

    WebdriverFactory webDriverFactory;
    PageObjectFactory pageObjectFactory;
    TestState testState;

    public GenericSteps(TestState state) {
        testState = state;
        webDriverFactory = testState.getWebdriverFactory();
        pageObjectFactory = testState.getPageObjectFactory();
    }

    @Given("^Browser is opened and user is navigated to application url$")
    public void browserISOpenedAndUserIsNavigatedToApplicationUrl() throws Exception {
        webDriverFactory.getDriver().get(obj.getApplicationUrl());
        webDriverFactory.getDriver().manage().window().maximize();
    }

    @After
    public void tearDown(Scenario scenario) throws Exception {

        if(scenario.isFailed()){
            base.captureScreenShot(webDriverFactory.getDriver(),scenario);
        }

        if(webDriverFactory.getDriver()!=null) {
            webDriverFactory.closeDriver(webDriverFactory.getDriver());
        }
    }
}
