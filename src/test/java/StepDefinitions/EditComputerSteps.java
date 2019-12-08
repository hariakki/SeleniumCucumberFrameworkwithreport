package StepDefinitions;

import PageObjects.CreateComputerPage;
import PageObjects.EditComputerPage;
import Utility.BrowserUtility;
import Utility.PropertiesFileReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.Properties;

public class EditComputerSteps {

    private static WebDriver driver;
    PropertiesFileReader obj=new PropertiesFileReader();

    @Given("user is navigated to computer application for edit a computer")
    public void userIsNavigatedToComputerApplicationForEditAComputer() throws Exception {
        Properties properties=obj.getProperty();
        driver= BrowserUtility.opeBrowser(driver,properties.getProperty("browser.driverVersion"),properties.getProperty("browser.browserName"),properties.getProperty("browser.baseURL"));
    }

    @When("^user Edit introduced date as \"([^\"]*)\" of computer \"([^\"]*)\"$")
    public void user_Edit_introduced_date_as_of_computer(String introducedDate, String computerName) throws Exception {
        CreateComputerPage createComputerPage = new CreateComputerPage(driver);
        EditComputerPage editComputerPage = new EditComputerPage(driver);

        createComputerPage.startEditingComputer(computerName);
        editComputerPage.editIntroducedDateInComputer(computerName,introducedDate);
    }

    @Then("^verify the introduced date has been changed to \"([^\"]*)\" of computer \"([^\"]*)\"$")
    public void verify_the_introduced_date_has_been_changed_to_of_computer(String introducedDate, String computerName) throws Exception {
        CreateComputerPage createComputerPage = new CreateComputerPage(driver);

        createComputerPage.searchComputer(computerName);
        String editeddate=createComputerPage.verifyIntroducedDate();
        Assert.assertEquals(editeddate,introducedDate);
    }
}
