package StepDefinitions;

import OwnListeners.ExtentReportListener;
import PageObjects.CreateComputerPage;
import PageObjects.EditComputerPage;
import Utility.BrowserUtility;
import Utility.PropertiesFileReader;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.gherkin.model.Scenario;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.List;
import java.util.Properties;



public class CreateComputerSteps extends ExtentReportListener {

    private static WebDriver driver;
    PropertiesFileReader obj=new PropertiesFileReader();

    @Given("^user is navigated to computer application$")
    public void user_is_navigated_to_computer_application() throws Throwable {


        ExtentTest logInfo=null;
        try{
            test = extent.createTest(Feature.class,"Test create computer Action");
            test = test.createNode(Scenario.class,"user creates a computer and verify the computer is successfully created");
            logInfo=test.createNode(new GherkinKeyword("Given"),"user is navigated to computer application");

            Properties properties=obj.getProperty();
            driver=BrowserUtility.opeBrowser(driver,properties.getProperty("browser.driverVersion"),properties.getProperty("browser.browserName"),properties.getProperty("browser.baseURL"));

            logInfo.pass("user is navigated to computer application");


        }catch(AssertionError | Exception e){
            testStepHandle("FAIL",driver,logInfo,e);
        }
    }

    @When("^user adds computer with data$")
    public void user_adds_computer_with_data(DataTable arg1) throws Throwable {
        List<String> list = arg1.asList(String.class);

        ExtentTest logInfo=null;
        try {
            logInfo = test.createNode(new GherkinKeyword("When"), "user adds computer with data");

            EditComputerPage editComputerPage = new EditComputerPage(driver);
            CreateComputerPage createComputerPage = new CreateComputerPage(driver);
            createComputerPage.clickOnAddComputer();
            editComputerPage.fillComputerData(list.get(0), list.get(1), list.get(2));

            logInfo.pass("computer is created");

        }catch(AssertionError | Exception e){
            testStepHandle("FAIL",driver,logInfo,e);
        }

    }

    @When("^verify the computer in the Filter list \"([^\"]*)\"$")
    public void verify_the_computer_in_the_Filter_list(String computerName) throws Throwable {

        ExtentTest logInfo=null;
        try {
            logInfo = test.createNode(new GherkinKeyword("When"), "verify the computer in the Filter list");

            CreateComputerPage createComputerPage= new CreateComputerPage(driver);
            createComputerPage.searchComputer(computerName);

            logInfo.pass("computer is available in Result on Filter");

        }catch(AssertionError | Exception e){
            testStepHandle("FAIL",driver,logInfo,e);
        }

    }

    @Then("^added computer should be available in the list \"([^\"]*)\"$")
    public void added_computer_should_be_available_in_the_list(String date) throws Throwable {

        ExtentTest logInfo=null;
        try {
            logInfo = test.createNode(new GherkinKeyword("Then"), "added computer should be available in the list");

            CreateComputerPage createComputerPage= new CreateComputerPage(driver);
            String editedDate=createComputerPage.verifyIntroducedDate();
            Assert.assertEquals(editedDate,date);

            logInfo.pass("created computer is available in Result");

        }catch(AssertionError | Exception e){
            testStepHandle("FAIL",driver,logInfo,e);
        }

    }
}
