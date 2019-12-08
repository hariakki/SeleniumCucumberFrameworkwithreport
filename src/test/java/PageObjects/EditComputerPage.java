package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class EditComputerPage {

    WebDriver driver;

    public EditComputerPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(how= How.ID, using="name")
    private WebElement computerNameBox;

    @FindBy(how= How.ID, using="introduced")
    private WebElement introduceDateBox;

    @FindBy(how= How.ID, using="discontinued")
    private WebElement discontinuedDateBox;

    @FindBy(how= How.ID, using="company")
    private WebElement companyDropdown;

    @FindBy(how= How.XPATH, using="//input[@type='submit']")
    private WebElement createComputerBtn;

    @FindBy(how= How.XPATH, using="//a[text()='Cancel']")
    private WebElement cancelBtn;

    @FindBy(how= How.XPATH, using="//input[@value='Delete this computer']")
    private WebElement deleteComputerBtn;

    public void fillComputerData(String computerName,String companyName,String introduceDate ){
        computerNameBox.clear();
        computerNameBox.sendKeys(computerName);
        Select select= new Select(companyDropdown);
        select.selectByVisibleText(companyName);
        introduceDateBox.clear();
        introduceDateBox.sendKeys(introduceDate);
        createComputerBtn.click();
    }

    public void editIntroducedDateInComputer(String computerName,String introducedDate) throws InterruptedException {
        Thread.sleep(2000);
        introduceDateBox.clear();
        introduceDateBox.sendKeys(introducedDate);
        createComputerBtn.click();
    }

}
