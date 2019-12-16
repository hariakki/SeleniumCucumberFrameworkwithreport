package Utility;

import cucumber.api.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BaseUtils {

    public void Click(WebDriver driver, By ele) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(ele));
        driver.findElement(ele).click();
    }

    public void selectFromDropdown(WebDriver driver, By ele, String text) {
        Select select = new Select(driver.findElement(ele));
        select.selectByVisibleText(text);
    }

    public String captureScreenShot(WebDriver ldriver, Scenario scenario) throws Exception {

        // Take screenshot and store as a file format
        File src = ((TakesScreenshot) ldriver).getScreenshotAs(OutputType.FILE);
        String destination = Constants.SCREENSHOTS_PATH + scenario.getName().replaceAll(" ","") + System.currentTimeMillis() + ".png";

        // now copy the screenshot to desired location using copyFile method
        FileUtils.copyFile(src, new File(destination));
        return destination;
    }

    public void createDirectory(String name) {
        Path path = Paths.get(name);
        // if directory exists?
        if (!Files.exists(path)) {
            try {
                Files.createDirectories(path);
            } catch (IOException e) {
                // fail to create directory
                e.printStackTrace();
            }
        }
    }


}
