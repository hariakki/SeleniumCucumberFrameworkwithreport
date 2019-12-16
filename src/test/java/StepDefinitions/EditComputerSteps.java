package StepDefinitions;

import PageObjects.CreateComputerPage;
import PageObjects.EditComputerPage;
import Utility.ConfigFactory;
import Utility.PageObjectFactory;
import Utility.TestState;
import Utility.WebdriverFactory;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class EditComputerSteps{

    private WebDriver driver;
    ConfigFactory obj=new ConfigFactory();

    WebdriverFactory webdriverFactory;
    PageObjectFactory pageObjectFactory;
   // Scenario scenario;
    TestState testState;

    public EditComputerSteps(TestState state) {
        testState = state;
        webdriverFactory = testState.getWebdriverFactory();
        pageObjectFactory = testState.getPageObjectFactory();
    }

    @When("^user Edit introduced date as \"([^\"]*)\" of computer \"([^\"]*)\"$")
    public void user_Edit_introduced_date_as_of_computer(String introducedDate, String computerName) throws Exception {
//        CreateComputerPage createComputerPage = new CreateComputerPage(webdriverFactory.getDriver());
//        EditComputerPage editComputerPage = new EditComputerPage(webdriverFactory.getDriver());
//
//        createComputerPage.startEditingComputer(computerName);
//        editComputerPage.editIntroducedDateInComputer(computerName,introducedDate);
        pageObjectFactory.getCreateComputerPage().startEditingComputer(computerName);
//        editComputerPage.editIntroducedDateInComputer(computerName,introducedDate);
        pageObjectFactory.getEditComputerPage().editIntroducedDateInComputer(computerName,introducedDate);
    }

    @Then("^verify the introduced date has been changed to \"([^\"]*)\" of computer \"([^\"]*)\"$")
    public void verify_the_introduced_date_has_been_changed_to_of_computer(String introducedDate, String computerName) throws Exception {
//        CreateComputerPage createComputerPage = new CreateComputerPage(webdriverFactory.getDriver());
//
//        createComputerPage.searchComputer(computerName);
//        String editeddate=createComputerPage.verifyIntroducedDate();
        pageObjectFactory.getCreateComputerPage().searchComputer(computerName);
        String editeddate=pageObjectFactory.getCreateComputerPage().verifyIntroducedDate();
        Assert.assertEquals(editeddate,introducedDate);
    }
}
