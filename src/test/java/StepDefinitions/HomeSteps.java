package StepDefinitions;

import Utility.*;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomeSteps extends BaseUtils {

    private WebDriver driver;
    ConfigFactory obj=new ConfigFactory();

    WebdriverFactory webdriverFactory;
    PageObjectFactory pageObjectFactory;
    TestState testState;

    public HomeSteps(TestState state) {
        testState = state;
        webdriverFactory = testState.getWebdriverFactory();
        pageObjectFactory = testState.getPageObjectFactory();
    }

    @When("user clicks on Sign-In Button")
    public void userClicksOnSignInButton() throws Exception {
        Click(webdriverFactory.getDriver(),pageObjectFactory.getHomePage().signInLink);
    }

    @When("user search for product {string} on homepage")
    public void userSearchForProductOnHomepage(String itemName) {
        pageObjectFactory.getHomePage().searchItem(itemName);
    }


}
