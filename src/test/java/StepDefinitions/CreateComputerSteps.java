package StepDefinitions;

import PageObjects.CreateComputerPage;
import PageObjects.EditComputerPage;
import Utility.ConfigFactory;
import Utility.PageObjectFactory;
import Utility.TestState;
import Utility.WebdriverFactory;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.List;


public class CreateComputerSteps{

    private WebDriver driver;
    ConfigFactory obj=new ConfigFactory();

    WebdriverFactory webdriverFactory;
    PageObjectFactory pageObjectFactory;
   // Scenario scenario;
    TestState testState;

    public CreateComputerSteps(TestState state) {
        testState = state;
        webdriverFactory = testState.getWebdriverFactory();
        pageObjectFactory = testState.getPageObjectFactory();
    }

    @When("^user adds computer with data$")
    public void user_adds_computer_with_data(DataTable arg1) throws Throwable {
        List<String> list = arg1.asList(String.class);
//            EditComputerPage editComputerPage = new EditComputerPage(webdriverFactory.getDriver());
//            CreateComputerPage createComputerPage = new CreateComputerPage(webdriverFactory.getDriver());
   //         pageObjectFactory.getCreateComputerPage.clickOnAddComputer();
            pageObjectFactory.getCreateComputerPage().clickOnAddComputer();
            pageObjectFactory.getEditComputerPage().fillComputerData(list.get(0), list.get(1), list.get(2));

    }

    @When("^verify the computer in the Filter list \"([^\"]*)\"$")
    public void verify_the_computer_in_the_Filter_list(String computerName) throws Throwable {
//            CreateComputerPage createComputerPage= new CreateComputerPage(webdriverFactory.getDriver());
//            createComputerPage.searchComputer(computerName);
        pageObjectFactory.getCreateComputerPage().searchComputer(computerName);
    }

    @Then("^added computer should be available in the list \"([^\"]*)\"$")
    public void added_computer_should_be_available_in_the_list(String date) throws Throwable {

           // CreateComputerPage createComputerPage= new CreateComputerPage(webdriverFactory.getDriver());
           // String editedDate=createComputerPage.verifyIntroducedDate();
            String editedDate=pageObjectFactory.getCreateComputerPage().verifyIntroducedDate();
            Assert.assertEquals(editedDate,date);
    }
}
