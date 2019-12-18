package PageObjects;

import Utility.BaseUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchItemPage extends BaseUtils {

    WebDriver driver;

    public SearchItemPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(how = How.XPATH,using = "//div[@class='product-info']//a[@class='js-product-link']")
    public List<WebElement> itemSearchResults;

    @FindBy(how = How.NAME,using = "Quantity")
    public WebElement quantityDropdown;

    @FindBy(how=How.ID,using = "add-to-cart")
    public WebElement addToBasketBtn;

    @FindBy(how=How.CLASS_NAME,using = "minicart opened")
    public WebElement miniCartWindow;

    @FindBy(how=How.XPATH,using = "//span[text()='shopping basket']")
    public WebElement shoppingBasketMiniCart;

    @FindBy(how = How.LINK_TEXT,using = "view basket")
    public WebElement viewBasketBtn;

    @FindBy(how = How.XPATH,using = "//a[contains(@title, 'Go to product')]")
    public WebElement itemNameInShoppingCart;


    public String selectItemFromResultList(int i){
        String item=itemSearchResults.get(i).getText();
        Click(driver,itemSearchResults.get(i));
        return item;
    }


}
