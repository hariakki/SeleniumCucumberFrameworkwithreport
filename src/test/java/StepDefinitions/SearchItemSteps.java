package StepDefinitions;

import Utility.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class SearchItemSteps extends BaseUtils {

    private WebDriver driver;
    ConfigFactory obj=new ConfigFactory();

    WebdriverFactory webdriverFactory;
    PageObjectFactory pageObjectFactory;
    TestState testState;

    public SearchItemSteps(TestState state) {
        testState = state;
        webdriverFactory = testState.getWebdriverFactory();
        pageObjectFactory = testState.getPageObjectFactory();
    }

    @And("user selects item number {string} from the result list")
    public void userSelectsItemNumberFromTheResultList(String itemNo) {
        String selectedItem=pageObjectFactory.getSearchItemPage().selectItemFromResultList(Integer.parseInt(itemNo));
        testState.selectedItem=selectedItem;
    }

    @And("selects quantity {string}")
    public void selectsQuantity(String quantity) throws Exception {
        selectFromDropdown(webdriverFactory.getDriver(),pageObjectFactory.getSearchItemPage().quantityDropdown,quantity);
    }

    @And("add the product to basket")
    public void addTheProductToBasket() throws Exception {
        Click(webdriverFactory.getDriver(),pageObjectFactory.getSearchItemPage().addToBasketBtn);
    }

    @Then("mini shopping cart should be displayed")
    public void miniShoppingCartShouldBeDisplayed() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertEquals(pageObjectFactory.getSearchItemPage().shoppingBasketMiniCart.isDisplayed(),true);
    }

    @When("user clicks on view basket in mini cart")
    public void userClicksOnViewBasketInMiniCart() throws Exception {
        Click(webdriverFactory.getDriver(),pageObjectFactory.getSearchItemPage().viewBasketBtn);
    }

    @And("the selected item should be present in shopping basket")
    public void theSelectedItemShouldBePresentInShoppingBasket() {
        String name=pageObjectFactory.getSearchItemPage().itemNameInShoppingCart.getText();
        Assert.assertEquals(name,testState.selectedItem);
    }
}
