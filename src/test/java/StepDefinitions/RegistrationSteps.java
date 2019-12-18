package StepDefinitions;

import Utility.*;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.List;

public class RegistrationSteps extends BaseUtils {

    private WebDriver driver;
    ConfigFactory obj = new ConfigFactory();

    WebdriverFactory webdriverFactory;
    PageObjectFactory pageObjectFactory;
    TestState testState;

    public RegistrationSteps(TestState state) {
        testState = state;
        webdriverFactory = testState.getWebdriverFactory();
        pageObjectFactory = testState.getPageObjectFactory();
    }

    @When("user enters valid email address for registration and click on continue")
    public void userEntersValidEmailAddressForRegistrationAndClickOnContinue() {
        String email = "TestEmail" + randomAlphaNumeric(4) + "@asdf.com";
        testState.emailAddress = email;
        pageObjectFactory.getSignInPage().registerForNewEmail(email);
    }

    @Then("user should be navigated to registration page with title {string}")
    public void userShouldBeNavigatedToRegistrationPageWithTitle(String pageTitle) {
    }

    @When("user fill in registration form and click on Sign-up")
    public void userFillInRegistrationFormAndClickOnSignUp(DataTable arg1) throws InterruptedException {
        List<String> list = arg1.asList(String.class);
        pageObjectFactory.getRegistrationPage().fillRegistrationFormWithMandatoryDetails(list.get(0), list.get(1), list.get(2), list.get(3), list.get(4), list.get(5), list.get(6));
    }

    @Then("logged in user details screen should be displayed")
    public void loggedInUserDetailsScreenShouldBeDisplayed() {
        Assert.assertEquals(pageObjectFactory.getRegistrationPage().myDetailsLink.isDisplayed(), true);
    }

    @When("user enters {string} for registration and click on continue")
    public void userEntersForRegistrationAndClickOnContinue(String email) {
        pageObjectFactory.getSignInPage().registerForNewEmail(email);
    }

    @Then("error message {string} should be displayed for registration")
    public void errorMessageShouldBeDisplayedForRegistration(String error) {
        String errorMsg = pageObjectFactory.getSignInPage().registrationError.getText();
        Assert.assertEquals(errorMsg, error, "Error Message for invalid registration email is not proper");
    }

    @Then("error message {string} should be displayed for registration form")
    public void errorMessageShouldBeDisplayedForRegistrationForm(String error) throws Exception {
        ((JavascriptExecutor) webdriverFactory.getDriver()).executeScript("arguments[0].scrollIntoView(true);", pageObjectFactory.getRegistrationPage().registrationFormError);
        String errorMsg = pageObjectFactory.getRegistrationPage().registrationFormError.getText();
        Assert.assertEquals(errorMsg, error, "Error message for registration form is not valid");
    }
}