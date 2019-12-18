package StepDefinitions;

import Utility.*;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.List;

public class SignInSteps extends BaseUtils {

    private WebDriver driver;
    ConfigFactory obj=new ConfigFactory();

    WebdriverFactory webdriverFactory;
    PageObjectFactory pageObjectFactory;
    TestState testState;

    public SignInSteps(TestState state) {
        testState = state;
        webdriverFactory = testState.getWebdriverFactory();
        pageObjectFactory = testState.getPageObjectFactory();
    }

    @When("user login with below credentials:")
    public void userLoginWithBelowCredentials(DataTable arg1) throws InterruptedException {
        List<String> list = arg1.asList(String.class);
        pageObjectFactory.getSignInPage().loginWithExistingUser(list.get(0),list.get(1));
    }

    @Then("logged in screen should be displayed")
    public void loggedInScreenShouldBeDisplayed() {
        Assert.assertEquals(pageObjectFactory.getHomePage().myHEMAButton.isDisplayed(),true);
    }

    @When("user clicks on Sign-out under myHema dropdown")
    public void userClicksOnSignOutUnderMyHemaDropdown() throws Exception {
        moveToElement(webdriverFactory.getDriver(),pageObjectFactory.getHomePage().myHEMAButton,pageObjectFactory.getHomePage().signOutButton);
    }

    @Then("logged out homepage should be displayed")
    public void loggedOutHomepageShouldBeDisplayed() {
        Assert.assertEquals(pageObjectFactory.getHomePage().signInLink.isDisplayed(),true);
    }

    @Then("error message {string} should be displayed")
    public void errorMessageShouldBeDisplayed(String errorMsg) {
        String error= pageObjectFactory.getSignInPage().loginError.getText();
        Assert.assertEquals(error,errorMsg,"login error is not proper");
    }
}
