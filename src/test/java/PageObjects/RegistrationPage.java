package PageObjects;

import Utility.BaseUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage extends BaseUtils {

    WebDriver driver;

    public RegistrationPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(how = How.ID,using = "dwfrm_profile_customer_gender_GB_1")
    public WebElement mr;

    @FindBy(how = How.ID,using = "dwfrm_profile_customer_gender_GB_2")
    public WebElement ms;

    @FindBy(how = How.ID,using = "dwfrm_profile_customer_name_firstname_GB")
    public WebElement firstName;

    @FindBy(how = How.ID,using = "dwfrm_profile_customer_name_lastname_GB")
    public WebElement lastName;

    @FindBy(how = How.ID,using = "dwfrm_profile_address_address1_GB")
    public WebElement address1;

    @FindBy(how = How.ID,using = "dwfrm_profile_address_postal_GB")
    public WebElement postalCode;

    @FindBy(how = How.ID,using = "dwfrm_profile_address_city_GB")
    public WebElement city;

    @FindBy(how = How.ID,using = "dwfrm_profile_login_password_GB")
    public WebElement password;

    @FindBy(how = How.ID,using = "dwfrm_profile_login_passwordconfirm_GB")
    public WebElement confirmPassword;

    @FindBy(how = How.NAME , using = "dwfrm_profile_confirm")
    public WebElement continueBtn;

    @FindBy(how = How.LINK_TEXT , using = "my details")
    public WebElement myDetailsLink;

    @FindBy(how=How.ID,using = "address-summary")
    public WebElement registrationFormError;

    public void fillRegistrationFormWithMandatoryDetails(String addressed,String fname,String lname,String address,String post,String ct,String pwd) throws InterruptedException {
     
        if(addressed.equalsIgnoreCase("mr")){
            jsClick(driver,mr);
        }else{
            jsClick(driver,ms);
        }
        sendKeys(driver,firstName,fname);
        sendKeys(driver,lastName,lname);
        sendKeys(driver,address1,address);
        sendKeys(driver,postalCode,post);
        sendKeys(driver,city,ct);
        sendKeys(driver,password,pwd);
        sendKeys(driver,confirmPassword,pwd);
        Click(driver,continueBtn);
    }



}
