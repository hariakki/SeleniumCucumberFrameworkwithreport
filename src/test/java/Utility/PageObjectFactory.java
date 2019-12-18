package Utility;

import PageObjects.*;
import org.openqa.selenium.WebDriver;

/**
 * Holds instance of all the page classes and make sure only single object is present of particular page for the execution
 *
 * @author Arpit Kothari (arpitkothari45@gmail.com)
 * @version 1.0
 */
public class PageObjectFactory {

    private WebDriver driver;
    private HomePage homePage;
    private SignInPage signInPage;
    private RegistrationPage registrationPage;
    private SearchItemPage searchItemPage;

    public PageObjectFactory(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Gets instance of Home page class and if not present then creates one
     * @return
     */
    public HomePage getHomePage() {
        return (homePage == null) ? homePage = new HomePage(driver) : homePage;
    }

    /**
     * Gets instance of SignIn page class and if not present then creates one
     * @return
     */
    public SignInPage getSignInPage() {
        return (signInPage == null) ? signInPage = new SignInPage(driver) : signInPage;
    }

    /**
     * Gets instance of Registration page class and if not present then creates one
     * @return
     */
    public RegistrationPage getRegistrationPage() {
        return (registrationPage == null) ? registrationPage = new RegistrationPage(driver) : registrationPage;
    }

    /**
     * Gets instance of SearchItem page class and if not present then creates one
     * @return
     */
    public SearchItemPage getSearchItemPage() {
        return (searchItemPage == null) ? searchItemPage = new SearchItemPage(driver) : searchItemPage;
    }

}
