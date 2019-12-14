package StepDefinitions;

import PageObjects.CreateComputerPage;
import PageObjects.EditComputerPage;
import Utility.BrowserUtility;
import Utility.PropertiesFileReader;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.List;
import java.util.Properties;



public class CreateComputerSteps {

    private WebDriver driver;
    PropertiesFileReader obj=new PropertiesFileReader();

    @Given("^user is navigated to computer application$")
    public void user_is_navigated_to_computer_application() throws Throwable {
            Properties properties=obj.getProperty();
            driver=BrowserUtility.openBrowser(driver,properties.getProperty("browser.driverVersion"),properties.getProperty("browser.browserName"),properties.getProperty("browser.baseURL"));
    }

    @When("^user adds computer with data$")
    public void user_adds_computer_with_data(DataTable arg1) throws Throwable {
        List<String> list = arg1.asList(String.class);
            EditComputerPage editComputerPage = new EditComputerPage(driver);
            CreateComputerPage createComputerPage = new CreateComputerPage(driver);
            createComputerPage.clickOnAddComputer();
            editComputerPage.fillComputerData(list.get(0), list.get(1), list.get(2));
    }

    @When("^verify the computer in the Filter list \"([^\"]*)\"$")
    public void verify_the_computer_in_the_Filter_list(String computerName) throws Throwable {
            CreateComputerPage createComputerPage= new CreateComputerPage(driver);
            createComputerPage.searchComputer(computerName);
    }

    @Then("^added computer should be available in the list \"([^\"]*)\"$")
    public void added_computer_should_be_available_in_the_list(String date) throws Throwable {

            CreateComputerPage createComputerPage= new CreateComputerPage(driver);
            String editedDate=createComputerPage.verifyIntroducedDate();
            Assert.assertEquals(editedDate,date);
    }
}
