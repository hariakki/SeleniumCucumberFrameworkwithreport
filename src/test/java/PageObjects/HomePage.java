package PageObjects;

import Utility.BaseUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends BaseUtils {

    WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(how = How.XPATH, using = "//button[text()='OK and close'][1]")
    public WebElement acceptCookie;

    @FindBy(how = How.LINK_TEXT, using = "sign in")
    public WebElement signInLink;

    @FindBy(how = How.XPATH, using = "//a[text()='sign out']")
    public WebElement signOutButton;

    @FindBy(how = How.XPATH, using = "//span[text()='my HEMA']")
    public WebElement myHEMAButton;

    @FindBy(how = How.ID, using = "q")
    public WebElement searchBox;

    @FindBy(how = How.CLASS_NAME, using = "search-btn")
    public WebElement searchBtn;


    public void searchItem(String itemName){
        sendKeys(driver,searchBox,itemName);
        Click(driver,searchBtn);
    }



}
