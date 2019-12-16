package Utility;

import PageObjects.CreateComputerPage;
import PageObjects.EditComputerPage;
import org.openqa.selenium.WebDriver;

public class PageObjectFactory {

    private WebDriver driver;
    private CreateComputerPage createComputerPage;
    private EditComputerPage editComputerPage;


    public PageObjectFactory(WebDriver driver) {
        this.driver = driver;
    }

    public CreateComputerPage getCreateComputerPage() {
        return (createComputerPage == null) ? createComputerPage= new CreateComputerPage(driver) : createComputerPage;
    }

    public EditComputerPage getEditComputerPage() {
        return (editComputerPage == null) ? editComputerPage= new EditComputerPage(driver) : editComputerPage;
    }

}
