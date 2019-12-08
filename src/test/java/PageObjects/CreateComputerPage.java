package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CreateComputerPage {

    WebDriver driver;

    public CreateComputerPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

	@FindBy(how = How.ID, using = "add")
	private WebElement addComputerBtn;

	@FindBy(how = How.ID, using = "searchbox")
	private WebElement searchbox;

	@FindBy(how = How.ID, using = "searchsubmit")
	private WebElement filterBtn;

	@FindBy(how= How.XPATH, using = "//table[@class='computers zebra-striped']//following::tbody/tr[1]/td[1]/a")
    private WebElement computerNameInResult;

    @FindBy(how= How.XPATH, using = "//table[@class='computers zebra-striped']//following::tbody/tr[1]/td[2]")
    private WebElement introducedInResult;

    @FindBy(how= How.XPATH, using = "//table[@class='computers zebra-striped']//following::tbody/tr[1]/td[3]")
    private WebElement discontinuedInResult;

    @FindBy(how= How.XPATH, using = "//table[@class='computers zebra-striped']//following::tbody/tr[1]/td[4]")
    private WebElement companyInResult;

    public void clickOnAddComputer(){
        addComputerBtn.click();
    }

    public void searchComputer(String computerName){
        searchbox.click();
        searchbox.sendKeys(computerName);
        filterBtn.click();
    }

    public String verifyIntroducedDate(){
        String dt=introducedInResult.getText();
        return dt;
    }

    public void startEditingComputer(String computerName){
        searchComputer(computerName);
        computerNameInResult.click();
    }


}
