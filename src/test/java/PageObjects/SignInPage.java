package PageObjects;

import Utility.BaseUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends BaseUtils {

    WebDriver driver;

    public SignInPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(how = How.ID, using = "dwfrm_login_username_default")
    public WebElement emailAddress;

    @FindBy(how = How.ID, using = "dwfrm_login_password_default")
    public WebElement password;

    @FindBy(how = How.ID, using = "dwfrm_preregister_username_default")
    public WebElement registerEmailAddress;

    @FindBy(how = How.NAME, using = "dwfrm_login_login")
    public WebElement signInBtn;

    @FindBy(how = How.NAME, using = "dwfrm_preregister_register")
    public WebElement registerBtn;

    @FindBy(how =How.ID,using = "login-errors")
    public WebElement loginError;

    @FindBy(how =How.ID,using = "dwfrm_preregister_username_default-error")
    public WebElement registrationError;

    public void loginWithExistingUser(String email,String pwd) throws InterruptedException {
        sendKeys(driver,emailAddress,email);
        sendKeys(driver,password,pwd);
        signInBtn.click();
    }

    public void registerForNewEmail(String registerEmail){
        sendKeys(driver,registerEmailAddress,registerEmail);
        Click(driver,registerBtn);
    }

}
